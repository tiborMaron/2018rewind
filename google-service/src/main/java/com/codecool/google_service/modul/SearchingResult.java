package com.codecool.google_service.modul;

import javax.persistence.*;

@Entity
public class SearchingResult {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String searchedResult;
    private String countryName;

    @OneToOne
    private SearchedCountry country;

    public SearchingResult(){}


    public SearchingResult(String searchedResult) {
        this.searchedResult = searchedResult;
    }

    public String getSearchedResult() {
        return searchedResult;
    }

    public void setCountry(SearchedCountry country) {
        this.country = country;
        this.countryName = this.country.getCountryName();
    }
}
