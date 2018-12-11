package com.codecool.google_service.modul;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SearchingResult {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String searchedResult;


    public SearchingResult(String searchedResult) {
        this.searchedResult = searchedResult;
    }

    public String getSearchedResult() {
        return searchedResult;
    }
}
