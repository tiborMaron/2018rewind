package com.codecool.google_service.controller;

import com.codecool.google_service.DAO.Query;
import com.codecool.google_service.repository.SearchingResultRepository;
import com.codecool.google_service.service.JsonHandle;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
        return handleUserRequest("world");
    }

    @GetMapping("/get-toplist/{page}")
    public JSONObject getToplistByPage(@PathVariable String page) {
        return null;
    }

    @GetMapping("/get-toplist-by-country/{country}")
    public List<Map> getTopListByCountry(@PathVariable String country) {
        return handleUserRequest(country);
    }


    @GetMapping("/get-toplist-by-country/{country}?page={page}")
    public JSONObject getTopListByCountryAndByPage(@PathVariable("country") String country, @PathVariable("page") String page) {
        System.out.println(country + " " + page);
        return null;
    }

    private List<Map> handleUserRequest(String country) {
        List listOfTopSearch = jsonHandle.buildJSONObject(
                query.makeListOfStringOfTopSearch(
                        searchingResultRepository.findSearchingResultByCountryName(country)));
        return listOfTopSearch;
    }
}
