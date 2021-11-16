package Client;

import Offer.Offer;

import java.sql.SQLException;

public interface ClientServices  {

    Client client = new Client();

    public void RequestRide(int client_id,int driver_id ,String Destination, String Source, float price) throws SQLException, ClassNotFoundException;
}
