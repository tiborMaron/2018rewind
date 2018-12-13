package com.codecool.spotify_service.model;

public class Track {

    private int id;
    private String title;
    private String name;
    private long stream;
    private String url;
    private String image;


    public Track(int id, String title, String name, int stream, String url) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.stream = stream;
        this.url = url;
    }

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

    public void setStream(long stream) {
        this.stream = stream;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Track{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", stream=" + stream +
                ", url='" + url + '\'' +
                '}';
    }
}
