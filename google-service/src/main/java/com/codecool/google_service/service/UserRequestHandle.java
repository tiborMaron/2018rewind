package com.codecool.google_service.service;

import com.codecool.google_service.DAO.Query;
import org.json.JSONArray;

public class UserRequestHandle {

    private JsonHandle jsonHandle;
    private Query query;

    public UserRequestHandle() {
        this.query = new Query();
        this.jsonHandle = new JsonHandle();
    }

    public JSONArray getAllTopUserSearcheInJSON() {
//        return this.jsonHandle.buildJSONObject(
//                this.query.getAllTopSearchByCountry("world")
//        );
        return null;
    }

    public JSONArray getAllTopUserSearchByCoutryInJSON(String coutryName) {
//        return this.jsonHandle.buildJSONObject(
//                this.query.getAllTopSearchByCountry(coutryName)
//        );
        return null;
    }


}
