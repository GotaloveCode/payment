package com.mpf.beedeepayment.api;

import com.mpf.beedeepayment.dao.PaymentDataAccessService;
import com.mpf.beedeepayment.model.Payment;
import com.mpf.beedeepayment.model.Wallet;
import com.mpf.beedeepayment.model.WalletTransaction;
import com.mpf.beedeepayment.model.jackson.Mpesa;
import com.mpf.beedeepayment.service.PaymentService;
import com.mpf.beedeepayment.service.WalletService;
import com.mpf.beedeepayment.service.WalletTransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RequestMapping("/api/safaricom")
@RestController
public class MpesaController {
    private final PaymentService paymentService;
    private final WalletService walletService;
    private final WalletTransactionService walletTransactionService;
    Logger logger = LoggerFactory.getLogger(PaymentDataAccessService.class);

    @Autowired
    public MpesaController(PaymentService paymentService, WalletService walletService, WalletTransactionService walletTransactionService) {
        this.paymentService = paymentService;
        this.walletService = walletService;
        this.walletTransactionService = walletTransactionService;
    }

    @PostMapping(path = "/c2b/validation/callback/{secret}")
    public ResponseEntity<Map<String, Object>> c2bValidation(@PathVariable("secret") String secret, @RequestBody Mpesa mpesa) {
        Boolean inserted = insertPaymentDetails(mpesa);
        if (!inserted) {
            return failedMpesaCallBack();
        }

        Map<String, Object> response = new HashMap<>();
        response.put("ResultCode", 0);
        response.put("ResultDesc", "Success");
        response.put("ThirdPartyTransID", "");

//        if (config('app.url') !== 'http://payment.test') {
//            TransactionQuery::dispatch($response['TransID'])->delay(now()->addSeconds(3));
//        }
        logger.info("c2bvalidation", response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(path = "/c2b/confirmation/callback/{secret}")
    public ResponseEntity<Map<String, Object>> c2bConfirmation(@PathVariable("secret") String secret, @RequestBody Mpesa mpesa) {
        logger.info("C2B Confirmation", mpesa);
        if (mpesa.getTransID() == null) {
            return failedMpesaCallBack();
        }

        Optional<Payment> payment = paymentService.findByTransactionNumber(mpesa.getTransID());

        if (payment.isEmpty()) {
            insertPaymentDetails(mpesa);
        }

        updatePayment(mpesa.getTransID());

        return successfulMpesaCallBack();
    }

    private Boolean insertPaymentDetails(Mpesa mpesa) {
        String mpesa_transaction_id = mpesa.getTransID();
        final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        LocalDateTime date_time = LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.parseLong(mpesa.getTransTime())), ZoneId.systemDefault());
        Double amount = Double.parseDouble(mpesa.getTransAmount());
        String account = mpesa.getBillRefNumber().toUpperCase().replaceAll("/\\s+/", " ");
        String phone = mpesa.getMSISDN();
        String payer = mpesa.getFirstName() + ' ' + mpesa.getMiddleName() + ' ' + mpesa.getLastName();
        String typeId;
        if (mpesa.getTypeId() != null) {
            typeId = mpesa.getTypeId();

        } else {
            typeId = account.substring(2);
        }

        if (mpesa_transaction_id.isEmpty() || phone.isEmpty() || payer.isEmpty()) {
            return true;
        }

        Optional<Payment> payment = paymentService.findByTransactionNumber(mpesa_transaction_id);

        if (payment.isEmpty()) {
            String payable_type = "";
            switch (account.substring(0, 1)) {
                case "A":
                    payable_type = "App\\\\Agent";
                    break;
                case "B":
                    payable_type = "App\\\\Bidbond";
                    break;
                case "C":
                    payable_type = "App\\\\Company";
                    break;
            }

            Payment payment1 = new Payment(
                    payer, phone, amount, account, mpesa_transaction_id, date_time,
                    payable_type, typeId, "MPESA");

            paymentService.save(payment1);
        }
        return true;
    }

    private ResponseEntity<Map<String, Object>> failedMpesaCallBack() {
        Map<String, Object> response = new HashMap<>();
        response.put("ResultCode", 1);
        response.put("ResultDesc", "Failure");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private ResponseEntity<Map<String, Object>> successfulMpesaCallBack() {
        Map<String, Object> response = new HashMap<>();
        response.put("ResultCode", 0);
        response.put("ResultDesc", "Success");
        response.put("ThirdPartyTransID", "");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void updatePayment(String mpesa_transaction_id) {
        Optional<Payment> payment1 = paymentService.findByTransactionNumber(mpesa_transaction_id);

        if (payment1.isPresent()) {
            Payment payment = payment1.get();
            if (!payment.isConfirmed()) {
                payment.setConfirmed(true);
                if (payment.getAccount().charAt(1) == 'W') {
                    topUp(payment);
                    payment.setProcessed(true);
                }
                paymentService.save(payment);
            }
        }
    }

    private void topUp(Payment payment) {
        String type = "";
        if (payment.getAccount().charAt(0) == 'C') {
            type = "Company";
        } else {
            type = "Agent";
        }

        Optional<Wallet> wallet1 = walletService.findByTypeAndTypeId(type, payment.getPayableId());

        if (wallet1.isEmpty()) {
            walletService.save(new Wallet(type, payment.getPayableId(), payment.getAmount()));
        } else {
            Wallet wallet = wallet1.get();
            wallet.setBalance(wallet.getBalance() + payment.getAmount());
            walletService.save(wallet);
        }

        walletTransactionService.save(
                new WalletTransaction(
                        payment.getAmount(), payment.getAccount(), payment.getId(),
                        "WX",
                        payment.getTransaction_date(), type, payment.getPayableId(), "debit"
                )
        );

//        $wallet_transaction->transaction_number = getToken(10, 'capnum', 'WX');
    }

//
//    public function trxStatusTimeout(Request $request)
//    {
//        $response = $request->all();
//        Log::info($response);
//
//        return response()->json(["ResultCode" => 0, "ResultDesc" => "Success"]);
//    }
}
