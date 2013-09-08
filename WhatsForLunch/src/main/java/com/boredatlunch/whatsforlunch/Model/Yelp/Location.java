
package com.boredatlunch.whatsforlunch.Model.Yelp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    "city",
    "display_address",
    "postal_code",
    "country_code",
    "address",
    "state_code"
})
public class Location {

    @JsonProperty("city")
    private String city;
    @JsonProperty("display_address")
    private List<String> display_address = new ArrayList<String>();
    @JsonProperty("postal_code")
    private String postal_code;
    @JsonProperty("country_code")
    private String country_code;
    @JsonProperty("address")
    private List<String> address = new ArrayList<String>();
    @JsonProperty("state_code")
    private String state_code;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("display_address")
    public List<String> getDisplay_address() {
        return display_address;
    }

    @JsonProperty("display_address")
    public void setDisplay_address(List<String> display_address) {
        this.display_address = display_address;
    }

    @JsonProperty("postal_code")
    public String getPostal_code() {
        return postal_code;
    }

    @JsonProperty("postal_code")
    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    @JsonProperty("country_code")
    public String getCountry_code() {
        return country_code;
    }

    @JsonProperty("country_code")
    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    @JsonProperty("address")
    public List<String> getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(List<String> address) {
        this.address = address;
    }

    @JsonProperty("state_code")
    public String getState_code() {
        return state_code;
    }

    @JsonProperty("state_code")
    public void setState_code(String state_code) {
        this.state_code = state_code;
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
