package Ratings;

import java.sql.SQLException;
import java.util.List;

public interface Ratings
{
       public void viewRatings(List<Float> ratings) throws SQLException, ClassNotFoundException;
}
