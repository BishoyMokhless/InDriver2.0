import Client.*;
import Driver.*;
import Offer.*;
import Ride.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class consoleApp {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DriverController d=new DriverController();
        List<String> fav = new ArrayList<String>();
        List<Ride> rides = new ArrayList<Ride>();
        List<Offer> offers = new ArrayList<Offer>();

        fav.add("cairo");
        fav.add("bsaten");
        fav.add("helwan");
        d.registerDriver("fouad1s","fff1s","fff1s","fff1sf","ffs1f","fffs1",fav);


        ClientController c = new ClientController();
        c.registerClient("hassasn1","hhhsh","hhsh1","hhhhs1");

        // client Request Ride
        c.RequestRide("hassasn1", "helwan", "bsaten");

        //view all rides for the driver
        System.out.println("The requested rides for your favAreas");
        rides = d.listAllRides();
        for(int i = 0; i < rides.size(); i++)
        {
            System.out.println(rides.get(i));
        }

        //take the index and price of ride that driver want to set offer to it
        Scanner input = new Scanner(System.in);
        System.out.println("enter the index: ");
        int index = input.nextInt();
        System.out.println("enter the price: ");
        int price = input.nextInt();

        //driver suggest offer for chosen ride
        d.suggestRidePrice(rides.get(index), price);

        //viewing offers to the client
        offers = c.viewOffers();

        for(int i = 0; i < offers.size(); i++)
        {
            System.out.println(offers.get(i));
        }

        //take index of the offer that user want to accept
        System.out.println("enter the index of offer you want to accept: ");
        index = input.nextInt();
        c.acceptOffer(offers.get(index));
    }
}
