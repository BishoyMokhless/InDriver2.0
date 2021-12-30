package com.example.advSoft.connection;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.*;

public class RideDatabaseConnect implements DataBaseConnect {
    @Override
    public Connection establish_connection() throws SQLException, ClassNotFoundException {
        String url="jdbc:mysql://localhost:3306/sprint2";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection= DriverManager.getConnection(url,"root","root");
        return connection;
    }

    @Override
    public void set(JSONObject ride) throws SQLException, ClassNotFoundException {

        Integer clientsNumber =Integer.parseInt((String) ride.get("clients_number"));
        String query = " insert into ride (offer_id,arrive_source_time,arrive_destination_time,discount_value,discount_percent,price_after_discount) values (?,?,?,?,?,?)";
        PreparedStatement preparedStmt = establish_connection().prepareStatement(query);
        preparedStmt.setString (1, (String) ride.get("offer_id"));
        preparedStmt.setString (2, (String) ride.get("arrive_source_time"));
        preparedStmt.setString (3, (String) ride.get("arrive_destination_time"));
        preparedStmt.setString (4, (String) ride.get("discount_value"));
        preparedStmt.setString (5, (String) ride.get("discount_percent"));
        preparedStmt.setString (6, (String) ride.get("price_after_discount"));

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public JSONObject get(int id) throws SQLException, ClassNotFoundException {
        JSONObject ride = new JSONObject();
        Statement statement = establish_connection().createStatement();
        ResultSet rs = statement.executeQuery("select *  from ride where ( id ='"+id+"')");
        while(rs.next())
        {
            ride.put("offer_id",rs.getInt("offer_id"));
            ride.put("arrive_source_time",rs.getDate("arrive_source_time"));
            ride.put("arrive_destination_time",rs.getTimestamp("arrive_destination_time"));
            ride.put("discount_value",rs.getDouble("discount_value"));
            ride.put("discount_percent",rs.getDouble("discount_percent"));
            ride.put("price_after_discount",rs.getDouble("price_after_discount"));
        }
        return ride;
    }

    @Override
    public JSONArray listAll() throws SQLException, ClassNotFoundException {
        JSONArray allRides = new JSONArray();
        Statement statement = establish_connection().createStatement();
        ResultSet rs = statement.executeQuery("select *  from ride");
        while(rs.next())
        {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("offer_id",rs.getInt("offer_id"));
            jsonObject.put("arrive_source_time",rs.getDate("arrive_source_time"));
            jsonObject.put("arrive_destination_time",rs.getTimestamp("arrive_destination_time"));
            jsonObject.put("discount_value",rs.getDouble("discount_value"));
            jsonObject.put("discount_percent",rs.getDouble("discount_percent"));
            jsonObject.put("price_after_discount",rs.getDouble("price_after_discount"));
            allRides.put(jsonObject);
        }
        return allRides;
    }


    public JSONArray listAllByDriverName(String DriverName) throws SQLException, ClassNotFoundException {
        JSONArray allRides = new JSONArray();
        Statement statement = establish_connection().createStatement();
        ResultSet rs = statement.executeQuery("select *  from ride where ( DriverName= '" + DriverName + "')");
        while(rs.next())
        {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("offer_id",rs.getInt("offer_id"));
            jsonObject.put("arrive_source_time",rs.getDate("arrive_source_time"));
            jsonObject.put("arrive_destination_time",rs.getTimestamp("arrive_destination_time"));
            jsonObject.put("discount_value",rs.getDouble("discount_value"));
            jsonObject.put("discount_percent",rs.getDouble("discount_percent"));
            jsonObject.put("price_after_discount",rs.getDouble("price_after_discount"));
            allRides.put(jsonObject);
        }
        return allRides;
    }


    @Override
    public void update(JSONObject temp) throws SQLException, ClassNotFoundException {

    }
}
