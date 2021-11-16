package Client;

import Offer.Offer;

import java.util.Scanner;

public class ClientController implements  ClientServices {


    @Override
    public void RequestRide(String Destination, String Source, int price) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the source: ");
        Source = scanner.nextLine();
        System.out.print("Enter your destination: ");
        Destination = scanner.nextLine();
        System.out.print("Enter your offer : ");
        price = scanner.nextInt();

    }

     public static void main(String[] args) {
        ClientController client = new ClientController();
        client.RequestRide("a","a", 5);
    }

}
