package connection;

import Client.Client;
import Ratings.Ratings;
import Ride.Ride;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RateConnections implements DataBaseConnect{

    public void addRate(String clientName, String driverName,int rate) throws SQLException, ClassNotFoundException {

        DataBaseConnect.establish_connection();
        String query="INSERT INTO rate (clientName, driverName, rate)"+" VALUES(?, ?, ? ) ";
        PreparedStatement preparedStmt = DataBaseConnect.establish_connection().prepareStatement(query);
        preparedStmt.setString(1, clientName);
        preparedStmt.setString(2, driverName);
        preparedStmt.setInt(3,rate);
        preparedStmt.executeUpdate();
    };

    public static float viewClientsRate(String Client) throws SQLException, ClassNotFoundException {

        DataBaseConnect.establish_connection();
        String query="select avg(rate) from rate where clientName = ?  ";
        PreparedStatement preparedStmt = DataBaseConnect.establish_connection().prepareStatement(query);
        preparedStmt.setString(1, Client);
        ResultSet rs = preparedStmt.executeQuery();
        if(rs.next())
           return  rs.getFloat("rate");
        else
            return  0;

    };
    public List<Ratings> viewDriverRate(List<Float> ratings)
    {


        return ratings;
    };


}
