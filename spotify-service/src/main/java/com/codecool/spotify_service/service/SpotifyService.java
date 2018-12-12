package com.codecool.spotify_service.service;

import com.codecool.spotify_service.model.Track;
import com.opencsv.CSVReader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SpotifyService {

    @Autowired
    private RestTemplateBuilder builder;

    private HashMap<String,Track> tracks = new HashMap<>();

    public void selectFiles(List<String> filenames){
        for (String name: filenames){
            this.readFile(name);
        }
        System.out.println(tracks);
    }

    public void readFile(String filename){

        try {
            File file = new File("/home/david/codecool/java-ee/2018rewind/spotify-service/src/main/resources/csv/" + filename + ".csv");

            FileReader filereader = new FileReader(file);
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;
            List<String> tracksdata = new ArrayList<>();

            while ((nextRecord = csvReader.readNext()) != null) {
                for (String cell : nextRecord) {
                    tracksdata.add(0,cell);
                }
            }
            createTracks(tracksdata);
            tracksdata.clear();
            getImage(tracks);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createTracks(List<String> tracks){

        int counter = 5;
        for (int i = 0; i < tracks.size()-5; i++) {
            if (counter == 5){
                if (this.tracks.containsKey(tracks.get(i+3))){
                    this.tracks.get(tracks.get(i+3)).setStream(this.tracks.get(tracks.get(i+3)).getStream()+ Long.parseLong(tracks.get(i+1)));
                }else{
                    this.tracks.put(tracks.get(i+3),new Track(Integer.parseInt(tracks.get(i+4)),tracks.get(i+3),tracks.get(i+2),Integer.parseInt(tracks.get(i+1)),tracks.get(i)));
                }
            }else if (counter == 1){
                counter = 5;
                continue;
            }
            counter--;
        }
    }
    public void getImage(HashMap<String,Track> tracks) throws IOException {

        for(Map.Entry<String, Track> entry : tracks.entrySet()) {
            Track value = entry.getValue();
            Document doc = Jsoup.connect(value.getUrl()).get();
            int counter = 0;
            for(Element meta : doc.select("meta")) {
                if (counter == 9){
                    System.out.println("Name: " + meta.attr("name") + " - Content: " + meta.attr("content"));
                    break;
                    }
                counter++;
                }

        }
    }

}
