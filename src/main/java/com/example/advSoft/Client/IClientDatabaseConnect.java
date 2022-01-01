package com.example.advSoft.Client;

import com.example.advSoft.connection.DataBaseConnect;
import org.json.JSONObject;

import java.sql.SQLException;

public interface IClientDatabaseConnect extends DataBaseConnect {
    public JSONObject login(String client) throws SQLException, ClassNotFoundException;
}
