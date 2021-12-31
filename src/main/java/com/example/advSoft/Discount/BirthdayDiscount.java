package com.example.advSoft.Discount;

import com.example.advSoft.connection.AreaDiscountDatabseConnect;
import com.example.advSoft.connection.BirthdayDatabaseConnect;
import com.example.advSoft.connection.IDiscountDatabaseConnect;
import org.json.JSONArray;

import java.sql.*;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;


public class BirthdayDiscount implements Discount{
    @Override
    public double getDiscount(String clientName) throws SQLException, ClassNotFoundException {
        IDiscountDatabaseConnect DBDiscount=new BirthdayDatabaseConnect();
         return DBDiscount.getDiscount(clientName);
    }
}
