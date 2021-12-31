package com.example.advSoft.connection;

import java.sql.SQLException;

public interface IRideDatabaseConnect extends DataBaseConnect{
    public String listAllRides(String drivername) throws ClassNotFoundException, SQLException;
    public boolean checkOpenedRide(String driverName) throws SQLException, ClassNotFoundException;
}
