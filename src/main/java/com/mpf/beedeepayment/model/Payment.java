package com.mpf.beedeepayment.model;

public class Payment {
    private final int id;
    private final String phone;
    private final double amount;
    private final String account;
    private final String transaction_number;
    private final String transaction_date;
    private final String payable_type;
    private final String payable_id;
    private final boolean processed;
    private final boolean confirmed;
    private final String payment_method;


    public Payment(int id, String phone, double amount, String account, String transaction_number, String transaction_date,
                   String payable_type, String payable_id, boolean processed, boolean confirmed, String payment_method) {
        this.id = id;
        this.phone = phone;
        this.amount = amount;
        this.account = account;
        this.transaction_number = transaction_number;
        this.transaction_date = transaction_date;
        this.payable_type = payable_type;
        this.payable_id = payable_id;
        this.processed = processed;
        this.confirmed = confirmed;
        this.payment_method = payment_method;
    }

    public int getId() {
        return id;
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

    public String getTransaction_number() {
        return transaction_number;
    }

    public String getTransaction_date() {
        return transaction_date;
    }

    public String getPayable_type() {
        return payable_type;
    }

    public String getPayable_id() {
        return payable_id;
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
