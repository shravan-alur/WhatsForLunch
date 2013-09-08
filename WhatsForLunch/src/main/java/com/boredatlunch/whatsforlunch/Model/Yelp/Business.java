
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
    "is_claimed",
    "rating",
    "mobile_url",
    "rating_img_url",
    "review_count",
    "name",
    "snippet_image_url",
    "rating_img_url_small",
    "url",
    "phone",
    "snippet_text",
    "image_url",
    "categories",
    "display_phone",
    "rating_img_url_large",
    "id",
    "is_closed",
    "location",
    "menu_date_updated",
    "menu_provider",
    "deals"
})
public class Business {

    @JsonProperty("is_claimed")
    private boolean is_claimed;
    @JsonProperty("rating")
    private double rating;
    @JsonProperty("mobile_url")
    private String mobile_url;
    @JsonProperty("rating_img_url")
    private String rating_img_url;
    @JsonProperty("review_count")
    private int review_count;
    @JsonProperty("name")
    private String name;
    @JsonProperty("snippet_image_url")
    private String snippet_image_url;
    @JsonProperty("rating_img_url_small")
    private String rating_img_url_small;
    @JsonProperty("url")
    private String url;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("snippet_text")
    private String snippet_text;
    @JsonProperty("image_url")
    private String image_url;
    @JsonProperty("categories")
    private List<List<String>> categories = new ArrayList<List<String>>();
    @JsonProperty("display_phone")
    private String display_phone;
    @JsonProperty("rating_img_url_large")
    private String rating_img_url_large;
    @JsonProperty("id")
    private String id;
    @JsonProperty("is_closed")
    private boolean is_closed;
    @JsonProperty("location")
    private Location location;
    @JsonProperty("menu_date_updated")
    private int menu_date_updated;
    @JsonProperty("menu_provider")
    private String menu_provider;
    @JsonProperty("deals")
    private List<Deal> deals = new ArrayList<Deal>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("is_claimed")
    public boolean isIs_claimed() {
        return is_claimed;
    }

    @JsonProperty("is_claimed")
    public void setIs_claimed(boolean is_claimed) {
        this.is_claimed = is_claimed;
    }

    @JsonProperty("rating")
    public double getRating() {
        return rating;
    }

    @JsonProperty("rating")
    public void setRating(double rating) {
        this.rating = rating;
    }

    @JsonProperty("mobile_url")
    public String getMobile_url() {
        return mobile_url;
    }

    @JsonProperty("mobile_url")
    public void setMobile_url(String mobile_url) {
        this.mobile_url = mobile_url;
    }

    @JsonProperty("rating_img_url")
    public String getRating_img_url() {
        return rating_img_url;
    }

    @JsonProperty("rating_img_url")
    public void setRating_img_url(String rating_img_url) {
        this.rating_img_url = rating_img_url;
    }

    @JsonProperty("review_count")
    public int getReview_count() {
        return review_count;
    }

    @JsonProperty("review_count")
    public void setReview_count(int review_count) {
        this.review_count = review_count;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("snippet_image_url")
    public String getSnippet_image_url() {
        return snippet_image_url;
    }

    @JsonProperty("snippet_image_url")
    public void setSnippet_image_url(String snippet_image_url) {
        this.snippet_image_url = snippet_image_url;
    }

    @JsonProperty("rating_img_url_small")
    public String getRating_img_url_small() {
        return rating_img_url_small;
    }

    @JsonProperty("rating_img_url_small")
    public void setRating_img_url_small(String rating_img_url_small) {
        this.rating_img_url_small = rating_img_url_small;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonProperty("snippet_text")
    public String getSnippet_text() {
        return snippet_text;
    }

    @JsonProperty("snippet_text")
    public void setSnippet_text(String snippet_text) {
        this.snippet_text = snippet_text;
    }

    @JsonProperty("image_url")
    public String getImage_url() {
        return image_url;
    }

    @JsonProperty("image_url")
    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    @JsonProperty("categories")
    public List<List<String>> getCategories() {
        return categories;
    }

    @JsonProperty("categories")
    public void setCategories(List<List<String>> categories) {
        this.categories = categories;
    }

    @JsonProperty("display_phone")
    public String getDisplay_phone() {
        return display_phone;
    }

    @JsonProperty("display_phone")
    public void setDisplay_phone(String display_phone) {
        this.display_phone = display_phone;
    }

    @JsonProperty("rating_img_url_large")
    public String getRating_img_url_large() {
        return rating_img_url_large;
    }

    @JsonProperty("rating_img_url_large")
    public void setRating_img_url_large(String rating_img_url_large) {
        this.rating_img_url_large = rating_img_url_large;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("is_closed")
    public boolean isIs_closed() {
        return is_closed;
    }

    @JsonProperty("is_closed")
    public void setIs_closed(boolean is_closed) {
        this.is_closed = is_closed;
    }

    @JsonProperty("location")
    public Location getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(Location location) {
        this.location = location;
    }

    @JsonProperty("menu_date_updated")
    public int getMenu_date_updated() {
        return menu_date_updated;
    }

    @JsonProperty("menu_date_updated")
    public void setMenu_date_updated(int menu_date_updated) {
        this.menu_date_updated = menu_date_updated;
    }

    @JsonProperty("menu_provider")
    public String getMenu_provider() {
        return menu_provider;
    }

    @JsonProperty("menu_provider")
    public void setMenu_provider(String menu_provider) {
        this.menu_provider = menu_provider;
    }

    @JsonProperty("deals")
    public List<Deal> getDeals() {
        return deals;
    }

    @JsonProperty("deals")
    public void setDeals(List<Deal> deals) {
        this.deals = deals;
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
