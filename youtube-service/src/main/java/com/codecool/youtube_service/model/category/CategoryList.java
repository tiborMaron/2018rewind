package com.codecool.youtube_service.model.category;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "items"
})
public class CategoryList {

    @JsonProperty("items")
    private List<Category> items = null;

    /**
     * No args constructor for use in serialization
     */
    public CategoryList() {
    }

    /**
     * @param items
     */
    public CategoryList(List<Category> items) {
        super();
        this.items = items;
    }

    @JsonProperty("items")
    public List<Category> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<Category> items) {
        this.items = items;
    }

}