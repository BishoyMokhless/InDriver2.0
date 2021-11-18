package Ratings;

import java.sql.SQLException;
import java.util.List;

public interface Ratings
{
       public List<Float> viewRatings(String username) throws SQLException, ClassNotFoundException;
}
