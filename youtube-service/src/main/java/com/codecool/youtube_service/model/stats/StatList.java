package com.codecool.youtube_service.model.stats;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "items"
})
public class StatList {
    @JsonProperty("items")
    private List<Stat> items = null;

    @JsonProperty("items")
    public List<Stat> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<Stat> items) {
        this.items = items;
    }
}