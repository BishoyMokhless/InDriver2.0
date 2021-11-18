package Client;

import Offer.Offer;

import java.sql.SQLException;

public interface ClientServices  {

    Client client = new Client();

    public void RequestRide(String clientName, String sorce, String destination) throws SQLException, ClassNotFoundException;
}
