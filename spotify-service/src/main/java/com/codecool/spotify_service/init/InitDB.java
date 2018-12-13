package com.codecool.spotify_service.init;

import com.codecool.spotify_service.model.Track;
import com.opencsv.CSVReader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Component
public class InitDB {

    private HashMap<String, Track> tracks = new HashMap<>();
    private List<Track> toptracks = new ArrayList<>();

    private List<String> filenames = new ArrayList<String>(){{
        add("regional-global-weekly-2018-01-05--2018-01-12");
        add("regional-global-weekly-2018-01-12--2018-01-19");
        add("regional-global-weekly-2018-01-19--2018-01-26");
        add("regional-global-weekly-2018-01-26--2018-02-02");
        add("regional-global-weekly-2018-02-02--2018-02-09");
        add("regional-global-weekly-2018-02-09--2018-02-16");
        add("regional-global-weekly-2018-02-16--2018-02-23");
        add("regional-global-weekly-2018-02-23--2018-03-02");
        add("regional-global-weekly-2018-03-02--2018-03-09");
        add("regional-global-weekly-2018-03-09--2018-03-16");
        add("regional-global-weekly-2018-03-16--2018-03-23");
        add("regional-global-weekly-2018-03-23--2018-03-30");
        add("regional-global-weekly-2018-03-30--2018-04-06");
        add("regional-global-weekly-2018-04-06--2018-04-13");
        add("regional-global-weekly-2018-04-13--2018-04-20");
        add("regional-global-weekly-2018-04-20--2018-04-27");
        add("regional-global-weekly-2018-04-27--2018-05-04");
        add("regional-global-weekly-2018-05-04--2018-05-11");
        add("regional-global-weekly-2018-05-11--2018-05-18");
        add("regional-global-weekly-2018-05-18--2018-05-25");
        add("regional-global-weekly-2018-05-25--2018-06-01");
        add("regional-global-weekly-2018-06-01--2018-06-08");
        add("regional-global-weekly-2018-06-15--2018-06-22");
        add("regional-global-weekly-2018-06-22--2018-06-29");
        add("regional-global-weekly-2018-06-29--2018-07-06");
        add("regional-global-weekly-2018-07-06--2018-07-13");
        add("regional-global-weekly-2018-07-13--2018-07-20");
        add("regional-global-weekly-2018-07-20--2018-07-27");
        add("regional-global-weekly-2018-07-27--2018-08-03");
        add("regional-global-weekly-2018-08-03--2018-08-10");
        add("regional-global-weekly-2018-08-10--2018-08-17");
        add("regional-global-weekly-2018-08-17--2018-08-24");
        add("regional-global-weekly-2018-08-24--2018-08-31");
        add("regional-global-weekly-2018-08-31--2018-09-07");
        add("regional-global-weekly-2018-09-07--2018-09-14");
        add("regional-global-weekly-2018-09-14--2018-09-21");
        add("regional-global-weekly-2018-09-21--2018-09-28");
        add("regional-global-weekly-2018-09-28--2018-10-05");
        add("regional-global-weekly-2018-10-12--2018-10-19");
        add("regional-global-weekly-2018-10-19--2018-10-26");
        add("regional-global-weekly-2018-10-26--2018-11-02");
        add("regional-global-weekly-2018-11-02--2018-11-09");
        add("regional-global-weekly-2018-11-09--2018-11-16");
        add("regional-global-weekly-2018-11-16--2018-11-23");
        add("regional-global-weekly-2018-11-23--2018-11-30");
        add("regional-global-weekly-2018-11-30--2018-12-07");
    }};

    public List<String> getFilenames() {
        return filenames;
    }

    public void selectFiles(List<String> filenames){
        tracks.clear();
        toptracks.clear();
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

    public void getTopHundred(){

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
    }

    public List<Track> getToptracks() {
        return toptracks;
    }
}
