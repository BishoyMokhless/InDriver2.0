package Ratings;

import Client.Client;
public class DriverRatings implements Ratings
{
    public double viewClientRatings(Client client) {
        double sum = 0, num = 0;
        for(int i = 0; i < rates.size(); i++)
        {
            if(clients.get(i).getUsername().equals(client.getUsername()))
            {
                sum += rates.get(i);
                num++;
            }
        }
        return sum / num;
    }
}
