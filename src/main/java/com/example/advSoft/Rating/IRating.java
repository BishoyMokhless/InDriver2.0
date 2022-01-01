package com.example.advSoft.Rating;

import java.sql.SQLException;

public interface IRating {
    public void addRate(int rideId,float rate,String clientName) throws SQLException, ClassNotFoundException;
    public float viewAvg (String driverName) throws SQLException, ClassNotFoundException;
}
