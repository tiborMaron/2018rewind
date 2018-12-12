package com.codecool.youtube_service.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "title"
})
public class Snippet {

    @JsonProperty("title")
    private String title;

    /**
     * No args constructor for use in serialization
     */
    public Snippet() {
    }

    /**
     * @param title
     */
    public Snippet(String title) {
        super();
        this.title = title;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }
}