package Driver;


import Offer.Offer;
import Offer.OfferController;
import Ride.Ride;

import java.sql.SQLException;
import java.util.List;

public interface DriverServices {
    Driver driver = new Driver();
    Offer offer = null;

    public List<Ride> listAllRides(Driver driver) throws SQLException, ClassNotFoundException;
    public List<OfferController> suggestRidePrice(OfferController offer) throws SQLException, ClassNotFoundException;
    public void FavAreas(String area) throws SQLException, ClassNotFoundException;



}
