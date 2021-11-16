package Offer;

public interface Offer  {

    String price = null;
    String source = null;
    String destination = null;
    public String sendOffer(int price,String source,String destination);
    public String receiveOffer(String price,String source,String destination);
}
