package com.mpf.beedeepayment.dao;

import com.mpf.beedeepayment.model.Bidbond;
import com.mpf.beedeepayment.model.Payment;
import com.mpf.beedeepayment.repository.PaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Repository
public class PaymentDataAccessService {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    public PaymentDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<Payment> getByAccount(String account) {
        List<Payment> payments = paymentRepository.findByAccount(account);
        return payments.stream().findFirst();
    }

    public Page<Payment> getPayments(int page) {
        return paymentRepository.findAll(PageRequest.of(page, 15));
    }

    public Page<Payment> searchBy(String term, int page) {
        return paymentRepository.findByNameLikeOrPhoneOrAccountOrTransactionNumber(term, term, term, term, PageRequest.of(page, 15));
    }

    public List<Bidbond> getUnprocessedPayments() {
        List<String> payments = jdbcTemplate.queryForList("SELECT account FROM payments WHERE confirmed=1 AND processed=0 AND payable_type='App\\\\Bidbond' GROUP BY account,payable_id", String.class);
        List<Bidbond> bid_payments = new ArrayList<>(payments.size());
        for (String account : payments)
            bid_payments.add(new Bidbond(account, paymentRepository.totalPayment(account)));

        return bid_payments;
    }

    public List<Payment> getByPayableIds(List<String> payable_ids) {
        return paymentRepository.findByPayableIdIn(payable_ids);
    }

    public Optional<Payment> setProcessed(String account) {
        List<Payment> payments = paymentRepository.findByAccount(account);

        payments.forEach(payment -> {
            payment.setProcessed(true);
        });
        paymentRepository.saveAll(payments);
        return payments.stream().findFirst();
    }

}


class PaymentMapper implements RowMapper<Payment> {
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Payment mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Payment(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("phone"),
                Double.parseDouble(rs.getString("amount")),
                rs.getString("account"),
                rs.getString("transaction_number"),
                rs.getString("transaction_date"),
                rs.getString("payable_type"),
                rs.getString("payable_id"),
                rs.getBoolean("processed"),
                rs.getBoolean("confirmed"),
                rs.getString("payment_method"),
                LocalDateTime.parse(rs.getString("created_at"), formatter),
                LocalDateTime.parse(rs.getString("updated_at"), formatter)
        );
    }
}


