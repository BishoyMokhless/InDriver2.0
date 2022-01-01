package com.example.advSoft.Rating;

import java.sql.SQLException;
import java.util.List;

public interface RateService {
    public List<Float> viewRating(String driverName) throws SQLException, ClassNotFoundException;


}
