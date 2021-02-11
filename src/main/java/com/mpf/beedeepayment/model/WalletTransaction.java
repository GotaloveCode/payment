package com.mpf.beedeepayment.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "wallet_transactions")
public class WalletTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private double amount;
    private String account;
    @Column(name = "user_id")
    private Integer userid;
    @Column(name = "transaction_number")
    private String transactionNumber;
    private LocalDateTime transaction_date;
    @Column(name = "payable_type")
    private String payableType;
    @Column(name = "payable_id")
    private String payableId;
    private String type;

    public WalletTransaction(Integer id, double amount, String account, Integer userid, String transactionNumber, LocalDateTime transaction_date, String payableType, String payableId, String type) {
        this.id = id;
        this.amount = amount;
        this.account = account;
        this.userid = userid;
        this.transactionNumber = transactionNumber;
        this.transaction_date = transaction_date;
        this.payableType = payableType;
        this.payableId = payableId;
        this.type = type;
    }

    public WalletTransaction(double amount, String account, Integer userid, String transactionNumber, LocalDateTime transaction_date, String payableType, String payableId, String type) {
        this.amount = amount;
        this.account = account;
        this.userid = userid;
        this.transactionNumber = transactionNumber;
        this.transaction_date = transaction_date;
        this.payableType = payableType;
        this.payableId = payableId;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public LocalDateTime getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(LocalDateTime transaction_date) {
        this.transaction_date = transaction_date;
    }

    public String getpayableType() {
        return payableType;
    }

    public void setpayableType(String payableType) {
        this.payableType = payableType;
    }

    public String getPayableId() {
        return payableId;
    }

    public void setPayableId(String payableId) {
        this.payableId = payableId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
