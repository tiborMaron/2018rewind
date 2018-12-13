package com.codecool.spotify_service.controller;

import com.codecool.spotify_service.init.InitDB;
import com.codecool.spotify_service.service.SpotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class SpotifyController {

    @Autowired
    SpotifyService spotifyService;

    InitDB initFiles = new InitDB();

    @GetMapping("/get-toplist")
    public String getTopList() {
        return spotifyService.getFirstTen();
    }

    @GetMapping("/get-toplist/{page}")
    public String getTracksByPage(@PathVariable String page){
        return spotifyService.getPage(page);
    }
}
