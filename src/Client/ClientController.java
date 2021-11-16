package Client;

import java.sql.SQLException;
import java.util.Scanner;

import Offer.Offer;
import Offer.OfferController;
public class ClientController implements  ClientServices {

    Offer offer = new OfferController();

    @Override
    public void RequestRide(int client_id,int driver_id ,String Destination, String Source, float price) throws SQLException, ClassNotFoundException {

        offer.sendOffer(client_id,driver_id,price,Source,Destination);


    }


}
