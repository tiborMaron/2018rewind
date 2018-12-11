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

    @OneToMany
    private List<SearchingResult> listOfTopSearch = new ArrayList<>();

    public SearchedCountry(String countryName, List<SearchingResult> listOfTopSearch) {
        this.countryName = countryName;
        this.listOfTopSearch = listOfTopSearch;
    }

    public SearchedCountry(String countryName) {
        this.countryName = countryName;
    }

    public SearchedCountry(List<SearchingResult> listOfTopSearch) {
        this.listOfTopSearch = listOfTopSearch;
    }

    public List<SearchingResult> getListOfTopSearch() {
        return listOfTopSearch;
    }

    public String getCountryName() {
        return countryName;
    }
}
