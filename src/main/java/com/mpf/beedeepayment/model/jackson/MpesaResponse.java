package com.mpf.beedeepayment.model.jackson;

public class MpesaResponse {
    public MpesaResponse(Integer resultCode, String resultDesc) {
        ResultCode = resultCode;
        ResultDesc = resultDesc;
    }

    public Integer getResultCode() {
        return ResultCode;
    }

    public void setResultCode(Integer resultCode) {
        ResultCode = resultCode;
    }

    public Integer ResultCode;
    public String ResultDesc;
}
