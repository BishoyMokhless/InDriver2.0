package com.example.advSoft.Discount;

import com.example.advSoft.connection.IDiscountDatabaseConnect;
import com.example.advSoft.connection.NClientDatabaseConnect;
import com.example.advSoft.connection.OfficialHolidayDatabaseConnect;
import org.json.JSONArray;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class NclientsDiscount implements  Discount{
    @Override
    public double getDiscount(String clientName) throws SQLException, ClassNotFoundException {
        IDiscountDatabaseConnect DBDiscount=new NClientDatabaseConnect();
        return DBDiscount.getDiscount(clientName);
    }
}
