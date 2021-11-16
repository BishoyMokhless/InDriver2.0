package Client;

import Offer.Offer;

public interface ClientServices  {

    Client client = new Client();

    public void RequestRide(String Destination, String Source , int price);
}
