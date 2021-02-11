package com.mpf.beedeepayment.service;

import com.mpf.beedeepayment.dao.WalletDataAccessService;
import com.mpf.beedeepayment.model.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WalletService {

    private final WalletDataAccessService walletDataAccessService;

    @Autowired
    public WalletService(WalletDataAccessService walletDataAccessService) {
        this.walletDataAccessService = walletDataAccessService;
    }

    public Wallet save(Wallet wallet) {
        return walletDataAccessService.save(wallet);
    }

    public Optional<Wallet> findByTypeAndTypeId(String type, String typeId) {
        return walletDataAccessService.findByTypeAndTypeId(type, typeId);
    }
}
