package com.codecool.google_service.DAO;

import com.codecool.google_service.modul.SearchingResult;
import com.codecool.google_service.repository.SearchingResultRepository;
import com.codecool.google_service.service.JsonHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Query {

    @Autowired
    SearchingResultRepository searchingResultRepository;


//    public List getAllTopSearchByCountry(String countryName) { // TODO Find out why its not working
//        return new JsonHandle().buildJSONObject(makeListOfStringOfTopSearch(searchingResultRepository.findSearchingResultByCountryName(countryName))); // TODO ned to refactor
//    }

    @Bean
    public List<String> makeListOfStringOfTopSearch(List<SearchingResult> listOfResultObject) {
        return listOfResultObject.stream().map(t -> t.getSearchedResult()).collect(Collectors.toList());
    }

}
