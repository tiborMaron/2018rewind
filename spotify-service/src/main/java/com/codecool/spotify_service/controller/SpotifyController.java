package com.codecool.spotify_service.controller;

import com.codecool.spotify_service.init.InitFiles;
import com.codecool.spotify_service.service.SpotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpotifyController {

    @Autowired
    SpotifyService spotifyService;

    InitFiles initFiles = new InitFiles();

    @GetMapping("/get-toplist")
    public String getTopList() {
        spotifyService.selectFiles(initFiles.getFilenames());
        spotifyService.getTopHundred();
        return spotifyService.getFirstTen();
    }

    @GetMapping("/get-toplist?page={page}")
    public String getTracksByPage(@RequestParam("page") String page){
        spotifyService.selectFiles(initFiles.getFilenames());
        spotifyService.getTopHundred();
        return spotifyService.getPage(page);
    }
}
