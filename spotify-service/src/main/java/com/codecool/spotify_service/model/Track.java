package com.codecool.spotify_service.model;

import javax.persistence.*;

@Entity
public class Track {

    int id;
    String title;
    String name;
    int stream;
    String url;


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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setStream(int stream) {
        this.stream = stream;
    }

    public Track(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Track{" +
                "title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", stream=" + stream +
                '}';
    }
}
