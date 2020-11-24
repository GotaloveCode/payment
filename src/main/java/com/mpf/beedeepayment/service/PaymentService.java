package com.mpf.beedeepayment.service;

import com.mpf.beedeepayment.dao.PaymentDao;
import com.mpf.beedeepayment.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private final PaymentDao paymentDao;

    @Autowired
    public PaymentService(@Qualifier("paymentDao") PaymentDao paymentDao)
    {
        this.paymentDao = paymentDao;
    }

    public int insertPayment(Payment payment)
    {
        return this.paymentDao.insertPayment(payment);
    }

//    public List<Payment> getPayments()
//    {
//        return paymentDao.
//    }
}
