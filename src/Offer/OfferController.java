package Offer;
import java.sql.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import connection.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OfferController implements Offer {

    @Override
    public void sendOffer(int client_id,int driver_id,float price, String source, String destination) throws SQLException, ClassNotFoundException {

        Connect C1 = new Connect();
        Connection conn=  C1.establish_connection();
        String query="INSERT INTO offer (client_id,driver_id,price, source,destination)"+" VALUES(?, ?, ? ,?,?) ";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setInt(1,client_id);
        preparedStmt.setInt(2,driver_id);
        preparedStmt.setFloat(3,price);
        preparedStmt.setString(4,source);
        preparedStmt.setString(5,destination);
        preparedStmt.executeUpdate();

    }

    @Override
    public void receiveOffer(int client_id, int driver_id, float price, String source, String destination) throws SQLException, ClassNotFoundException {

        Connect C1 = new Connect();
        Connection conn=  C1.establish_connection();
        String query="update  offer set status= ?  where client_id=? and driver_id=? and price=? and source=? and destination=? ";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setBoolean(1,true);
        preparedStmt.setInt(2,client_id);
        preparedStmt.setInt(3,driver_id);
        preparedStmt.setFloat(4,price);
        preparedStmt.setString(5,source);
        preparedStmt.setString(6,destination);
        preparedStmt.executeUpdate();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        OfferController c1=new  OfferController();
        c1.sendOffer(1,2, (float) 3.1,"cairo","giza");
    }


}