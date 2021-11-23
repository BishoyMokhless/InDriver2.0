package Driver;

import Offer.Offer;
import Ride.Ride;
import java.sql.SQLException;
import java.util.List;

public interface DriverServices {
    Driver driver = new Driver();
    Offer offer = null;

    public List<Ride> listAllRides() throws SQLException, ClassNotFoundException;
    public void suggestRidePrice(Ride ride, float price) throws SQLException, ClassNotFoundException;
    public void FavAreas(String area) throws SQLException, ClassNotFoundException;
    public void sendOffer(Offer offer) throws SQLException, ClassNotFoundException;



}
