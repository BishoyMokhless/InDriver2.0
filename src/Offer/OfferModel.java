package Offer;

public class OfferModel {
    float price;
    String source;
    String destination;
    String client;
    String driver;

    public OfferModel(String client, float price, String source, String destination, String driver) {
        this.client = client;
        this.price = price;
        this.source = source;
        this.destination = destination;
        this.driver = driver;
    }

    public OfferModel() {
        this.price = 0;
        this.source = "";
        this.destination = "";
        this.client = "";
        this.driver = "";
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
}
