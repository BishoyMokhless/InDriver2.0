package Offer;

import java.sql.SQLException;

public interface Offer  {

    public void sendOffer(OfferModel offer) throws SQLException, ClassNotFoundException;
    //public void receiveOffer(int client_id, int driver_id, float price,String source,String destination) throws SQLException, ClassNotFoundException;
}
