
package com.boredatlunch.whatsforlunch.Model.Yelp;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "original_price",
    "title",
    "price",
    "purchase_url",
    "formatted_original_price",
    "formatted_price",
    "is_quantity_limited"
})
public class Option {

    @JsonProperty("original_price")
    private int original_price;
    @JsonProperty("title")
    private String title;
    @JsonProperty("price")
    private int price;
    @JsonProperty("purchase_url")
    private String purchase_url;
    @JsonProperty("formatted_original_price")
    private String formatted_original_price;
    @JsonProperty("formatted_price")
    private String formatted_price;
    @JsonProperty("is_quantity_limited")
    private boolean is_quantity_limited;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("original_price")
    public int getOriginal_price() {
        return original_price;
    }

    @JsonProperty("original_price")
    public void setOriginal_price(int original_price) {
        this.original_price = original_price;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("price")
    public int getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(int price) {
        this.price = price;
    }

    @JsonProperty("purchase_url")
    public String getPurchase_url() {
        return purchase_url;
    }

    @JsonProperty("purchase_url")
    public void setPurchase_url(String purchase_url) {
        this.purchase_url = purchase_url;
    }

    @JsonProperty("formatted_original_price")
    public String getFormatted_original_price() {
        return formatted_original_price;
    }

    @JsonProperty("formatted_original_price")
    public void setFormatted_original_price(String formatted_original_price) {
        this.formatted_original_price = formatted_original_price;
    }

    @JsonProperty("formatted_price")
    public String getFormatted_price() {
        return formatted_price;
    }

    @JsonProperty("formatted_price")
    public void setFormatted_price(String formatted_price) {
        this.formatted_price = formatted_price;
    }

    @JsonProperty("is_quantity_limited")
    public boolean isIs_quantity_limited() {
        return is_quantity_limited;
    }

    @JsonProperty("is_quantity_limited")
    public void setIs_quantity_limited(boolean is_quantity_limited) {
        this.is_quantity_limited = is_quantity_limited;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperties(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
