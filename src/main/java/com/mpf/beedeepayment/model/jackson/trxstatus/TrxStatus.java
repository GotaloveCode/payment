package com.mpf.beedeepayment.model.jackson.trxstatus;

public class TrxStatus {

    private Result result;

    /**
     * No args constructor for use in serialization
     */
    public TrxStatus() {
    }

    /**
     * @param result
     */
    public TrxStatus(Result result) {
        super();
        this.result = result;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

}
