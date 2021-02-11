package com.mpf.beedeepayment.dao;

import com.mpf.beedeepayment.model.Wallet;
import com.mpf.beedeepayment.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class WalletDataAccessService {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    public WalletDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Wallet save(Wallet wallet)
    {
        return walletRepository.save(wallet);
    }

    public Optional<Wallet> findByTypeAndTypeId(String type, String typeId) {
        return walletRepository.findByTypeAndTypeId(type, typeId);
    }
}
