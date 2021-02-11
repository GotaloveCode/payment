package com.mpf.beedeepayment.model.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountResponse {
    @JsonProperty("account")
    private String account;

    public AccountResponse() {}

    public AccountResponse(String account) {
        this.account = account;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
