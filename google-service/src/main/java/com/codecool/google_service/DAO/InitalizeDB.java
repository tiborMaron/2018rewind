package com.codecool.google_service.DAO;

import com.codecool.google_service.modul.SearchedCountry;
import com.codecool.google_service.modul.SearchingResult;
import com.codecool.google_service.repository.CountryRepository;
import com.codecool.google_service.repository.SearchingResultRepository;
import com.codecool.google_service.service.CsvHandel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitalizeDB {

    public InitalizeDB(CountryRepository countryRepository, SearchingResultRepository searchingResultRepository) {


//        List<SearchingResult> listOfTopSearchingRestultOfHungary = new ArrayList<>();
//        for (String item: new CsvHandel().readCSVFile("csv/hungary.csv")) {
//            SearchingResult result = new SearchingResult(item);
//            listOfTopSearchingRestultOfHungary.add(result);
//            searchingResultRepository.save(result);
//        }
//        SearchedCountry country = new SearchedCountry("hungray",listOfTopSearchingRestultOfHungary);
//        countryRepository.save(country);


        //SearchedCountry country = new SearchedCountry("hungray");
        List<SearchingResult> listOfTopSearchingRestultOfHungary = new ArrayList<>();
        for (String item : new CsvHandel().readCSVFile("csv/hungary.csv")) {
            SearchingResult result = new SearchingResult(item);
            listOfTopSearchingRestultOfHungary.add(result);
            //searchingResultRepository.save(result);
        }
        SearchedCountry country = new SearchedCountry("hungray");
        country.setListOfTopSearch(listOfTopSearchingRestultOfHungary);
        countryRepository.save(country);

        for (SearchingResult item: listOfTopSearchingRestultOfHungary) {
            item.setCountry(country);
            searchingResultRepository.save(item);
        }


    }
}
