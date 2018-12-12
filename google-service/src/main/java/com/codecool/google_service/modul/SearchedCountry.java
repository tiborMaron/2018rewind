package com.codecool.google_service.modul;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SearchedCountry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String countryName;

    @OneToMany(mappedBy = "country")
    private List<SearchingResult> listOfTopSearch = new ArrayList<>();

    public SearchedCountry(){}

    public SearchedCountry(String countryName) {
        this.countryName = countryName;
    }


    public List<SearchingResult> getListOfTopSearch() {
        return listOfTopSearch;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setListOfTopSearch(List<SearchingResult> listOfTopSearch) {
        this.listOfTopSearch = listOfTopSearch;
    }
}
