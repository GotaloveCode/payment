package com.mpf.beedeepayment.dao;

import com.mpf.beedeepayment.model.WalletTransaction;
import com.mpf.beedeepayment.repository.WalletTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class WalletTransactionDataAccessService {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    private WalletTransactionRepository walletTransactionRepository;

    @Autowired
    public WalletTransactionDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public WalletTransaction save(WalletTransaction transaction)
    {
        return walletTransactionRepository.save(transaction);
    }
}
