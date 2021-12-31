package com.example.advSoft.Discount;

import com.example.advSoft.connection.AreaDiscountDatabseConnect;
import com.example.advSoft.connection.DataBaseConnect;
import com.example.advSoft.connection.IDiscountDatabaseConnect;
import org.json.JSONArray;
import java.sql.*;


public class AreaDiscount implements Discount {

    @Override
    public double getDiscount(String clientName) throws SQLException, ClassNotFoundException {
        IDiscountDatabaseConnect DBDiscount=new AreaDiscountDatabseConnect();
       return DBDiscount.getDiscount(clientName);
    }
}