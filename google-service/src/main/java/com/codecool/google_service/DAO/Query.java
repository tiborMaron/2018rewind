package com.codecool.google_service.DAO;

import com.codecool.google_service.modul.SearchingResult;
import com.codecool.google_service.repository.CountryRepository;
import com.codecool.google_service.repository.SearchingResultRepository;
import com.codecool.google_service.service.JsonHandle;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class Query { //TODO make a better name for this class.

    @Autowired
    SearchingResultRepository searchingResultRepository;


    public List<String> getAllTopSearchByCountry(String countryName) {
        return this.makeListOfStringOfTopSearch(searchingResultRepository.findSearchingResultByCountryName(countryName));
    }

    public List<String> makeListOfStringOfTopSearch(List<SearchingResult> listOfResultObject) {
        return listOfResultObject.stream().map(t -> t.getSearchedResult()).collect(Collectors.toList());
    }

}
