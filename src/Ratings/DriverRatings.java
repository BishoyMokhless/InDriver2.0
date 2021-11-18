package Ratings;

import connection.DataBaseConnect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DriverRatings implements Ratings
{
    List<Float> clientRates = new ArrayList<Float>();
    String client;
    @Override
    public void viewRatings(List<Float> ratings) throws SQLException, ClassNotFoundException {

        int queryResult= 0;
        String query = "";
        DataBaseConnect.establish_connection();
        Statement statement = DataBaseConnect.establish_connection().createStatement();
        query = "SELECT rate FROM rate Where client_id = " + client + ");";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            ratings.add(resultSet.getFloat("rate"));
        }
        for (int i =0; i< ratings.size(); i++)
        {
            System.out.println(ratings.get(i));
        }

        statement.close();

    }
}
