package com.mpf.beedeepayment.model.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "TransactionType",
        "TransID",
        "TransTime",
        "TransAmount",
        "BusinessShortCode",
        "BillRefNumber",
        "InvoiceNumber",
        "OrgAccountBalance",
        "ThirdPartyTransID",
        "MSISDN",
        "FirstName",
        "MiddleName",
        "LastName"
})
public class Mpesa {

    @JsonProperty("TransactionType")
    private String transactionType;
    @JsonProperty("TransID")
    private String transID;
    @JsonProperty("TransTime")
    private String transTime;
    @JsonProperty("TransAmount")
    private String transAmount;
    @JsonProperty("BusinessShortCode")
    private String businessShortCode;
    @JsonProperty("BillRefNumber")
    private String billRefNumber;
    @JsonProperty("InvoiceNumber")
    private Object invoiceNumber;
    @JsonProperty("OrgAccountBalance")
    private String orgAccountBalance;
    @JsonProperty("ThirdPartyTransID")
    private Object thirdPartyTransID;
    @JsonProperty("MSISDN")
    private String mSISDN;
    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty("MiddleName")
    private String middleName;
    @JsonProperty("LastName")
    private String lastName;
    @JsonProperty("type_id")
    private String typeId;

    @JsonProperty("TransactionType")
    public String getTransactionType() {
        return transactionType;
    }

    @JsonProperty("TransactionType")
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    @JsonProperty("TransID")
    public String getTransID() {
        return transID;
    }

    @JsonProperty("TransID")
    public void setTransID(String transID) {
        this.transID = transID;
    }

    @JsonProperty("TransTime")
    public String getTransTime() {
        return transTime;
    }

    @JsonProperty("TransTime")
    public void setTransTime(String transTime) {
        this.transTime = transTime;
    }

    @JsonProperty("TransAmount")
    public String getTransAmount() {
        return transAmount;
    }

    @JsonProperty("TransAmount")
    public void setTransAmount(String transAmount) {
        this.transAmount = transAmount;
    }

    @JsonProperty("BusinessShortCode")
    public String getBusinessShortCode() {
        return businessShortCode;
    }

    @JsonProperty("BusinessShortCode")
    public void setBusinessShortCode(String businessShortCode) {
        this.businessShortCode = businessShortCode;
    }

    @JsonProperty("BillRefNumber")
    public String getBillRefNumber() {
        return billRefNumber;
    }

    @JsonProperty("BillRefNumber")
    public void setBillRefNumber(String billRefNumber) {
        this.billRefNumber = billRefNumber;
    }

    @JsonProperty("InvoiceNumber")
    public Object getInvoiceNumber() {
        return invoiceNumber;
    }

    @JsonProperty("InvoiceNumber")
    public void setInvoiceNumber(Object invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    @JsonProperty("OrgAccountBalance")
    public String getOrgAccountBalance() {
        return orgAccountBalance;
    }

    @JsonProperty("OrgAccountBalance")
    public void setOrgAccountBalance(String orgAccountBalance) {
        this.orgAccountBalance = orgAccountBalance;
    }

    @JsonProperty("ThirdPartyTransID")
    public Object getThirdPartyTransID() {
        return thirdPartyTransID;
    }

    @JsonProperty("ThirdPartyTransID")
    public void setThirdPartyTransID(Object thirdPartyTransID) {
        this.thirdPartyTransID = thirdPartyTransID;
    }

    @JsonProperty("MSISDN")
    public String getMSISDN() {
        return mSISDN;
    }

    @JsonProperty("MSISDN")
    public void setMSISDN(String mSISDN) {
        this.mSISDN = mSISDN;
    }

    @JsonProperty("FirstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("FirstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("MiddleName")
    public String getMiddleName() {
        return middleName;
    }

    @JsonProperty("MiddleName")
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @JsonProperty("LastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("LastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("type_id")
    public String getTypeId() {
        return typeId;
    }

    @JsonProperty("type_id")
    public void setTypeId(String lastName) {
        this.typeId = typeId;
    }


//    @Override
//    public String toString() {
//        return new ToStringBuilder(this).append("transactionType", transactionType).append("transID", transID).append("transTime", transTime).append("transAmount", transAmount).append("businessShortCode", businessShortCode).append("billRefNumber", billRefNumber).append("invoiceNumber", invoiceNumber).append("orgAccountBalance", orgAccountBalance).append("thirdPartyTransID", thirdPartyTransID).append("mSISDN", mSISDN).append("firstName", firstName).append("middleName", middleName).append("lastName", lastName).toString();
//    }

}