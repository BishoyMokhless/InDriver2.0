package Offer;

import java.sql.SQLException;

public interface Offer  {

    float price = 0;
    String source = null;
    String destination = null;
    public void sendOffer(int client_id, int driver_id, float price,String source,String destination) throws SQLException, ClassNotFoundException;
    public void receiveOffer(int client_id, int driver_id, float price,String source,String destination) throws SQLException, ClassNotFoundException;
}
