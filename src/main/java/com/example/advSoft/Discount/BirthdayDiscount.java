package com.example.advSoft.Discount;

import org.json.JSONArray;

import java.sql.*;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;

import static com.example.advSoft.connection.DataBaseConnect.establish_connection;

public class BirthdayDiscount implements Discount{
    @Override
    public double getDiscount(String clientName) throws SQLException, ClassNotFoundException {
        LocalDate localDate = LocalDate.now();
        int day = localDate.getDayOfMonth();
        int month = localDate.getMonthValue();
        Connection c1 = establish_connection();
        JSONArray arr = new JSONArray();
        Statement statement = establish_connection().createStatement();
        ResultSet rs = statement.executeQuery("select month(birthdate) as month, day(birthdate) as day from client where username='"+clientName+"'");
        if(rs.next())
        {
            if(month == rs.getInt("month") && day == rs.getInt("day"))
                System.out.println("Dear, " + clientName + " You have a 10% Discount for your trip since today is your birthday");
            return 0.1;
        }
        return 0;
    }
}
