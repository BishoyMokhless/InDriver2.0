package com.example.advSoft.connection;

import java.sql.SQLException;

public interface IOfferDatabaseConnect extends DataBaseConnect{
    public String viewOffersOfClient(String clientName) throws SQLException, ClassNotFoundException;
}
