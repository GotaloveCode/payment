package com.mpf.beedeepayment.service;

import com.mpf.beedeepayment.dao.PaymentDataAccessService;
import com.mpf.beedeepayment.model.Bidbond;
import com.mpf.beedeepayment.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    private final PaymentDataAccessService paymentDataAccessService;

    @Autowired
    public PaymentService(PaymentDataAccessService paymentDataAccessService) {
        this.paymentDataAccessService = paymentDataAccessService;
    }

    public Page<Payment> getPayments(int page) {
        return paymentDataAccessService.getPayments(page);
    }

    public Page<Payment> searchBy(String term, int page) {
        return paymentDataAccessService.searchBy(term, page);
    }


    public List<Bidbond> getUnprocessedPayments() {
        return paymentDataAccessService.getUnprocessedPayments();
    }

    public Optional<Payment> getByAccount(String account) {
        return paymentDataAccessService.getByAccount(account);
    }

    public List<Payment> getByPayableIds(List<String> payable_ids) {
        return paymentDataAccessService.getByPayableIds(payable_ids);
    }

    public Optional<Payment> setProcessed(String account) {
        return paymentDataAccessService.setProcessed(account);
    }

}
