package com.codecool.spotify_service.service;

import com.opencsv.CSVReader;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

@Service
public class SpotifyService {

    public void getData(){

        HashMap<String,Integer> tracks = new HashMap<>();
        try {
            File file = new File("/home/david/codecool/java-ee/2018rewind/spotify-service/src/main/resources/csv/regional-global-weekly-2018-01-05--2018-01-12.csv");

            FileReader filereader = new FileReader(file);
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;

            while ((nextRecord = csvReader.readNext()) != null) {
                int counter = 0;
                for (String cell : nextRecord) {
                    if (counter == 1){
                        //System.out.print(cell + "\t");
                        if (tracks.containsKey(cell)){
                            tracks.put(cell, tracks.get(cell) + 1);
                        }else{
                            tracks.put(cell,1);
                        }
                        break;
                    }else{
                        counter++;
                    }
                }
            }
            System.out.println(tracks);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
