package Driver;


import Offer.Offer;

public interface DriverServices  {
    Driver driver = new Driver();
    Offer offer = null;

    public String listAllRides();
    public float suggestRidePrice();
    public String FavAreas();
    public String NotifyUser();


}
