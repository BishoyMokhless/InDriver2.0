package com.example.advSoft.connection;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.*;

public class FavAreas implements DataBaseConnect{
    @Override
    public Connection establish_connection() throws SQLException, ClassNotFoundException {
        String url="jdbc:mysql://localhost:3306/sprint2";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection= DriverManager.getConnection(url,"root","root");
        return connection;
    }

    @Override
    public void set(JSONObject FavArea) throws SQLException, ClassNotFoundException {
        String query = " insert into favarea (area,driverName) values (?,?)";
        PreparedStatement preparedStmt = establish_connection().prepareStatement(query);
        preparedStmt.setString (1,  FavArea.toString());
        preparedStmt.setString (2,  "driverName");
        preparedStmt.executeUpdate();
        establish_connection().close();
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public JSONObject get(int id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public JSONArray listAll() throws SQLException, ClassNotFoundException {
        JSONArray allFavAreas = new JSONArray();
        Statement statement = establish_connection().createStatement();
        ResultSet rs = statement.executeQuery("select *  from favarea");
        while(rs.next()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("area", rs.getString("area"));
            jsonObject.put("driverName", rs.getString("driverName"));
            allFavAreas.put(jsonObject);
        }
        return allFavAreas;
    }

    @Override
    public void update(JSONObject temp,int id) throws SQLException, ClassNotFoundException {

    }
}
