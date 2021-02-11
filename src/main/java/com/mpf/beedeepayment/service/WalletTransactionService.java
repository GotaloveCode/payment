package com.mpf.beedeepayment.service;

import com.mpf.beedeepayment.dao.WalletTransactionDataAccessService;
import com.mpf.beedeepayment.model.WalletTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletTransactionService {

    private final WalletTransactionDataAccessService service;
    @Autowired
    public WalletTransactionService(WalletTransactionDataAccessService service) {
        this.service = service;
    }

    public WalletTransaction save(WalletTransaction transaction)
    {
        return service.save(transaction);
    }
}
