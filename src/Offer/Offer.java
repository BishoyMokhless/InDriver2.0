package Offer;

public class Offer {
    float price;
    String source;
    String destination;
    String client;
    String driver;
    boolean accepted;


    public Offer() {
        this.price = 0;
        this.source = "";
        this.destination = "";
        this.client = "";
        this.driver = "";
        this.accepted = false;

    }

    public Offer(float price, String source, String destination, String client, String driver, boolean accepted) {
        this.price = price;
        this.source = source;
        this.destination = destination;
        this.client = client;
        this.driver = driver;
        this.accepted = accepted;
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

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    @Override
    public String toString() {
        return "OfferModel{" +
                "price=" + price +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", client='" + client + '\'' +
                ", driver='" + driver + '\'' +
                '}';
    }
}
