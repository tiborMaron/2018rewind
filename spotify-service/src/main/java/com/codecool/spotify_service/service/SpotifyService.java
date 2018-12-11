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

    private HashMap<String,Integer> actualtracks = new HashMap<>();
    private List<String> filenames = new ArrayList<>();
    private HashMap<String,Track> tracks = new HashMap<>();
    public void readData(){

        try {
            File file = new File("/home/david/codecool/java-ee/2018rewind/spotify-service/src/main/resources/csv/regional-global-weekly-2018-01-05--2018-01-12.csv");

            FileReader filereader = new FileReader(file);
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;

            while ((nextRecord = csvReader.readNext()) != null) {
                int counter = 0;
                for (String cell : nextRecord) {
                    System.out.println(cell);
                }

            }
            System.out.println(tracks);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createTracks(){

    }
}
