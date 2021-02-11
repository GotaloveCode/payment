package com.mpf.beedeepayment.repository;

import com.mpf.beedeepayment.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {

    Optional<Wallet> findByTypeAndTypeId(String type, String typeId);
}
