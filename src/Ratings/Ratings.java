package Ratings;
import Driver.Driver;
import Client.Client;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface Ratings
{
       public void viewRatings(List<Float> ratings) throws SQLException, ClassNotFoundException;
}
