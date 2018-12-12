package com.codecool.spotify_service;

import com.codecool.spotify_service.service.InitFiles;
import com.codecool.spotify_service.service.SpotifyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class SpotifyServiceApp {

    public static void main(String[] args) {
        SpotifyService spotifyService = new SpotifyService();
        InitFiles initFiles = new InitFiles();

        spotifyService.selectFiles(initFiles.getFilenames());
    }
}
