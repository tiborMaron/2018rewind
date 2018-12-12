package com.codecool.youtube_service.model;

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
    private List<Item> items = null;

    /**
     * No args constructor for use in serialization
     */
    public CategoryList() {
    }

    /**
     * @param items
     */
    public CategoryList(List<Item> items) {
        super();
        this.items = items;
    }

    @JsonProperty("items")
    public List<Item> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<Item> items) {
        this.items = items;
    }

}