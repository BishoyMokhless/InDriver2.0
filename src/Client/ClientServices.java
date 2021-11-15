package Client;

import Offer.Offer;

public interface ClientServices  {

    Client client = new Client();
    Offer offer = null;
    public void RequestRide(String Destination,String Source );
}
