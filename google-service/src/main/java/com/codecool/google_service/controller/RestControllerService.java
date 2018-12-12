package com.codecool.google_service.controller;

import com.codecool.google_service.DAO.Query;
import com.codecool.google_service.modul.SearchingResult;
import com.codecool.google_service.repository.SearchingResultRepository;
import com.codecool.google_service.service.JsonHandle;
import com.codecool.google_service.service.UserRequestHandle;
import com.google.gson.JsonArray;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
public class RestControllerService {

//    @GetMapping("/get-toplist/{country}")
//    public void getToplist(@PathVariable("country") String country) {
//        return
//    }
    @Autowired
    SearchingResultRepository searchingResultRepository;

    @GetMapping("/get-toplist")
    public @ResponseBody List<String> getTopListInJSON() {
        List<String> jn = new Query().makeListOfStringOfTopSearch(searchingResultRepository.findSearchingResultByCountryName("hungary")); // TODO ned to refactor
        return jn;
    }

    @GetMapping("/get-toplist/{page}")
    public JSONObject getToplistByPage(@PathVariable String page) {
        System.out.println("This is the page " + page);
        return null;
    }

    @GetMapping("/get-toplist-by-country/{country}")
    public JSONObject getTopListByCountry(@PathVariable("county") String country) {
        return null;
    }

    @GetMapping("/get-toplist-by-country/{country}?page={page}")
    public JSONObject getTopListByCountryAndByPage(@PathVariable("county") String country, @PathVariable("page") String page) {
        return null;
    }
}
