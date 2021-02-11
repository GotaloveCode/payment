package com.mpf.beedeepayment.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String phone;
    private double amount;
    private String account;
    @Column(name = "transaction_number")
    private String transactionNumber;
    private String transaction_date;
    private String payable_type;
    @Column(name = "payable_id")
    private String payableId;
    private boolean processed;
    private boolean confirmed;
    private String payment_method;
    @CreationTimestamp
    private LocalDateTime created_at;
    @UpdateTimestamp
    private LocalDateTime updated_at;

    public Payment() {
    }
//    public Payment(Integer id, String phone, double amount, String account, String transaction_number,
//                   String transaction_date, String payable_type, String payable_id,
//                   boolean processed, boolean confirmed, String payment_method) {
//        this.id = id;
//        this.phone = phone;
//        this.amount = amount;
//        this.account = account;
//        this.transaction_number = transaction_number;
//        this.transaction_date = transaction_date;
//        this.payable_type = payable_type;
//        this.payable_id = payable_id;
//        this.processed = processed;
//        this.confirmed = confirmed;
//        this.payment_method = payment_method;
//    }

    public Payment(Integer id, String name, String phone, double amount, String account, String transactionNumber,
                   String transaction_date, String payable_type, String payableId,
                   boolean processed, boolean confirmed, String payment_method,
                   LocalDateTime created_at, LocalDateTime updated_at) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.amount = amount;
        this.account = account;
        this.transactionNumber = transactionNumber;
        this.transaction_date = transaction_date;
        this.payable_type = payable_type;
        this.payableId = payableId;
        this.processed = processed;
        this.confirmed = confirmed;
        this.payment_method = payment_method;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public double getAmount() {
        return amount;
    }

    public String getAccount() {
        return account;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public String getTransaction_date() {
        return transaction_date;
    }

    public String getPayable_type() {
        return payable_type;
    }

    public String getPayableId() {
        return payableId;
    }

    public boolean isProcessed() {
        return processed;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Payment(int id, String phone, double amount, String account, String transaction_number, String transaction_date,
//                   String payable_type, String payable_id, boolean processed, boolean confirmed, String payment_method) {
//        this.id = id;
//        this.phone = phone;
//        this.amount = amount;
//        this.account = account;
//        this.transaction_number = transaction_number;
//        this.transaction_date = transaction_date;
//        this.payable_type = payable_type;
//        this.payable_id = payable_id;
//        this.processed = processed;
//        this.confirmed = confirmed;
//        this.payment_method = payment_method;
//    }
//
//    @Id
//    public int getId() {
//        return id;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public double getAmount() {
//        return amount;
//    }
//
//    public String getAccount() {
//        return account;
//    }
//
//    public String getTransaction_number() {
//        return transaction_number;
//    }
//
//    public String getTransaction_date() {
//        return transaction_date;
//    }
//
//    public String getPayable_type() {
//        return payable_type;
//    }
//
//    public String getPayable_id() {
//        return payable_id;
//    }
//
//    public boolean isProcessed() {
//        return processed;
//    }
//
//    public boolean isConfirmed() {
//        return confirmed;
//    }
//
//    public String getPayment_method() {
//        return payment_method;
//    }

//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getId() {
//        return id;
//    }
//    $table->increments('id');
//    $table->string('name');
//    $table->string('phone')->nullable();
//    $table->integer('amount');
//    $table->string('account');
//    $table->integer('customer_id')->nullable()->default(null);
//    $table->string('companyid')->nullable();
//    $table->string('transaction_number');
//    $table->dateTime('transaction_date');
//    $table->string('payable_type');
//    $table->string('payable_id');
//    $table->boolean('processed')->default(0);
//    $table->boolean('confirmed')->default(0);
//    $table->string('payment_method')->nullable();
//    $table->timestamps();
}
