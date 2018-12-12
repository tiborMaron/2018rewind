package com.codecool.google_service.controller;

import com.codecool.google_service.DAO.Query;
import com.codecool.google_service.repository.SearchingResultRepository;
import com.codecool.google_service.service.JsonHandle;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class RestControllerService {

    @Autowired
    SearchingResultRepository searchingResultRepository;

    @Autowired
    Query query;

    @Autowired
    JsonHandle jsonHandle;


    @GetMapping("/get-toplist")
    public @ResponseBody List<Map> getTopListInJSON() {
        return handleUserRequest("world", 1);
    }

    @GetMapping("/get-toplist-by-country/{country}")
    public List<Map> getTopListByCountry(@PathVariable String country, @RequestParam(name = "page", required = false) String page) {
        System.out.println(page);
        if(page == null){
            page = "1";
        }
        return handleUserRequest(country, Integer.parseInt(page));
    }


    private List<Map> handleUserRequest(String country, int pageNumber) {
        System.out.println(pageNumber);
        List listOfTopSearch = jsonHandle.buildJSONObject(
                query.makeListOfStringOfTopSearch(
                        searchingResultRepository.findSearchingResultByCountryName(country)), pageNumber);
        return listOfTopSearch;
    }
}
