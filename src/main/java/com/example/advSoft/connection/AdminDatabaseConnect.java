package com.example.advSoft.connection;

import com.example.advSoft.Admin.Admin;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.*;
import java.util.List;

public class AdminDatabaseConnect implements DataBaseConnect {

    @Override
    public Connection establish_connection() throws SQLException, ClassNotFoundException {
        String url="jdbc:mysql://localhost:3306/sprint2";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection= DriverManager.getConnection(url,"root","root");
        return connection;
    }

    /**
 * Connection c1 = establish_connection();
 *         JSONArray arr = new JSONArray();
 *         Statement statement = establish_connection().createStatement();
 *         ResultSet rs = statement.executeQuery("select *  from driver where  status ='UnVerified' ");
 *         while(rs.next())
 *         {
 *             JSONObject jsonObject = new JSONObject();
 *             jsonObject.put("username",rs.getString("username"));
 *             jsonObject.put("email",rs.getString("email"));
 *             jsonObject.put("mobileNumber",rs.getString("mobileNumber"));
 *             jsonObject.put("nationalID",rs.getString("nationalID"));
 *             jsonObject.put("drive_license",rs.getString("drive_license"));
 *             jsonObject.put("status",rs.getString("status"));
 *             arr.put(jsonObject);
 *         }
 *         return arr.toString();***/
    @Override
    public void set(JSONObject temp) {

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
        return null;
    }


    @Override
    public void update(Object temp) {

    }
}
