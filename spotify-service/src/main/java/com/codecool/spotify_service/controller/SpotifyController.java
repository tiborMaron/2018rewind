package com.codecool.spotify_service.controller;

import com.codecool.spotify_service.service.SpotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpotifyController {

    @Autowired
    SpotifyService spotifyService;

    @GetMapping("/get-toplist")
    public void getTopList(){

    }
}
