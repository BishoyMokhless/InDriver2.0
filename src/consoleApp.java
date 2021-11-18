import Admin.*;
import Client.*;
import connection.*;
import Driver.*;
import Offer.*;
import Ratings.*;
import Ride.*;
import User.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class consoleApp {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DriverController d=new DriverController();
        /*d.setUsername("fouad12");
        d.setEmail("fouad@123");
        d.setDrivingLicense("12345678912345");
        d.setNationalID("12345678912345");
        d.setFavoriteAreas("cairo");
        d.setPassword("111");*/
        List<String> fav = new ArrayList<String>();
        List<OfferController> offers = new ArrayList<OfferController>();
        fav.add("cairo");
        fav.add("bsaten");
        fav.add("helwan");


       d.registerDriver("amm","amm","119","1110kk","amm100p","amm44",fav);
       ClientController c = new ClientController();
       c.registerClient("cll","cll","os9ama","po19798");
       OfferController o = new OfferController();
       c.RequestRide("cll", "helwan", "bsaten");
       offers = d.suggestRidePrice();
       o.setDriver(d.getUsername());
       o.setClient("cll");
       o.setSource("helwan");
       o.setDestination("bsaten");
       o.setPrice(150);
       o.setAccepted(false);
       o.sendOffer(o);
       c.acceptOffers(o);

    }
}
