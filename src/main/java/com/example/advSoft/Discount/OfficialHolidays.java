package com.example.advSoft.Discount;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.example.advSoft.connection.DataBaseConnect.establish_connection;

public class OfficialHolidays implements Discount{

    public double getDiscount(String clientName) throws SQLException, ClassNotFoundException {
        Connection c1 = establish_connection();
        JSONArray arr = new JSONArray();
        Statement statement = establish_connection().createStatement();
        ResultSet rs = statement.executeQuery("select *  from officialHoliday where date = CURDATE()");
        if(rs.next())
        {
            String holiday = rs.getString("holidayName");
            System.out.println("Dear, " + clientName + " You have a 5% Discount for your trip since today is a " + holiday + " Holiday");
            return 0.05;
        }
        else
            return 0;
    }
}
