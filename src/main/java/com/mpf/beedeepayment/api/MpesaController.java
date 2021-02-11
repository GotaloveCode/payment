package com.mpf.beedeepayment.api;

import com.mpf.beedeepayment.model.jackson.Mpesa;
import com.mpf.beedeepayment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/safaricom")
@RestController
public class MpesaController {
    private final PaymentService paymentService;

    @Autowired
    public MpesaController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping(path = "/c2b/validation/callback/{secret}")
    public void c2bValidation(@PathVariable("secret") @RequestBody Mpesa mpesa) {
        insertPaymentDetails(mpesa);
    }


//    @PostMapping
//    public c2bValidation(@NonNull @RequestBody Mpesa mpesa) {
//        $response = $request->all();
//
//        Log::info('C2B Validation: ' . request()->ip());
//        Log::info($response);
//
//        insertPaymentDetails(mpesa);
//
//        $message = ["ResultCode" => 0, "ResultDesc" => "Success", "ThirdPartyTransID" => ""];

//        if (config('app.url') !== 'http://payment.test') {
//            TransactionQuery::dispatch($response['TransID'])->delay(now()->addSeconds(3));
//        }

//        info("c2bvalidation", $message);
//        return response()->json($message);
//    }

    private void insertPaymentDetails(Mpesa mpesa) {
        String mpesa_transaction_id = mpesa.getTransID();
        String date_time = mpesa.getTransTime();
        String amount = mpesa.getTransAmount();
        String account = mpesa.getBillRefNumber().toUpperCase().replaceAll("/\\s+/", " ");
        //strtoupper(preg_replace('/\s+/', '', $response['BillRefNumber']));
        String phone = mpesa.getMSISDN();
        String payer = mpesa.getFirstName() + ' ' + mpesa.getMiddleName() + ' ' + mpesa.getLastName();
//        String payer = preg_replace('!\s+!', ' ', ucwords(name.toLowerCase()));
        String typeId = "";
        if(mpesa.getTypeId().isEmpty()){
            typeId =  account.substring(2);
        }else{
            typeId = mpesa.getTypeId();
        }

        if (mpesa_transaction_id.isEmpty() || date_time.isEmpty() || amount.isEmpty() || account.isEmpty() || phone.isEmpty() || payer.isEmpty()) {
//            return response()->json(["ResultCode" => 1, "ResultDesc" => "Failure"]);
        }
    }
}
