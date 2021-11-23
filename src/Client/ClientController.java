package Client;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connection.OfferConnections;
import connection.RideConnections;
import Offer.Offer;

public class ClientController extends Client implements  ClientServices {

    @Override
    public void RequestRide(String clientName, String source, String destination) throws SQLException, ClassNotFoundException
    {
        RideConnections.RequestRide(clientName, source, destination);
    }

    @Override
    public List<Offer> viewOffers() throws SQLException, ClassNotFoundException {
        List<Offer> offers = new ArrayList<Offer>();
        offers.addAll(OfferConnections.listAllOffers(this));
        return offers;
    }

    @Override
    public void acceptOffer(Offer offer) throws SQLException, ClassNotFoundException {
        offer.setAccepted(true);
        OfferConnections.updateOffer(offer);
    }
}
