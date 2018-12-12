package com.codecool.spotify_service.service;

import com.codecool.spotify_service.model.Track;
import com.google.gson.Gson;
import com.opencsv.CSVReader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Service
public class SpotifyService {

    private HashMap<String,Track> tracks = new HashMap<>();
    private List<Track> toptracks = new ArrayList<>();
    private String json;

    public void selectFiles(List<String> filenames){
        for (String name: filenames){
            this.readFile(name);
        }
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
    public void getImageUrl(List<Track> tracks) throws IOException {

        for (Track track: tracks) {
            Document doc = Jsoup.connect(track.getUrl()).get();
            int counter = 0;
            for(Element meta : doc.select("meta")) {
                if (counter == 9){
                track.setImage(meta.attr("content"));
                    break;
                }
                counter++;
            }
        }
    }

    public List<Track> getTopHundred(){

        List<Long> topnumber = new ArrayList<>();

        for(Map.Entry<String, Track> entry : tracks.entrySet()) {
            Track value = entry.getValue();
            topnumber.add(value.getStream());
        }
        Collections.sort(topnumber);
        Collections.reverse(topnumber);
        for (int i = 0; i < 100; i++){
            for(Map.Entry<String, Track> entry : tracks.entrySet()) {
                Track value = entry.getValue();
                if (value.getStream() == topnumber.get(i)){
                    toptracks.add(0,value);
                }
            }
        }
        Collections.reverse(toptracks);
        try {
            getImageUrl(toptracks);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return toptracks;
    }

    public String parseListToJson(List<Track> tracks) {
        return json =  new Gson().toJson(tracks);
    }

    public String getFirstTen() {
        List<Track> tracks = getTopHundred();
        List<Track> topten = new ArrayList<>();
        for (int i = 9; i > 0; i--) {
            topten.add(tracks.get(i));
        }
        Collections.reverse(topten);
        return parseListToJson(topten);
    }
}
