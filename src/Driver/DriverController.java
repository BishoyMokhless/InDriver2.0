package Driver;

import Offer.Offer;
import Offer.Offer;
import Ride.Ride;
import connection.Connect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Ride.RequestedRide;
public class DriverController implements DriverServices {

    public List<RequestedRide> listAllRides(Driver driver) throws SQLException, ClassNotFoundException {
        List<RequestedRide> reqRides = new ArrayList<RequestedRide>();
        Connect.listAllRides(driver.getFavoriteAreas());

    }

    @Override
    public Offer suggestRidePrice(OfferController offer)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your price");
        float price = input.nextFloat();
        offer.
    }

    @Override
    public String FavAreas() {
        return null;
    }

    @Override
    public String NotifyUser() {
        return null;
    }
}
