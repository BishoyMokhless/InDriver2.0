package Client;

import java.sql.SQLException;
import java.util.List;

import Offer.OfferController;
import connection.OfferConnections;
import connection.RideConnections;

public class ClientController implements  ClientServices {

    @Override
    public void RequestRide(String clientName, String source, String destination) throws SQLException, ClassNotFoundException
    {
        RideConnections.RequestRide(clientName, source, destination);
    }

    @Override
    public void viewOffers(List<OfferController> offers) {
        for (int i=0; i<offers.size();i++)
        {
            System.out.println(offers.get(i));
        }
    }

    @Override
    public void acceptOffers(OfferController offer) throws SQLException, ClassNotFoundException {
        offer.setAccepted(true);
        OfferConnections.updateOffer(offer);
    }
}
