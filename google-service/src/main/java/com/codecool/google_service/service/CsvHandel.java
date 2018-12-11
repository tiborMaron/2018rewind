package com.codecool.google_service.service;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class CsvHandel {

    public String doStuff(String listPath) {
        return null;
    }


    public List<String> readCSVFile(String filePath) {
        List<String> listOfRestuls = new ArrayList<>();

        URL url = CsvHandel.class.getClassLoader().getResource(filePath);
        System.out.println(url);
        String urlPath = url.getPath();
        try (Stream<String> stream = Files.lines(Paths.get(urlPath))){
            stream.skip(2).map(t -> t.split(",")[0]).forEach(line -> listOfRestuls.add(line));
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return listOfRestuls;
        }
        return listOfRestuls;
    }


    // TODO this part need only when you have your things in the DB
    private String buildJSONArray(List<String> listOfResult) {
        Gson gson = new Gson();
        return gson.toJson(listOfResult);
    }


}
