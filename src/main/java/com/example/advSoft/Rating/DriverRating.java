package com.example.advSoft.Rating;

import com.example.advSoft.connection.DataBaseConnect;
import com.example.advSoft.connection.RatingDatabaseConnect;
import org.json.JSONArray;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DriverRating implements RateService {
    List<Float> clientRatings = new ArrayList<Float>();
    DataBaseConnect dbRating = new RatingDatabaseConnect();
    @RequestMapping("viewClientRatings/{clientName}")
    @GetMapping
    @Override
    public List<Float> viewRating(@PathVariable String clientName) throws SQLException, ClassNotFoundException {
        JSONArray allRatings = new JSONArray();

        allRatings = dbRating.listAll();
        for(int i=0;i<allRatings.length();i++){
            if(allRatings.getJSONObject(i).get("clientName").equals(clientName))
            {
                clientRatings.add((Float)allRatings.getJSONObject(i).get("rate"));
            }
        }
        return clientRatings;
    }
}
