
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
    "span",
    "center"
})
public class Region {

    @JsonProperty("span")
    private Span span;
    @JsonProperty("center")
    private Center center;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("span")
    public Span getSpan() {
        return span;
    }

    @JsonProperty("span")
    public void setSpan(Span span) {
        this.span = span;
    }

    @JsonProperty("center")
    public Center getCenter() {
        return center;
    }

    @JsonProperty("center")
    public void setCenter(Center center) {
        this.center = center;
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
