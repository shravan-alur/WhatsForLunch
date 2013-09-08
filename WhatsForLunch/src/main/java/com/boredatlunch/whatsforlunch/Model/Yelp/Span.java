
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
    "latitude_delta",
    "longitude_delta"
})
public class Span {

    @JsonProperty("latitude_delta")
    private double latitude_delta;
    @JsonProperty("longitude_delta")
    private double longitude_delta;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("latitude_delta")
    public double getLatitude_delta() {
        return latitude_delta;
    }

    @JsonProperty("latitude_delta")
    public void setLatitude_delta(double latitude_delta) {
        this.latitude_delta = latitude_delta;
    }

    @JsonProperty("longitude_delta")
    public double getLongitude_delta() {
        return longitude_delta;
    }

    @JsonProperty("longitude_delta")
    public void setLongitude_delta(double longitude_delta) {
        this.longitude_delta = longitude_delta;
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
