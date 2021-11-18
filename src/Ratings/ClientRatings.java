package Ratings;

import Client.Client;
import connection.RateConnections;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientRatings implements Ratings {

    List<Float> driverRates = new ArrayList<Float>();

    @Override
    public List<Float> viewRatings(String username) throws SQLException, ClassNotFoundException {
        driverRates = RateConnections.viewDriverRate(username);
        return driverRates;
    }
    public void addRate(String clientName,String driverName,int rating) throws SQLException, ClassNotFoundException {
        RateConnections.addRate(clientName, driverName, rating);
    }
}
