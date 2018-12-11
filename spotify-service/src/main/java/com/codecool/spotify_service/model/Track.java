package com.codecool.spotify_service.model;

import javax.persistence.*;

@Entity
public class Track {

    @Column(name = "title")
    String title;

    @Column(name = "name")
    String name;

    @Column(name = "stream")
    long stream;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getStream() {
        return stream;
    }

    public void setStream(long stream) {
        this.stream = stream;
    }
}
