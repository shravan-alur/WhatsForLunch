
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
    "is_popular",
    "what_you_get",
    "time_start",
    "title",
    "url",
    "additional_restrictions",
    "options",
    "important_restrictions",
    "image_url",
    "id",
    "currency_code"
})
public class Deal {

    @JsonProperty("is_popular")
    private boolean is_popular;
    @JsonProperty("what_you_get")
    private String what_you_get;
    @JsonProperty("time_start")
    private int time_start;
    @JsonProperty("title")
    private String title;
    @JsonProperty("url")
    private String url;
    @JsonProperty("additional_restrictions")
    private String additional_restrictions;
    @JsonProperty("options")
    private List<Option> options = new ArrayList<Option>();
    @JsonProperty("important_restrictions")
    private String important_restrictions;
    @JsonProperty("image_url")
    private String image_url;
    @JsonProperty("id")
    private String id;
    @JsonProperty("currency_code")
    private String currency_code;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("is_popular")
    public boolean isIs_popular() {
        return is_popular;
    }

    @JsonProperty("is_popular")
    public void setIs_popular(boolean is_popular) {
        this.is_popular = is_popular;
    }

    @JsonProperty("what_you_get")
    public String getWhat_you_get() {
        return what_you_get;
    }

    @JsonProperty("what_you_get")
    public void setWhat_you_get(String what_you_get) {
        this.what_you_get = what_you_get;
    }

    @JsonProperty("time_start")
    public int getTime_start() {
        return time_start;
    }

    @JsonProperty("time_start")
    public void setTime_start(int time_start) {
        this.time_start = time_start;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("additional_restrictions")
    public String getAdditional_restrictions() {
        return additional_restrictions;
    }

    @JsonProperty("additional_restrictions")
    public void setAdditional_restrictions(String additional_restrictions) {
        this.additional_restrictions = additional_restrictions;
    }

    @JsonProperty("options")
    public List<Option> getOptions() {
        return options;
    }

    @JsonProperty("options")
    public void setOptions(List<Option> options) {
        this.options = options;
    }

    @JsonProperty("important_restrictions")
    public String getImportant_restrictions() {
        return important_restrictions;
    }

    @JsonProperty("important_restrictions")
    public void setImportant_restrictions(String important_restrictions) {
        this.important_restrictions = important_restrictions;
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
