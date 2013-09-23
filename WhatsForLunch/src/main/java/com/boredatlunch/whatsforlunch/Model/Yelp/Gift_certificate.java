
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
    "url",
    "unused_balances",
    "options",
    "image_url",
    "id",
    "currency_code"
})
public class Gift_certificate {

    @JsonProperty("url")
    private String url;
    @JsonProperty("unused_balances")
    private String unused_balances;
    @JsonProperty("options")
    private List<Option_> options = new ArrayList<Option_>();
    @JsonProperty("image_url")
    private String image_url;
    @JsonProperty("id")
    private String id;
    @JsonProperty("currency_code")
    private String currency_code;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("unused_balances")
    public String getUnused_balances() {
        return unused_balances;
    }

    @JsonProperty("unused_balances")
    public void setUnused_balances(String unused_balances) {
        this.unused_balances = unused_balances;
    }

    @JsonProperty("options")
    public List<Option_> getOptions() {
        return options;
    }

    @JsonProperty("options")
    public void setOptions(List<Option_> options) {
        this.options = options;
    }

    @JsonProperty("image_url")
    public String getImage_url() {
        return image_url;
    }

    @JsonProperty("image_url")
    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("currency_code")
    public String getCurrency_code() {
        return currency_code;
    }

    @JsonProperty("currency_code")
    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
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
