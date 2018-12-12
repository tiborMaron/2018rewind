package com.codecool.google_service.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonHandle {

    public JSONArray buildJSONObject(List<String> listOfSearchResult) {
        JSONArray jsonArray = new JSONArray();

        for (String searchResult: listOfSearchResult) {
            jsonArray.put(new JSONObject().put("search", searchResult));
        }
        return jsonArray;
    }
}
