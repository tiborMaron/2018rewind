package com.codecool.google_service.repository;

import com.codecool.google_service.modul.SearchedCountry;
import com.codecool.google_service.modul.SearchingResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public interface SearchingResultRepository extends JpaRepository<SearchingResult, Long> {

    @Transactional
    List<SearchingResult>findSearchingResultByCountryName(String name);
}
