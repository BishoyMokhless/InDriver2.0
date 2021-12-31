package com.example.advSoft.connection;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ReqRideDatabaseConnect implements IReqRideDatabaseConnect{
    @Override
    public Connection establish_connection() throws SQLException, ClassNotFoundException {
        String url="jdbc:mysql://localhost:3306/sprint2";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection= DriverManager.getConnection(url,"root","root");
        return connection;
    }

    @Override
    public void set(JSONObject reqRide) throws SQLException, ClassNotFoundException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        Integer clientsNumber =Integer.parseInt((String) reqRide.get("clients_number"));
        String query = " insert into requestedrides (clientName, source, destination, clients_number, requestedride_time, accepted) values (?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStmt = establish_connection().prepareStatement(query);
        preparedStmt.setString (1, (String) reqRide.get("clientName"));
        preparedStmt.setString (2, (String) reqRide.get("source"));
        preparedStmt.setString (3, (String) reqRide.get("destination"));
        preparedStmt.setInt (4, clientsNumber);
        preparedStmt.setString(5, dtf.format(now).toString());
        preparedStmt.setInt (6, 0);
        preparedStmt.executeUpdate();
        establish_connection().close();
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
    public String listrequestedToDriver(String driverName) throws SQLException, ClassNotFoundException
    {
        List<String> favArea = new ArrayList<String>();
        JSONArray arr = new JSONArray();
        Statement statement = establish_connection().createStatement();
        ResultSet rs = statement.executeQuery("select *  from favarea where driverName = '" + driverName + "'");
        while(rs.next())
        {
            favArea.add(rs.getString("area"));
        }
        for (int i = 0; i < favArea.size(); i++)
        {
            statement = establish_connection().createStatement();
            rs = statement.executeQuery("select *  from requestedrides where source = '" + favArea.get(i) + "' and  accepted = 0");
            while(rs.next())
            {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id",rs.getString("id"));
                jsonObject.put("clientName",rs.getString("clientName"));
                jsonObject.put("source",rs.getString("source"));
                jsonObject.put("destination",rs.getString("destination"));
                jsonObject.put("clients_number",rs.getString("clients_number"));
                jsonObject.put("requestedride_time",rs.getString("requestedride_time"));
                jsonObject.put("accepted", rs.getString("accepted"));
                arr.put(jsonObject);
            }
        }
        return arr.toString();
    }
}
