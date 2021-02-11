package com.mpf.beedeepayment.repository;

import com.mpf.beedeepayment.model.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

//    @Modifying
//    @Query("update payments set paid = 1 where account = :account")
//    void setPaid(@Param(value = "account") String account);


    List<Payment> findByAccount(String account);

    List<Payment> findByPayableIdIn(List<String> payable_ids);

    @Query("SELECT SUM(amount) FROM payments where account = :account")
    Double totalPayment(String account);

    Page<Payment> findByNameLikeOrPhoneOrAccountOrTransactionNumber(String term1, String term2, String term3, String term4, Pageable pageable);

}
