package com.demo.javabean;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestResult {
    private String code;
    private String value;
    private Map<String, Object> responseData;
    private static final String SUCCESS_CODE = "0";
    private static final String SUCCESS_VALUE = "成功";

    public RestResult(String SUCCESS_CODE, String SUCCESS_VALUE) {
        this.code = SUCCESS_CODE;
        this.value = SUCCESS_VALUE;
    }

    public RestResult() {
        this.code = SUCCESS_CODE;
        this.value = SUCCESS_VALUE;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Map<String, Object> getResponseData() {
        return responseData;
    }

    public void setResponseData(Map<String, Object> responseData) {
        this.responseData = responseData;
    }
}
