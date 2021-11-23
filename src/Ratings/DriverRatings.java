package Ratings;

import connection.RateConnections;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DriverRatings implements Ratings
{
    List<Float> clientRates = new ArrayList<Float>();
    String client;
    @Override
    public List<Float> viewRatings(String username) throws SQLException, ClassNotFoundException
    {
        clientRates = RateConnections.viewClientsRate(username);
        return clientRates;
    }
}
