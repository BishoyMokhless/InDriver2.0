package Driver;

import java.sql.SQLException;
import java.util.List;
import connection.OfferConnections;
import Offer.Offer;
import Ride.Ride;
import connection.RideConnections;

public class DriverController extends Driver implements DriverServices  {

    @Override
    public List<Ride> listAllRides() throws SQLException, ClassNotFoundException {
        return RideConnections.listAllRides(this.getFavoriteAreas());
    }

    @Override
    public void sendOffer(Offer offer) throws SQLException, ClassNotFoundException {
        OfferConnections.setOffer(offer);
    }

    @Override
    public void suggestRidePrice(Ride ride, float price) throws SQLException, ClassNotFoundException {
        Offer newOffer = new Offer();
        newOffer.setDriver(this.getUsername());
        newOffer.setPrice(price);
        newOffer.setClient(ride.getClient());
        newOffer.setDestination(ride.getDestination());
        newOffer.setSource(ride.getSource());
        newOffer.setAccepted(false);
        sendOffer(newOffer);
    }

    @Override
    public void FavAreas(String area) throws SQLException, ClassNotFoundException {
        driver.getFavoriteAreas().add(area);
    }

}
