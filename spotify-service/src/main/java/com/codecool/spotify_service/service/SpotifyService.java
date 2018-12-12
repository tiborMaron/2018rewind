package com.codecool.spotify_service.service;

import com.codecool.spotify_service.model.Track;
import com.opencsv.CSVReader;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class SpotifyService {

    private List<String> filenames = new ArrayList<String>(){{
        add("regional-global-weekly-2018-01-05--2018-01-12");
        add("regional-global-weekly-2018-01-12--2018-01-19");
        add("regional-global-weekly-2018-01-19--2018-01-26");
    }};
    private HashMap<String,Track> tracksss = new HashMap<>();

    public void selectFiles(){
        for (String name: filenames){
            readFile(name);
        }
        System.out.println(tracksss);
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
                if (tracksss.containsKey(tracks.get(i+3))){
                    tracksss.get(tracks.get(i+3)).setStream(tracksss.get(tracks.get(i+3)).getStream()+ Long.parseLong(tracks.get(i+1)));
                }else{
                    tracksss.put(tracks.get(i+3),new Track(Integer.parseInt(tracks.get(i+4)),tracks.get(i+3),tracks.get(i+2),Integer.parseInt(tracks.get(i+1)),tracks.get(i)));
                }
            }else if (counter == 1){
                counter = 5;
                continue;
            }
            counter--;
        }
    }
}
