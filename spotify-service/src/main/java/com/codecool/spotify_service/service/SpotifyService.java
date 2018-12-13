package com.codecool.spotify_service.service;

import com.codecool.spotify_service.init.InitDB;
import com.codecool.spotify_service.model.Track;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SpotifyService {

    private InitDB initDB;

    public SpotifyService(InitDB initDB) {
        this.initDB = initDB;
        initDB.selectFiles(initDB.getFilenames());
        initDB.getTopHundred();
    }

    public String parseListToJson(List<Track> tracks) {
        return new Gson().toJson(tracks);
    }

    public String getFirstTen() {
        List<Track> tracks = initDB.getToptracks();
        List<Track> topten = new ArrayList<>();
        for (int i = 9; i > 0; i--) {
            topten.add(tracks.get(i));
        }
        Collections.reverse(topten);
        return parseListToJson(topten);
    }
    
    public String getPage(String page){
        List<Track> tracks = initDB.getToptracks();
        List<Track> pageData = new ArrayList<>();
        if (page.equals("1")){
            return getFirstTen();
        }else{
            int from = (Integer.parseInt(page) -1) *10;
            int to = (Integer.parseInt(page)*10);
            for (int i = from; i < to ; i++) {
                pageData.add(0,tracks.get(i));
            }
            Collections.reverse(pageData);
            return parseListToJson(pageData);
        }

     }
}
