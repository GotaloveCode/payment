package com.mpf.beedeepayment.model.jackson.trxconfirm;

import java.util.List;

public class TrxConfirmation {

    private Body body;

    /**
     * No args constructor for use in serialization
     *
     */
    public TrxConfirmation() {
    }

    /**
     *
     * @param body
     */
    public TrxConfirmation(Body body) {
        super();
        this.body = body;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("body: "+ body).toString();
    }


}



