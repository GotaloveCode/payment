package com.mpf.beedeepayment.model.jackson.trxconfirm;

public class StkCallback {

    private String merchantRequestID;
    private String checkoutRequestID;
    private Integer resultCode;
    private String resultDesc;
    private CallbackMetadata callbackMetadata;

    /**
     * No args constructor for use in serialization
     */
    public StkCallback() {
    }

    /**
     * @param callbackMetadata
     * @param resultCode
     * @param checkoutRequestID
     * @param resultDesc
     * @param merchantRequestID
     */
    public StkCallback(String merchantRequestID, String checkoutRequestID, Integer resultCode, String resultDesc, CallbackMetadata callbackMetadata) {
        super();
        this.merchantRequestID = merchantRequestID;
        this.checkoutRequestID = checkoutRequestID;
        this.resultCode = resultCode;
        this.resultDesc = resultDesc;
        this.callbackMetadata = callbackMetadata;
    }

    public String getMerchantRequestID() {
        return merchantRequestID;
    }

    public void setMerchantRequestID(String merchantRequestID) {
        this.merchantRequestID = merchantRequestID;
    }

    public String getCheckoutRequestID() {
        return checkoutRequestID;
    }

    public void setCheckoutRequestID(String checkoutRequestID) {
        this.checkoutRequestID = checkoutRequestID;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

    public CallbackMetadata getCallbackMetadata() {
        return callbackMetadata;
    }

    public void setCallbackMetadata(CallbackMetadata callbackMetadata) {
        this.callbackMetadata = callbackMetadata;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("merchantRequestID: " + merchantRequestID).append("checkoutRequestID: " + checkoutRequestID).append("resultCode: " + resultCode).append("resultDesc" + resultDesc).append("callbackMetadata" + callbackMetadata).toString();
    }
}
