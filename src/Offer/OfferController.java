package Offer;

import connection.OfferConnections;
import java.sql.SQLException;

public class OfferController extends OfferModel implements Offer  {

    @Override
    public void sendOffer(OfferModel offer) throws SQLException, ClassNotFoundException {
        OfferConnections.setOffer(offer);
    }

    /*@Override
    public List<OfferModel>  receiveOffer() throws SQLException, ClassNotFoundException {
        List<OfferModel> offers = new ArrayList<OfferModel>();
        offers = Connect.getOffer();
    }*/

}