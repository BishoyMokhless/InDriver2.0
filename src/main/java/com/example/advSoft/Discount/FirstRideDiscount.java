package com.example.advSoft.Discount;

import org.json.JSONArray;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class FirstRideDiscount implements  Discount {

    @Override
    public double getDiscount(String clientName) throws SQLException, ClassNotFoundException {
//        Connection c1 = establish_connection();
//        JSONArray arr = new JSONArray();
//        Statement statement = establish_connection().createStatement();
//        ResultSet rs = statement.executeQuery("select * from requestedrides where clientName='"+clientName+"' and accepted = 1");
//        if(rs.next())
//            return 0;
//        else
//            return 0.1;
        return 0;
    }

}
