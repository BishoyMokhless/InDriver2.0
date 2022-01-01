package com.example.advSoft.Rating;

import java.sql.SQLException;

public interface IRating {
    public void addRate(int rideId,String req) throws SQLException, ClassNotFoundException;
    public float viewAvg (String driverName) throws SQLException, ClassNotFoundException;
}
