package Client;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import Offer.Offer;
import Offer.OfferController;
import connection.Connect;

public class ClientController implements  ClientServices {

    Offer offer = new OfferController();

    @Override
    public void RequestRide(String clientName, String source, String destination) throws SQLException, ClassNotFoundException
    {
        Connect.RequestRide(clientName, source, destination);
    }
}
