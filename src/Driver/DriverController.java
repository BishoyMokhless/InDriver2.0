package Driver;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Offer.OfferModel;
import Ride.Ride;
import Offer.OfferController;
import connection.RideConnections;
import Offer.*;

public class DriverController extends Driver implements DriverServices  {

    @Override
    public List<Ride> listAllRides() throws SQLException, ClassNotFoundException {
        List<Ride> reqRides = new ArrayList<Ride>();

        //reqRides.addAll(RideConnections.listAllRides(driver.getFavoriteAreas()));
        //System.out.println(reqRides.get(0).getClient());
        //return reqRides;

        return RideConnections.listAllRides(this.getFavoriteAreas());
    }

    @Override
    public OfferController suggestRidePrice(int index) throws SQLException, ClassNotFoundException {
        List<Ride> rides = new ArrayList<Ride>();
        rides.addAll(this.listAllRides());


            List<OfferController> driverOffers = new  ArrayList<OfferController>();

            Scanner input = new Scanner(System.in);
            System.out.println(rides.get(index));
            System.out.println("Enter your price");
            float price = input.nextFloat();
            OfferController newOffer = new OfferController();
            newOffer.setDriver(this.getUsername());
            newOffer.setPrice(price);
            newOffer.setClient(rides.get(index).getClient());
            newOffer.setDestination(rides.get(index).getDestination());
            newOffer.setSource(rides.get(index).getSource());
            newOffer.setAccepted(false);
            //driverOffers.get(i).setDriver(this.getUsername());
            //driverOffers.get(i).setPrice(price);
            //driverOffers.get(i).setClient(rides.get(i).getClient());
            //driverOffers.get(i).setDestination(rides.get(i).getDestination());
            //driverOffers.get(i).setSource(rides.get(i).getSource());
            //driverOffers.get(i).setAccepted(false);
            //driverOffers.get(i).sendOffer(driverOffers.get(i));
            //driverOffers.add(newOffer);
            //driverOffers.get(index).sendOffer(newOffer);
            newOffer.sendOffer(newOffer);
            //System.out.println(driverOffers.get(i).getDriver());

        return newOffer;
    }

    @Override
    public void FavAreas(String area) throws SQLException, ClassNotFoundException {
        driver.getFavoriteAreas().add(area);
    }

}
