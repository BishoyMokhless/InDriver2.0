package com.example.advSoft.connection;

import java.sql.SQLException;

public interface IDiscountDatabaseConnect  extends DataBaseConnect{
    public double getDiscount(String clientName) throws SQLException, ClassNotFoundException;
}
