package com.codecool.netflix_service.Model;

import javax.persistence.*;

@Entity
public class Netflix {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @Column(length = 5000)
    private String details;
    private String imageUrl;

    public Netflix(String name, String details, String imageUrl) {
        this.name = name;
        this.details = details;
        this.imageUrl = imageUrl;
    }

    public Netflix(){}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Netflix{" +
                "name='" + name + '\'' +
                ", details='" + details + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

}

