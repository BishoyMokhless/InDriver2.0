package com.example.advSoft.connection;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.*;

public class RatingDatabaseConnect implements DataBaseConnect{
    @Override
    public Connection establish_connection() throws SQLException, ClassNotFoundException {
        String url="jdbc:mysql://localhost:3306/sprint2";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection= DriverManager.getConnection(url,"root","root");
        return connection;
    }
    @Override
    public void set(JSONObject rate) throws SQLException, ClassNotFoundException {
        String query = " insert into rate (clientName,driverName,rate) values (?,?,?)";
        PreparedStatement preparedStmt = establish_connection().prepareStatement(query);
        preparedStmt.setString (1, (String) rate.get("clientName"));
        preparedStmt.setString (2, (String) rate.get("driverName"));
        preparedStmt.setFloat (3, (Float) rate.get("rate"));
        preparedStmt.executeUpdate();
        establish_connection().close();
        System.out.println("one rate created");
    }

    @Override
    public void delete(int id) throws SQLException, ClassNotFoundException {

    }

    @Override
    public JSONObject get(int id) throws SQLException, ClassNotFoundException {
        JSONObject rate = new JSONObject();
        Statement statement = establish_connection().createStatement();
        ResultSet rs = statement.executeQuery("select *  from offer where  id = '"+ id + "'");
        while(rs.next())
        {
            rate.put("clientName",rs.getString("clientName"));
            rate.put("driverName",rs.getString("driverName"));
            rate.put("rate",rs.getFloat("rate"));
        }
        return rate;
    }

    @Override
    public JSONArray listAll() throws SQLException, ClassNotFoundException {
        JSONArray allRates = new JSONArray();
        Statement statement = establish_connection().createStatement();
        ResultSet rs = statement.executeQuery("select *  from rate");
        while(rs.next())
        {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("clientName",rs.getString("clientName"));
            jsonObject.put("driverName",rs.getString("driverName"));
            jsonObject.put("rate",rs.getFloat("rate"));
            allRates.put(jsonObject);
        }

        return allRates;
    }

    @Override
    public void update(JSONObject temp, int id) throws SQLException, ClassNotFoundException {

    }
}
