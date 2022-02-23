package com.mpf.beedeepayment.model.jackson.trxstatus;

public class ResultParameter {

private String key;
private String value;

/**
* No args constructor for use in serialization
*
*/
public ResultParameter() {
}

/**
*
* @param value
* @param key
*/
public ResultParameter(String key, String value) {
super();
this.key = key;
this.value = value;
}

public String getKey() {
return key;
}

public void setKey(String key) {
this.key = key;
}

public String getValue() {
return value;
}

public void setValue(String value) {
this.value = value;
}

}
