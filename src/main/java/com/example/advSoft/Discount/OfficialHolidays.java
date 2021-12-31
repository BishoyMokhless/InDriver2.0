package com.example.advSoft.Discount;

import com.example.advSoft.connection.BirthdayDatabaseConnect;
import com.example.advSoft.connection.IDiscountDatabaseConnect;
import com.example.advSoft.connection.OfficialHolidayDatabaseConnect;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class OfficialHolidays implements Discount{

    public double getDiscount(String clientName) throws SQLException, ClassNotFoundException {
        IDiscountDatabaseConnect DBDiscount=new OfficialHolidayDatabaseConnect();
        return DBDiscount.getDiscount(clientName);
    }
}
