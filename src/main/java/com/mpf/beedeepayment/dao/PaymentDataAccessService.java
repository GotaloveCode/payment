package com.mpf.beedeepayment.dao;

import com.mpf.beedeepayment.model.Payment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("paymentDao")
public class PaymentDataAccessService implements PaymentDao{
    private static List<Payment> payments = new ArrayList<>();

    @Override
    public int insertPayment(Payment payment) {
//        payments.add(new Payment(payment.getId(),))
        return 0;
    }

//    public List<Payment> getUnprocessedPayments()
//    {
//        $bidbonds = [];
//        $payments = Payment::select(['account','payable_id'])->where(['confirmed' => 1, 'processed' => 0, 'payable_type' => 'App\Bidbond'])->groupBy(['account','payable_id'])->get();
//        foreach ($payments as $payment){
//        $bidbond_amount = Payment::where('account', $payment->account)->sum('amount');
//        $bidbond = new stdClass();
//        $bidbond->secret = $payment->payable_id;
//        $bidbond->amount = $bidbond_amount;
//        array_push($bidbonds, $bidbond);
//    }
//        return response()->json($bidbonds);
//    }


//    public function getByPayableIds(Request $request)
//    {
//        $validator = Validator::make($request->all(), [
//        'payable_ids' => 'bail|required|array'
//        ]);
//
//        if ($validator->fails()) {
//            return response()->json([
//                    'status' => 'error',
//                    'error' => ['message' => $validator->errors()->all()]
//            ], 422);
//        }
//
//        return response()->json(Payment::whereIn('payable_id', $request->payable_ids)->latest()->paginate());
//    }
//
//    public function getByAccount($account)
//    {
//        $payment = Payment::where('account', $account)->exists();
//
//        if (!$payment) {
//            return response()->json([
//                    'status' => 'error',
//                    'error' => ['message' => 'Account not found']
//            ], 422);
//        }
//
//        return response()->json(Payment::where('account', $account)->latest()->first());
//    }


}
