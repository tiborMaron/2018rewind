package com.codecool.youtube_service.model.category;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "snippet"
})
public class Category {

    @JsonProperty("id")
    private String id;
    @JsonProperty("snippet")
    private Snippet snippet;

    /**
     * No args constructor for use in serialization
     */
    public Category() {
    }

    /**
     * @param id
     * @param snippet
     */
    public Category(String id, Snippet snippet) {
        super();
        this.id = id;
        this.snippet = snippet;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("snippet")
    public Snippet getSnippet() {
        return snippet;
    }

    @JsonProperty("snippet")
    public void setSnippet(Snippet snippet) {
        this.snippet = snippet;
    }

}
