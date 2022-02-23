package com.mpf.beedeepayment.model.jackson.trxstatus;

import java.util.List;

public class ResultParameters {

private List<ResultParameter> resultParameter = null;

/**
* No args constructor for use in serialization
*
*/
public ResultParameters() {
}

/**
*
* @param resultParameter
*/
public ResultParameters(List<ResultParameter> resultParameter) {
super();
this.resultParameter = resultParameter;
}

public List<ResultParameter> getResultParameter() {
return resultParameter;
}

public void setResultParameter(List<ResultParameter> resultParameter) {
this.resultParameter = resultParameter;
}

}
