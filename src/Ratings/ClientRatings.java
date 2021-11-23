package Ratings;

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

    public Float viewAvg(String clientName) throws SQLException, ClassNotFoundException {
        driverRates = viewRatings(clientName);
        float sum = 0;
        for(int i = 0; i < driverRates.size(); i++)
        {
            sum += driverRates.get(i);
        }
        return sum / driverRates.size();
    }
}
