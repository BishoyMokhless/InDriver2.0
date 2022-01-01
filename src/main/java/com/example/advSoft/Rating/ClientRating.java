package com.example.advSoft.Rating;

import com.example.advSoft.connection.DataBaseConnect;
import com.example.advSoft.connection.RatingDatabaseConnect;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientRating implements IRating, RateService{
    List<Float> driverRatings = new ArrayList<Float>();
    DataBaseConnect dbRating = new RatingDatabaseConnect();
    // didn't get the driver name yet
    @RequestMapping("Rate/{rideId}")
    @PostMapping
    @Override
    public void addRate(@PathVariable int rideId, @RequestBody float rate, @PathVariable("clientName") String clientName )throws SQLException, ClassNotFoundException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("rideId", rideId);
        jsonObject.put("clientName", clientName);
        jsonObject.put("rate", rate);

        dbRating.set(jsonObject);
    }
    @RequestMapping("viewDriverAvgRating/{driverName}")
    @GetMapping
    @Override
    public float viewAvg( @PathVariable String driverName) throws SQLException, ClassNotFoundException {
        List<Float> avgRatings;
        avgRatings = viewRating(driverName);
        float sum = 0;
        for(int i=0;i<avgRatings.size();i++){
            sum += avgRatings.get(i);

        }
        return sum/avgRatings.size();
    }
    @RequestMapping("viewDriverRatings/{driverName}")
    @GetMapping
    @Override
    public List<Float> viewRating(@PathVariable String driverName) throws SQLException, ClassNotFoundException {
        JSONArray allRatings = new JSONArray();

        allRatings = dbRating.listAll();
        for(int i=0;i<allRatings.length();i++){
            if(allRatings.getJSONObject(i).get("driverName").equals(driverName))
            {
                driverRatings.add((Float)allRatings.getJSONObject(i).get("rate"));
            }
        }
        return driverRatings;

    }
}
