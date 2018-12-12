package com.codecool.spotify_service.service;

import java.util.ArrayList;
import java.util.List;

public class InitFiles {

    private List<String> filenames = new ArrayList<String>(){{
        add("regional-global-weekly-2018-01-05--2018-01-12");
        add("regional-global-weekly-2018-01-12--2018-01-19");
        add("regional-global-weekly-2018-01-19--2018-01-26");
    }};

    public List<String> getFilenames() {
        return filenames;
    }
}
