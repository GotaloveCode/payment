package com.mpf.beedeepayment.dao;

import com.mpf.beedeepayment.model.Payment;

import java.util.List;

public interface PaymentDao {

    int insertPayment(Payment payment);

    List<Payment> payments;
}
