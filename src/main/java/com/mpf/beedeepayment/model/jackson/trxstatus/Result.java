package com.mpf.beedeepayment.model.jackson.trxstatus;


public class Result {

    private Integer resultType;
    private Integer resultCode;
    private String resultDesc;
    private String originatorConversationID;
    private String conversationID;
    private String transactionID;
    private ResultParameters resultParameters;

    /**
     * No args constructor for use in serialization
     */
    public Result() {
    }

    /**
     * @param resultParameters
     * @param conversationID
     * @param resultCode
     * @param originatorConversationID
     * @param resultDesc
     * @param resultType
     * @param transactionID
     */
    public Result(Integer resultType, Integer resultCode, String resultDesc, String originatorConversationID, String conversationID, String transactionID, ResultParameters resultParameters) {
        super();
        this.resultType = resultType;
        this.resultCode = resultCode;
        this.resultDesc = resultDesc;
        this.originatorConversationID = originatorConversationID;
        this.conversationID = conversationID;
        this.transactionID = transactionID;
        this.resultParameters = resultParameters;
    }

    public Integer getResultType() {
        return resultType;
    }

    public void setResultType(Integer resultType) {
        this.resultType = resultType;
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

    public String getOriginatorConversationID() {
        return originatorConversationID;
    }

    public void setOriginatorConversationID(String originatorConversationID) {
        this.originatorConversationID = originatorConversationID;
    }

    public String getConversationID() {
        return conversationID;
    }

    public void setConversationID(String conversationID) {
        this.conversationID = conversationID;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public ResultParameters getResultParameters() {
        return resultParameters;
    }

    public void setResultParameters(ResultParameters resultParameters) {
        this.resultParameters = resultParameters;
    }

}



