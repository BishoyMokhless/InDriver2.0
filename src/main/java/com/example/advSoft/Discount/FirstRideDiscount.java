package com.example.advSoft.Discount;

import com.example.advSoft.connection.BirthdayDatabaseConnect;
import com.example.advSoft.connection.FirstRideDiscountDatabseConnect;
import com.example.advSoft.connection.IDiscountDatabaseConnect;
import org.json.JSONArray;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class FirstRideDiscount implements  Discount {

    @Override
    public double getDiscount(String clientName) throws SQLException, ClassNotFoundException {
        IDiscountDatabaseConnect DBDiscount=new FirstRideDiscountDatabseConnect();
        return DBDiscount.getDiscount(clientName);
    }

}
