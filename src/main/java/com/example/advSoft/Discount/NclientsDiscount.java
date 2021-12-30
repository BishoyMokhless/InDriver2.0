package com.example.advSoft.Discount;

import org.json.JSONArray;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class NclientsDiscount implements  Discount{
    @Override
    public double getDiscount(String clientName) throws SQLException, ClassNotFoundException {
//        Connection c1 = establish_connection();
//        JSONArray arr = new JSONArray();
//        Statement statement = establish_connection().createStatement();
//        ResultSet rs = statement.executeQuery("select clients_number from requestedrides where clientName='"+clientName+"' and accepted = 0");
//        if(rs.next())
//        {
//            if(rs.getInt("clients_number") >= 2)
//                return 0.05;
//            else
//                return 0;
//        }
        return 0;
    }
}
