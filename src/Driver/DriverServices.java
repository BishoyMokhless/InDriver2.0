package Driver;


import Offer.Offer;
import Ride.Ride;

import java.sql.SQLException;
import java.util.List;

public interface DriverServices {
    Driver driver = new Driver();
    Offer offer = null;

    public List<Ride> listAllRides(String username) throws SQLException, ClassNotFoundException;
    public Offer suggestRidePrice(Offer offer);
    public String FavAreas();
    public String NotifyUser();


}
