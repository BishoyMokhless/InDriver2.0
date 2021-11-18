package Driver;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Ride.Ride;
import Offer.OfferController;
import connection.RideConnections;

public class DriverController extends Driver implements DriverServices  {

    @Override
    public List<Ride> listAllRides(Driver driver) throws SQLException, ClassNotFoundException {
        List<Ride> reqRides = new ArrayList<Ride>();
        reqRides= RideConnections.listAllRides(driver.getFavoriteAreas());
        return reqRides;
    }

    @Override
    public List<OfferController> suggestRidePrice(OfferController offer) throws SQLException, ClassNotFoundException {


        List<Ride> rides = new ArrayList<Ride>();
        rides = this.listAllRides(driver);

        List<OfferController> driverOffers = new  ArrayList<OfferController>();
        for (int i = 0; i < rides.size(); i++)
        {
            Scanner input = new Scanner(System.in);
            System.out.println(rides.get(i));
            System.out.println("Enter your price");
            float price = input.nextFloat();
            driverOffers.get(i).setDriver(driver.getUsername());
            driverOffers.get(i).setPrice(price);
            driverOffers.get(i).setClient(rides.get(i).getClient());
            driverOffers.get(i).setDestination(rides.get(i).getDestination());
            driverOffers.get(i).setSource(rides.get(i).getSource());
            driverOffers.get(i).setAccepted(false);

        }
        return driverOffers;

    }

    @Override
    public void FavAreas(String area) throws SQLException, ClassNotFoundException {
        driver.getFavoriteAreas().add(area);
    }

}
