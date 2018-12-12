package com.codecool.youtube_service.model.video;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "items"
})
public class VideoList {

    @JsonProperty("items")
    private List<VideoItem> items = null;

    @JsonProperty("items")
    public List<VideoItem> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<VideoItem> items) {
        this.items = items;
    }
}