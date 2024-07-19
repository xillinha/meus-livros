package com.xillinha.meuslivros.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class ImageLinks {

    private String smallThumbnail;
    private String thumbnail;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public String getSmallThumbnail() {
        return smallThumbnail;
    }

    public void setSmallThumbnail(String smallThumbnail) {
        this.smallThumbnail = smallThumbnail;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
