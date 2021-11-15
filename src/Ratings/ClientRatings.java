package Ratings;
import Driver.Driver;
import Client.Client;

public class ClientRatings implements Ratings {

   /*public void addRating(int rate, Driver driver, Client client)
    {
        boolean found = false;
        for(int i = 0; i < drivers.size(); i++)
        {
            if(drivers.get(i).getUsername().equals(driver.getUsername()) && clients.get(i).getUsername().equals(client.getUsername()))
            {
                found = true;
                rates.set(i, rate);
            }
        }
        if(!found)
        {
            clients.add(client);
            drivers.add(driver);
            rates.add(rate);
        }
    }*/
    public void addRating(int rate, Driver driver, Client client)
    {
        clients.add(client);
        drivers.add(driver);
        rates.add(rate);
    }

    public double viewAvgRating(Driver driver)
    {
        double sum = 0, num = 0;
        for(int i = 0; i < rates.size(); i++)
        {
            if(drivers.get(i).getUsername().equals(driver.getUsername()))
            {
                sum += rates.get(i);
                num++;
            }
        }
        return sum / num;
    }
}
