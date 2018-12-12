package com.codecool.youtube_service.api;

import com.codecool.youtube_service.model.Video;
import com.codecool.youtube_service.service.YoutubeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class CategoryControllerREST {

    private YoutubeService youtubeService;

    public CategoryControllerREST(YoutubeService youtubeService) {
        this.youtubeService = youtubeService;
    }

    @GetMapping("/categories/{regionCode}")
    public Map<String, String> getCategories(@PathVariable("regionCode") String regionCode) {
        return youtubeService.getCategories(regionCode);
    }

    @GetMapping("/topvideos/{regionCode}/{categoryCode}")
    public List<Video> getTopVideos(
            @PathVariable("regionCode") String regionCode,
            @PathVariable("categoryCode") String categoryCode) {
        return youtubeService.getTop10Videos(regionCode, categoryCode);
    }
}