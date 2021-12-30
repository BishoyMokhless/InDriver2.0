package com.example.advSoft.connection;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.*;

public class ReqRideDatabaseConnect implements DataBaseConnect{
    @Override
    public Connection establish_connection() throws SQLException, ClassNotFoundException {
        String url="jdbc:mysql://localhost:3306/sprint2";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection= DriverManager.getConnection(url,"root","root");
        return connection;
    }

    @Override
    public void set(JSONObject reqRide) throws SQLException, ClassNotFoundException {
        Integer clientsNumber =Integer.parseInt((String) reqRide.get("clients_number"));
        String query = " insert into requestedrides (clientName,source,destination,accepted,clients_number) values (?,?,?,?,?)";
        PreparedStatement preparedStmt = establish_connection().prepareStatement(query);
        preparedStmt.setString (1, (String) reqRide.get("ClientName"));
        preparedStmt.setString (2, (String) reqRide.get("source"));
        preparedStmt.setString (3, (String) reqRide.get("destination"));
        preparedStmt.setInt (4, 0);
        preparedStmt.setInt (5, clientsNumber);
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

        JSONArray allReqRides = new JSONArray();
        Statement statement = establish_connection().createStatement();
        ResultSet rs = statement.executeQuery("select *  from requestedrides");
        while(rs.next())
        {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("clientName",rs.getString("clientName"));
            jsonObject.put("source",rs.getString("source"));
            jsonObject.put("destination",rs.getString("destination"));
            jsonObject.put("accepted",rs.getString("accepted"));
            jsonObject.put("clients_number",rs.getInt("clients_number"));
            jsonObject.put("requestedride_time",rs.getInt("requestedride_time"));
            allReqRides.put(jsonObject);
        }
        return allReqRides;
    }

    @Override
    public void update(JSONObject reqRide,int id) {



    }
}
