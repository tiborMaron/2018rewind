package com.codecool.google_service.DAO;

import com.codecool.google_service.modul.SearchedCountry;
import com.codecool.google_service.modul.SearchingResult;
import com.codecool.google_service.repository.CountryRepository;
import com.codecool.google_service.repository.SearchingResultRepository;
import com.codecool.google_service.service.CSVHandle;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class InitalizeDB {

    public InitalizeDB(CountryRepository countryRepository, SearchingResultRepository searchingResultRepository) {

        List<String> listOfCSVPath = Arrays.asList("csv/france.csv", "csv/germany.csv","csv/hungary.csv","csv/russia.csv",
                "csv/uk.csv","csv/ukraine.csv","csv/usa.csv","csv/world.csv");
        List<String> listOfCoutries = Arrays.asList("france", "germany", "hungary", "russia", "uk", "ukraine", "usa" ,"world");

        for (int i = 0; i < listOfCSVPath.size(); i++) {

            List<SearchingResult> listOfTopSearchingRestultOfHungary = new ArrayList<>();
            for (String item : new CSVHandle().readCSVFile(listOfCSVPath.get(i))) {
                SearchingResult result = new SearchingResult(item);
                listOfTopSearchingRestultOfHungary.add(result);
            }
            SearchedCountry country = new SearchedCountry(listOfCoutries.get(i));
            country.setListOfTopSearch(listOfTopSearchingRestultOfHungary);
            countryRepository.save(country);

            for (SearchingResult item: listOfTopSearchingRestultOfHungary) {
                item.setCountry(country);
                searchingResultRepository.save(item);
            }

        }


    }
}
