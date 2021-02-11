package com.mpf.beedeepayment.model;

import javax.persistence.*;

@Entity(name = "wallets")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type;
    @Column(name = "type_id")
    private String typeId;
    private double balance;

    public Wallet(Integer id,String type,String typeId,double balance){
        this.id = id;
        this.type = type;
        this.typeId = typeId;
        this.balance = balance;
    }

    public Wallet(String type,String typeId,double balance){
        this.type = type;
        this.typeId = typeId;
        this.balance = balance;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String gettypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
