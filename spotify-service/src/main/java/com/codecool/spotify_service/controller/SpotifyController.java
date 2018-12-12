package com.codecool.spotify_service.controller;

import com.codecool.spotify_service.service.InitFiles;
import com.codecool.spotify_service.service.SpotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class SpotifyController {

    @Autowired
    SpotifyService spotifyService;

    InitFiles initFiles = new InitFiles();

    @GetMapping("/get-toplist")
    public String getTopList() throws IOException {
        spotifyService.selectFiles(initFiles.getFilenames());
        return spotifyService.getFirstTen();

        //return "True";
    }

    @GetMapping("/get-toplist?page={page}")
    public String getTracksByPage(@RequestParam("page") String page){
        return "";
    }
}
