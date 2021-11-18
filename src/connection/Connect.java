package connection;
import Client.Client;
import Offer.OfferModel;
import Ride.Ride;
import User.User;

import java.sql.*;

import java.util.*;
import java.util.concurrent.Executor;
import Ride.RequestedRide;
public class Connect {


    public  static Connection establish_connection() throws SQLException, ClassNotFoundException {
        String url="jdbc:mysql://localhost:3306/sprint1";
        //\connect root@localhost
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn= DriverManager.getConnection(url,"root","fouad9111999");
        //   System.out.println("good");
        return conn;
    }
    public static void read_drivers() throws SQLException, ClassNotFoundException {

        Connection conn= establish_connection();
        String query="SELECT * FROM driver";
        Statement st=conn.createStatement();
        ResultSet re=st.executeQuery(query);
        while(re.next())
        {
            System.out.println(re.getString("username"));
        }
    }

    public static List<RequestedRide> listAllRides() throws SQLException, ClassNotFoundException {

        establish_connection();
        String query = "SELECT * FROM RequestedRides Where source = ";
        Statement st=conn.createStatement();
        ResultSet re=st.executeQuery(query);
        while(re.next())
        {
            System.out.println(re.getString("username"));
        }
    }

    public static void setter(String column , String rowData, User obj) throws SQLException, ClassNotFoundException
    {
        Scanner scanner = new Scanner(System.in);
        int queryResult= 0;
        String type = "";
        establish_connection();
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
        establish_connection();
        String query = " insert into favArea (driverName, area) values (?, ?)";
        PreparedStatement preparedStmt = establish_connection().prepareStatement(query);
        preparedStmt.setString (1, username);
        preparedStmt.setString (2, area);
        establish_connection().close();
    }

    public static void RequestRide(String clientName, String source, String destination) throws SQLException, ClassNotFoundException
    {
        Connect.establish_connection();
        String query="INSERT INTO requestedRides (clientName, source, destination)"+" VALUES(?, ?, ?) ";
        PreparedStatement preparedStmt = Connect.establish_connection().prepareStatement(query);
        preparedStmt.setString(1,clientName);
        preparedStmt.setString(2, source);
        preparedStmt.setString(3,destination);
        preparedStmt.executeUpdate();
    }

     public static void setOffer(OfferModel offer) throws SQLException, ClassNotFoundException
     {
         establish_connection();
         String query="INSERT INTO offer (clientName, driverName, price, source,destination)"+" VALUES(?, ?, ? ,?,?) ";
         PreparedStatement preparedStmt = establish_connection().prepareStatement(query);
         preparedStmt.setString(1,offer.getClient());
         preparedStmt.setFloat(2,offer.getPrice());
         preparedStmt.setString(3,offer.getSource());
         preparedStmt.setString(4,offer.getDestination());
         preparedStmt.executeUpdate();
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
