package com.codecool.spotify_service;

import com.codecool.spotify_service.service.InitFiles;
import com.codecool.spotify_service.service.SpotifyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpotifyServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(SpotifyServiceApp.class, args);

        /*InitFiles initFiles = new InitFiles();
        SpotifyService spotifyService = new SpotifyService();

        spotifyService.selectFiles(initFiles.getFilenames());
        spotifyService.getTopHundred();*/
    }
}
