package com.codecool.google_service.service;

import com.codecool.google_service.controller.RestControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JsonHandle {


    public List buildJSONObject(List<String> listOfSearchResult, int page) {
        int usedLines = page * 10;

        List<Map> list = new ArrayList<>();
        for (int i = usedLines-10; i < usedLines; i++) {
            Map smallMap = new HashMap<>();
            smallMap.put("rank", i + 1);
            smallMap.put("name", listOfSearchResult.get(i).split(",")[0]);
            smallMap.put("value", listOfSearchResult.get(i).split(",")[1]);
            list.add(smallMap);
        }
        return list;
    }
}
