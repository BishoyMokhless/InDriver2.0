package Offer;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

import Client.Client;
import connection.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OfferController extends OfferModel implements Offer  {

    @Override
    public void sendOffer(OfferModel offer) throws SQLException, ClassNotFoundException {
        Connect.setOffer(offer);
    }

    /*@Override
    public List<OfferModel>  receiveOffer() throws SQLException, ClassNotFoundException {
        List<OfferModel> offers = new ArrayList<OfferModel>();
        offers = Connect.getOffer();
    }*/

}