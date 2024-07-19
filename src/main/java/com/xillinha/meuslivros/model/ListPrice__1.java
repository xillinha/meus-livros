package com.xillinha.meuslivros.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class ListPrice__1 {

    private Integer amountInMicros;
    private String currencyCode;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Integer getAmountInMicros() {
        return amountInMicros;
    }

    public void setAmountInMicros(Integer amountInMicros) {
        this.amountInMicros = amountInMicros;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
