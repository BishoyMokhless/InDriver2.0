package com.example.advSoft.Discount;

import org.json.JSONArray;
import java.sql.*;


public class AreaDiscount implements Discount {

    @Override
    public double getDiscount(String clientName) {
//        Connection c1 = establish_connection();
//        JSONArray arr = new JSONArray();
//        Statement statement = establish_connection().createStatement();
//        ResultSet rs = statement.executeQuery("select destination from requestedrides where clientName='"+clientName+"' and accepted = 0");
//        if(rs.next())
//            return 0.1;
//        else
//            return 0;
//    }
        return 0;
    }
}