package com.codecool.google_service.controller;


import com.codecool.google_service.service.CsvHandel;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class RestControllerService {

//    @GetMapping("/get-toplist/{country}")
//    public void getToplist(@PathVariable("country") String country) {
//        return
//    }

    @GetMapping("/get-toplist")
    public JSONObject getTopListInJSON() {
        return null;
    }

    @GetMapping("/get-toplist/{page}")
    public JSONObject getToplistByPage(@PathVariable("page") String page) {
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
