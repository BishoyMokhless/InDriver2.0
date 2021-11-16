package Offer;

public class OfferController implements Offer {

    @Override
    public String sendOffer(int price, String source, String destination) {
        return source;

    }

    @Override
    public String receiveOffer(String price, String source, String destination) {
        return null;
    }
}
