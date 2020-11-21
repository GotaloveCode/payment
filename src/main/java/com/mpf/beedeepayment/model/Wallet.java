package com.mpf.beedeepayment.model;

public class Wallet {
    private final Integer id;
    private final String type;
    private final String type_id;
    private final double balance;

    public Wallet(Integer id,String type,String type_id,double balance){
        this.id = id;
        this.type = type;
        this.type_id = type_id;
        this.balance = balance;
    }


    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getType_id() {
        return type_id;
    }

    public double getBalance() {
        return balance;
    }
}
