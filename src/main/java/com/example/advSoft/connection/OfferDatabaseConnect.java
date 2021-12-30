package com.example.advSoft.connection;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OfferDatabaseConnect implements DataBaseConnect{

    @Override
    public Connection establish_connection() throws SQLException, ClassNotFoundException {
        String url="jdbc:mysql://localhost:3306/sprint2";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection= DriverManager.getConnection(url,"root","root");
        return connection;
    }

    @Override
    public void set(JSONObject offer) throws SQLException, ClassNotFoundException {
        String query = " insert into offer (driverName,ReqRID,price,accepted) values (?,?,?,?)";
        PreparedStatement preparedStmt = establish_connection().prepareStatement(query);
        preparedStmt.setString(1, (String) offer.get("driverName"));
        preparedStmt.setString (2, (String) offer.get("ReqRID)"));
        preparedStmt.setString (3, (String) offer.get("price"));
        preparedStmt.setString (4, (String) offer.get("accepted"));
        preparedStmt.executeUpdate();
        establish_connection().close();
        System.out.println("one offer created");
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public JSONObject get(int id) throws SQLException, ClassNotFoundException {
        JSONObject offer = new JSONObject();
        Statement statement = establish_connection().createStatement();
        ResultSet rs = statement.executeQuery("select *  from offer where  id = '"+ id + "'");
        while(rs.next())
        {
            offer.put("driverName",rs.getString("driverName"));
            offer.put("id",rs.getString("id"));
            offer.put("ReqRID",rs.getString("ReqRID"));
            offer.put("offerTime",rs.getString("offerTime"));
            offer.put("price",rs.getString("price"));
        }

        return offer;
    }

    @Override
    public JSONArray listAll() throws SQLException, ClassNotFoundException {
        JSONArray allOffers = new JSONArray();
        Statement statement = establish_connection().createStatement();
        ResultSet rs = statement.executeQuery("select *  from offer");
        while(rs.next())
            {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("driverName",rs.getString("driverName"));
                jsonObject.put("id",rs.getString("id"));
                jsonObject.put("ReqRID",rs.getString("ReqRID"));
                jsonObject.put("offerTime",rs.getString("offerTime"));
                jsonObject.put("price",rs.getString("price"));
                allOffers.put(jsonObject);
            }

        return allOffers;
    }

    //not Sure if the update query work
    @Override
    public void update(JSONObject offer) throws SQLException, ClassNotFoundException {

        String query = " update  offer SET (driverName,ReqRID,price,accepted) values (?,?,?,?) WHERE ('id = "+(int) offer.get("id")+"')";
        PreparedStatement preparedStmt = establish_connection().prepareStatement(query);
        preparedStmt.setString(1, (String) offer.get("driverName"));
        preparedStmt.setString (2, (String) offer.get("ReqRID)"));
        preparedStmt.setString (3, (String) offer.get("price"));
        preparedStmt.setString (4, (String) offer.get("accepted"));
        preparedStmt.executeUpdate();
        establish_connection().close();
        System.out.println("one offer updated");

    }

}
