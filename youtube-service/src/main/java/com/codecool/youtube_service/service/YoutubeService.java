package com.codecool.youtube_service.service;

import com.codecool.youtube_service.model.Video;
import com.codecool.youtube_service.model.categoryJSON.CategoryList;
import com.codecool.youtube_service.model.categoryJSON.Item;
import com.codecool.youtube_service.model.stats.Stat;
import com.codecool.youtube_service.model.stats.StatList;
import com.codecool.youtube_service.model.video.VideoItem;
import com.codecool.youtube_service.model.video.VideoList;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

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

    private <T> T runQuery(String url, Class<T> type) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "");
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        ResponseEntity<T> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, type);
        return responseEntity.getBody();
    }


    public Map<String, String> getCategories(String regionCode) {
        Map<String, String> queryParameters = new HashMap<>();
        queryParameters.put("part", "snippet");
        queryParameters.put("regionCode", regionCode);

        String url = "https://www.googleapis.com/youtube/v3/videoCategories" + buildQueryString(queryParameters);

        CategoryList categoryList = runQuery(url, CategoryList.class);
        List<Item> items = categoryList.getItems();

        Map<String, String> categories = new HashMap<>();
        for (Item item : items) {
            categories.put(item.getId(), item.getSnippet().getTitle());
        }
        return categories;
    }

    public List<Video> getTop100Videos(String regionCode, String categoryCode) {
        Map<String, String> queryParameters = new HashMap<>();
        queryParameters.put("type", "video");
        queryParameters.put("part", "snippet");
        queryParameters.put("maxResults", "10");
        queryParameters.put("order", "viewCount");
        queryParameters.put("publishedAfter", "2018-01-01T00:00:00Z");
        queryParameters.put("regionCode", regionCode);
        queryParameters.put("videoCategoryId", categoryCode);

        String url = "https://www.googleapis.com/youtube/v3/search" + buildQueryString(queryParameters);

        VideoList videoList = runQuery(url, VideoList.class);

        List<Video> videos = new ArrayList<>();
        for (VideoItem vi : videoList.getItems()) {
            Video tmp = new Video(vi.getId().getVideoId(), vi.getSnippet().getTitle(), vi.getSnippet().getPublishedAt());
            videos.add(tmp);
        }

        return getViewNumbers(videos);
    }

    private List<Video> getViewNumbers(List<Video> videos) {
        StringBuilder ids = new StringBuilder();
        boolean first = true;
        for (Video video : videos) {
            if (first) {
                ids.append(video.getId());
                first = false;
            } else {
                ids.append(",").append(video.getId());
            }
        }

        Map<String, String> queryParameters = new HashMap<>();
        queryParameters.put("part", "statistics");
        queryParameters.put("id", ids.toString());

        String url = "https://www.googleapis.com/youtube/v3/videos" + buildQueryString(queryParameters);

        StatList sl = runQuery(url, StatList.class);

        for (int i = 0; i < videos.size(); i++) {
            String viewCount = sl.getItems().get(i).getStatistics().getViewCount();
            videos.get(i).setViewNumber(viewCount);
        }

        return videos;
    }
}