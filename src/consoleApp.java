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
import java.util.Scanner;

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

        fav.add("cairo");
        fav.add("bsaten");
        fav.add("helwan");
        List<Ride> rides = new ArrayList<Ride>();
        d.registerDriver("fqq1e","8811qqqef","ffqqef","f11qqqef","feqq","fffqqq",fav);
        ClientController c = new ClientController();
        c.registerClient("ffqqf","ffqqq1f","ffqqqff","fffqqqds");
        OfferController o = new OfferController();
        c.RequestRide("ffqqf", "helwan", "bsaten");
        rides = d.listAllRides();
        for(int i = 0; i < rides.size(); i++)
        {
            System.out.println(rides.get(i));
        }
        Scanner input = new Scanner(System.in);
        System.out.println("enter the index: ");
        int index = input.nextInt();
        OfferController offer = new OfferController();
        offer = d.suggestRidePrice(index);
        c.acceptOffers(offer);

       // c.acceptOffers(o);
    }
}
