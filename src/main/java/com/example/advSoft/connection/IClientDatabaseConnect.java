package com.example.advSoft.connection;

import org.json.JSONObject;

import java.sql.SQLException;

public interface IClientDatabaseConnect extends DataBaseConnect{
    public JSONObject login(String client) throws SQLException, ClassNotFoundException;
}
