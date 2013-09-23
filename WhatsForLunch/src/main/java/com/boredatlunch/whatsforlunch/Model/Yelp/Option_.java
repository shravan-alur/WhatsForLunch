
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
    "price",
    "formatted_price"
})
public class Option_ {

    @JsonProperty("price")
    private int price;
    @JsonProperty("formatted_price")
    private String formatted_price;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("price")
    public int getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(int price) {
        this.price = price;
    }

    @JsonProperty("formatted_price")
    public String getFormatted_price() {
        return formatted_price;
    }

    @JsonProperty("formatted_price")
    public void setFormatted_price(String formatted_price) {
        this.formatted_price = formatted_price;
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
