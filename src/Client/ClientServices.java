package Client;

import java.sql.SQLException;
import java.util.List;
import Offer.Offer;
public interface ClientServices  {

    Client client = new Client();
    public void RequestRide(String clientName, String source, String destination) throws SQLException, ClassNotFoundException;
    public List<Offer> viewOffers() throws SQLException, ClassNotFoundException;
    public void acceptOffer(Offer offer) throws SQLException, ClassNotFoundException;
}
