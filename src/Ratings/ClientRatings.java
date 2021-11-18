package Ratings;

import Client.Client;
import connection.RateConnections;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class    ClientRatings implements Ratings {

    List<Float> driverRates = new ArrayList<Float>();

    @Override
    public float viewRatings( String Client) throws SQLException, ClassNotFoundException {

        return RateConnections.viewClientsRate(Client);

    }
    public void addRate(String clientName,String driver,int rating){
    }
}
