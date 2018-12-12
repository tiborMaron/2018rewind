package com.codecool.youtube_service.service;

import com.codecool.youtube_service.model.CategoryList;
import com.codecool.youtube_service.model.Item;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@Service
public class YoutubeService {

    private Properties properties;

    public YoutubeService() {
        properties = new Properties();
        try {
            InputStream in = YoutubeService.class.getResourceAsStream("/youtube.properties");
            properties.load(in);
        } catch (IOException e) {
            System.err.println("There was an error reading youtube.properties" + ": " + e.getCause()
                    + " : " + e.getMessage());
            System.exit(1);
        }
    }

    private String buildQueryString(Map<String, String> parameters) {
        StringBuilder queryString = new StringBuilder("?key=" + properties.getProperty("youtube.apikey"));
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            queryString.append("&").append(entry.getKey()).append("=").append(entry.getValue());
        }
        return queryString.toString();
    }

    public Map<String, String> getCategories(String regionCode) {


        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "");
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        Map<String, String> queryParameters = new HashMap<>();
        queryParameters.put("part", "snippet");
        queryParameters.put("regionCode", regionCode);

        String url = "https://www.googleapis.com/youtube/v3/videoCategories";
        String query = buildQueryString(queryParameters);
        System.out.println(query);

        ResponseEntity<CategoryList> responseEntity = restTemplate.exchange(url + query, HttpMethod.GET, entity, CategoryList.class);

        List<Item> items = responseEntity.getBody().getItems();

        Map<String, String> categories = new HashMap<>();
        for (Item item : items) {
            categories.put(item.getId(), item.getSnippet().getTitle());
        }

        return categories;
    }
}