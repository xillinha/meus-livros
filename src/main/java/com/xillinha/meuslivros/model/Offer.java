package com.xillinha.meuslivros.model;

public class Offer {

    private Integer finskyOfferType;
    private ListPrice__1 listPrice;
    private RetailPrice__1 retailPrice;
    private Boolean giftable;

    public Integer getFinskyOfferType() {
        return finskyOfferType;
    }

    public void setFinskyOfferType(Integer finskyOfferType) {
        this.finskyOfferType = finskyOfferType;
    }

    public ListPrice__1 getListPrice() {
        return listPrice;
    }

    public void setListPrice(ListPrice__1 listPrice) {
        this.listPrice = listPrice;
    }

    public RetailPrice__1 getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(RetailPrice__1 retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Boolean getGiftable() {
        return giftable;
    }

    public void setGiftable(Boolean giftable) {
        this.giftable = giftable;
    }
}
