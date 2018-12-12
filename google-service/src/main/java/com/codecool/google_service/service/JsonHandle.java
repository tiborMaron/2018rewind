package com.codecool.google_service.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JsonHandle {

    @Bean
    public List buildJSONObject(List<String> listOfSearchResult) {
        List<Map> list = new ArrayList<>();
        for (int i = 0; i < listOfSearchResult.size(); i++) {
            Map smallMap = new HashMap<>();
            smallMap.put("rank", i + 1);
            smallMap.put("name", listOfSearchResult.get(i).split(",")[0]);
            smallMap.put("value", listOfSearchResult.get(i).split(",")[1]);
            list.add(smallMap);
        }
        return list;
    }
}
