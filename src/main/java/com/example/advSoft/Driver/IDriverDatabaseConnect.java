package com.example.advSoft.Driver;

import com.example.advSoft.connection.DataBaseConnect;
import org.json.JSONObject;

import java.sql.SQLException;

public interface IDriverDatabaseConnect extends DataBaseConnect {
    public JSONObject login(String person) throws SQLException, ClassNotFoundException;

}
