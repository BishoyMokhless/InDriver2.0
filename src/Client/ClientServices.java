package Client;

import Offer.Offer;
import Offer.OfferController;
import java.sql.SQLException;
import java.util.List;

public interface ClientServices  {

    Client client = new Client();
    public void RequestRide(String clientName, String source, String destination) throws SQLException, ClassNotFoundException;
    public void viewOffers(List<OfferController> offers);
    public void acceptOffers(OfferController offer) throws SQLException, ClassNotFoundException;
}
