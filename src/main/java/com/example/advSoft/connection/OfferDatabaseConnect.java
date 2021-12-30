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
    public void set(JSONObject object) throws SQLException, ClassNotFoundException {
        String query = " insert into offer (username,email,pass,mobileNumber,status,birthdate) values (?,?,?,?,?,?)";
        PreparedStatement preparedStmt = establish_connection().prepareStatement(query);
        preparedStmt.setString (1, (String) Client.get("username"));
        preparedStmt.setString (2, (String) Client.get("email"));
        preparedStmt.setString (3, (String) Client.get("pass"));
        preparedStmt.setString (4, (String) Client.get("mobileNumber"));
        preparedStmt.setString (5, "UnVerified");
        preparedStmt.setString (6, "birthdate");

        preparedStmt.executeUpdate();
        establish_connection().close();
        System.out.println("one Client created");
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public JSONObject get(int id) {
        return null;
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

    @Override
    public void update(Object temp) {

    }

}
