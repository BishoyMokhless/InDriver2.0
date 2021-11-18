package connection;

import User.User;
import java.sql.*;
import java.util.*;

import static connection.DataBaseConnect.establish_connection;

public class UserConnections implements DataBaseConnect {



    public static void setter(String column , String rowData, User obj) throws SQLException, ClassNotFoundException
    {
        Scanner scanner = new Scanner(System.in);
        int queryResult= 0;
        String type = "";
        DataBaseConnect.establish_connection();
        if(obj.getClass().getName().equals("Driver"))
            type = "driver";
        else
            type = "client";

        String query = "update " + type + " set " + column + " = ?";
        PreparedStatement preparedStmt = establish_connection().prepareStatement(query);
        preparedStmt.setString(1, rowData);
        preparedStmt.executeUpdate();
        establish_connection().close();
    }

    public static void setFavorite(String username, String area) throws SQLException, ClassNotFoundException
    {
        Scanner scanner = new Scanner(System.in);
        int queryResult= 0;
        String type = "";
       Connection c1 = DataBaseConnect.establish_connection();
        String query = " insert into favArea (area, driverName) values (?, ?)";
        PreparedStatement preparedStmt = c1.prepareStatement(query);
        preparedStmt.setString (1, area);
        preparedStmt.setString (2, username);
        preparedStmt.executeUpdate();
        establish_connection().close();
    }



   /* public static List<OfferModel> getOffer(String driverUsername) throws SQLException, ClassNotFoundException
    {
        OfferModel offer = new OfferModel();
        List<OfferModel> offers = new ArrayList<OfferModel>();
        establish_connection();
        Statement statement = establish_connection().createStatement();
        ResultSet rs = statement.executeQuery("select * Offer Where driverUsername = '" + driverUsername + "'");
        while(rs.next())
        {
            offer.setClient(rs.getString("clientName"));
            offer.setDriver(rs.getString("driverName"));
            offer.setPrice(rs.getFloat("price"));
            offer.setSource(rs.getString("source"));
            offer.setDestination(rs.getString("destination"));
            offers.add(offer);
        }
        return offers;
    }*/



}
