package com.example.advSoft.connection;

import java.sql.SQLException;

public interface IReqRideDatabaseConnect extends DataBaseConnect {
    public String listrequestedToDriver(String driverName) throws SQLException, ClassNotFoundException;

}
