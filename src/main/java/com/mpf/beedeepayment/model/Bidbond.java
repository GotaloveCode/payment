package com.mpf.beedeepayment.model;

public class Bidbond {
    private String secret;
    private double amount;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Bidbond(String secret, double amount) {
        this.secret = secret;
        this.amount = amount;
    }
}
