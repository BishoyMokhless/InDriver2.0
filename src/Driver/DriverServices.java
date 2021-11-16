package Driver;


import Offer.Offer;

import java.sql.SQLException;

public interface DriverServices {
    Driver driver = new Driver();
    Offer offer = null;

    public String listAllRides(String username) throws SQLException, ClassNotFoundException;
    public float suggestRidePrice();
    public String FavAreas();
    public String NotifyUser();


}
