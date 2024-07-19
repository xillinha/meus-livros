package com.xillinha.meuslivros.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class ListPrice {

    private Double amount;
    private String currencyCode;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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
