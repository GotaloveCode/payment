package com.mpf.beedeepayment.api;

import com.mpf.beedeepayment.dao.PaymentDataAccessService;
import com.mpf.beedeepayment.model.Bidbond;
import com.mpf.beedeepayment.model.Payment;
import com.mpf.beedeepayment.model.jackson.AccountResponse;
import com.mpf.beedeepayment.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class PaymentController {
    Logger logger = LoggerFactory.getLogger(PaymentDataAccessService.class);
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping(path = "/payments")
    public ResponseEntity<Map<String, Object>> getPayments(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(required = false) String search) {
        try {
            Page<Payment> pagePayments;
            if (search.isEmpty())
                pagePayments = paymentService.getPayments(page);
            else
                pagePayments = paymentService.searchBy(search, page);

            Map<String, Object> response = new HashMap<>();
            response.put("data", pagePayments.getContent());
            response.put("current_page", pagePayments.getNumber());
            response.put("total", pagePayments.getTotalElements());
            response.put("to", pagePayments.getTotalPages());
            response.put("per_page", pagePayments.getSize());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(path = "/payments/unprocessed")
    public List<Bidbond> getUnprocessedPayments() {
        return paymentService.getUnprocessedPayments();
    }

    @RequestMapping(path = "/payments/{account}/account")
    public Optional<Payment> getByAccount(@PathVariable("account") String account) {
        return paymentService.getByAccount(account);
    }

    @RequestMapping(path = "/payments/account")
    public List<Payment> getByPayableIds(@RequestParam List<String> payable_ids) {
        return paymentService.getByPayableIds(payable_ids);
    }

    @PostMapping(path = "/payments/paid",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public Optional<Payment> setPaid(@RequestBody AccountResponse account) {
        return paymentService.setProcessed(account.getAccount());
    }

}


//    public function c2bValidation(Request $request, $secret)
//    {
//        $response = $request->all();
//
//        Log::info('C2B Validation: ' . request()->ip());
//        Log::info($response);
//
//        $this->insertPaymentDetails($response);
//
//        $message = ["ResultCode" => 0, "ResultDesc" => "Success", "ThirdPartyTransID" => ""];
//
//        if (config('app.url') !== 'http://payment.test') {
//            TransactionQuery::dispatch($response['TransID'])->delay(now()->addSeconds(3));
//        }
//
//        info("c2bvalidation", $message);
//        return response()->json($message);
//    }
//
//    public function c2bConfirmation(Request $request, $secret)
//    {
//        $response = $request->all();
//
//        Log::info('C2B Confirmation: ' . request()->ip());
//        Log::info($response);
//
//        $mpesa_transaction_id = $response['TransID'];
//
//        if (!$mpesa_transaction_id) {
//            return response()->json(["ResultCode" => 1, "ResultDesc" => "Failure"]);
//        }
//
//        $payment = Payment::where('transaction_number', $mpesa_transaction_id)->first();
//
//        if(!$payment){
//            $this->insertPaymentDetails($response);
//        }
//
//        $this->updatePayment($mpesa_transaction_id);
//
//        return response()->json(["ResultCode" => 0, "ResultDesc" => "Success"]);
//    }
//
//    public function trxStatusTimeout(Request $request)
//    {
//        $response = $request->all();
//        Log::info($response);
//
//        return response()->json(["ResultCode" => 0, "ResultDesc" => "Success"]);
//    }
//
//    public function trxStatusConfirmation(Request $request, $secret)
//    {
//        $response = $request->all();
//
//        $result_code = $response['Result']['ResultCode'];
//        $result_type = $response['Result']['ResultType'];
//        if ($result_code == '0' && $result_type == '0') {
//            $collection = collect($response['Result']['ResultParameters']['ResultParameter']);
//
//            $transaction = $collection->where('Key', 'ReceiptNo')->first();
//            $status = $collection->where('Key', 'TransactionStatus')->first();
//
//            if ($status['Value'] === 'Completed') {
//                $this->updatePayment($transaction['Value']);
//            }
//        }
//
//        return response()->json(["ResultCode" => 0, "ResultDesc" => "Success"]);
//    }
//
//    public function stkConfirmation(Request $request, $secret)
//    {
//        $response = $request->all();
//        Log::info('STK Confirmation: ' . request()->ip());
//        Log::info($response);
//
//        $result_code = $response['Body']['stkCallback']['ResultCode'];
//        if ($result_code == '0') {
//            $collection = collect($response['Body']['stkCallback']['CallbackMetadata']['Item']);
//
//            $transaction = $collection->where('Name', 'MpesaReceiptNumber')->first();
//            $this->updatePayment($transaction['Value']);
//        }
//
//        $message = ["ResultCode" => 0, "ResultDesc" => "Success"];
//
//        return response()->json($message);
//    }
//
//    private function updatePayment($transaction)
//    {
//        $payment = Payment::where('transaction_number', $transaction)->first();
//
//        if ($payment) {
//            if (!$payment->confirmed) {
//                $payment->confirmed = 1;
//
//                if (substr($payment->account, 1, 1) === 'W') {
//                    $this->topUp($payment);
//                    $payment->processed = 1;
//                }
//
//                $payment->save();
//            }
//        }
//    }
//
//    /**
//     * @param $payment
//     */
//    protected function topUp($payment): void
//    {
//        if ($payment->account[0] == "C") {
//            $type = "Company";
//        } else {
//            $type = "Agent";
//        }
//
//        $wallet = Wallet::firstOrCreate(['type' => $type, 'type_id' => $payment->payable_id], ['balance' => 0]);
//        $wallet->balance = $wallet->balance + $payment->amount;
//        $wallet->save();
//
//        //create wallet transaction
//        $wallet_transaction = new WalletTransaction;
//        $wallet_transaction->amount = $payment->amount;
//        $wallet_transaction->user_id = $payment->id;
//        $wallet_transaction->account = $payment->account;
//        $wallet_transaction->transaction_number = getToken(10, 'capnum', 'WX');
//        $wallet_transaction->transaction_date = Carbon::now();
//        $wallet_transaction->payable_type = $type;
//        $wallet_transaction->payable_id = $payment->payable_id;
//        $wallet_transaction->type = "debit";
//        $wallet_transaction->save();
//
//    }
//
//    public function requestPayment(Request $request)
//    {
//        $phone = $request->input('phone');
//        $phone = preg_replace('/0/', '254', $phone, 1);
//        $amount = $request->input('amount');
//        $account = $request->input('account');
//        $mpesa = MPESA::stkPush($phone, $amount, $account);
//        return response()->json($mpesa);
//    }
//
//    public function confirmPayment(Request $request)
//    {
//        $validator = Validator::make($request->all(), [
//        'account' => 'required',
//            'expected_amount' => 'required'
//        ]);
//
//        if ($validator->fails()) {
//            return response()->json([
//                    'status' => 'error',
//                    'confirmed' => false,
//                    'error' => ['message' => $validator->errors()->all()]
//            ], 422);
//        }
//
//        if (substr($request->input('account'), 1, 1) === 'W') {
//            $payment = Payment::where('account', $request->input('account'))
//                ->latest()->first();
//
//            return response()->json([
//                    'status' => 'success',
//                    'confirmed' => true,
//                    'account' => $request->input('account'),
//                    'transaction_number' => $payment->transaction_number,
//                    'message' => 'Payment confirmed and processed.'
//                ], 200);
//        }
//
//        //Handle edge case
//        $payment = Payment::where('account', $request->input('account'))
//            ->where('processed', 0)
//            ->where('confirmed', 1)->latest()->first();;
//        //check sum of total payments
//        $total_paid = Payment::where('account', $request->input('account'))->where('processed', 0)
//            ->where('confirmed', 1)
//            ->sum('amount');
//
//        if ($total_paid == 0) {
//            return response()->json([
//                    'status' => 'error',
//                    'confirmed' => false,
//                    'error' => [
//            'code' => 'input_invalid',
//                    'message' => 'Payment not received. Make payment and try again.'
//                ]
//            ], 200);
//        } else if ($total_paid < $request->expected_amount) {
//            $bal = $request->expected_amount - $total_paid;
//            return response()->json([
//                    'status' => 'error',
//                    'confirmed' => false,
//                    'code' => 'amount_insufficient',
//                    'total_paid' => $total_paid,
//                    'error' => [
//            'code' => 'input_invalid',
//                    'message' => 'Top up ' . $bal . ' to complete your payment.'
//                ]], 200);
//        }
//
//        return response()->json([
//            'status' => 'success',
//            'confirmed' => true,
//            'account' => $request->input('account'),
//            'total_paid' => $total_paid,
//            'transaction_number' => $payment->transaction_number,
//            'message' => 'Payment confirmed and processed.'
//            ], 200);
//    }
//
//    public function confirmTRX(Request $request)
//    {
//        $validator = Validator::make($request->all(), [
//        'transaction_code' => 'bail|exists:payments,transaction_number',
//        ]);
//
//        if ($validator->fails()) {
//            return response()->json([
//                    'status' => 'error',
//                    'code' => 'no_payment',
//                    'confirmed' => false,
//                    'error' => [
//            'code' => 'input_invalid',
//                    'message' => $validator->errors()->all()
//                ]
//            ], 422);
//        }
//
//        $payment = Payment::where('transaction_number', strtoupper($request->input('transaction_code')))
//            ->where('processed', 0)->where('confirmed', 1)->first();
//
//        $expected_amount = $request->input('amount');
//
//        if ($payment) {
//            $total_paid = Payment::where('account', $payment->account)->where('processed', 0)
//                ->where('confirmed', 1)
//                ->sum('amount');
//
//            if ($expected_amount > $total_paid) {
//                $diff = $expected_amount - $total_paid;
//                return response()->json([
//                        'status' => 'error',
//                        'confirmed' => false,
//                        'error' => [
//                'code' => 'amount_insufficient',
//                        'balance' => $diff,
//                        'total_paid' => $total_paid,
//                        'message' => 'Payment received for a total of KSHS ' . $total_paid . ' .Pay KES ' . $diff . ' more to complete transaction',
//                    ]
//                ], 422);
//            }
//            return response()->json([
//                    'status' => 'success',
//                    'confirmed' => true,
//                    'account' => $payment->account,
//                    'transaction_number' => $payment->transaction_number,
//                    'total_paid' => $total_paid,
//                    'message' => 'Payment received for a total of KSHS ' . $total_paid
//            ], 200);
//
//        } else {
//            return response()->json([
//                    'status' => 'error',
//                    'confirmed' => false,
//                    'code' => 'no_payment',
//                    'error' => [
//            'code' => 'input_invalid',
//                    'message' => 'Payment not received. Make payment and try again.'
//                ]
//            ], 200);
//        }
//    }

