package com.mpf.beedeepayment.model.jackson.trxconfirm;

public class Body {

    private StkCallback stkCallback;

    /**
     * No args constructor for use in serialization
     */
    public Body() {
    }

    /**
     * @param stkCallback
     */
    public Body(StkCallback stkCallback) {
        super();
        this.stkCallback = stkCallback;
    }

    public StkCallback getStkCallback() {
        return stkCallback;
    }

    public void setStkCallback(StkCallback stkCallback) {
        this.stkCallback = stkCallback;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(stkCallback).toString();
    }

}
