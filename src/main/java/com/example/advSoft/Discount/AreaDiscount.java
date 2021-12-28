package com.example.advSoft.Discount;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.*;

import static com.example.advSoft.connection.DataBaseConnect.establish_connection;

public class AreaDiscount implements Discount{
    @Override

    public double getDiscount(String clientName) throws SQLException, ClassNotFoundException {
        Connection c1 = establish_connection();
        JSONArray arr = new JSONArray();
        Statement statement = establish_connection().createStatement();
        ResultSet rs = statement.executeQuery("select destination from requestedrides where clientName='"+clientName+"' and accepted = 0");
        if(rs.next())
            return 0.1;
        else
            return 0;
    }
}
