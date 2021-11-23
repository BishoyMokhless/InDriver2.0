package connection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Client.Client;
import Offer.Offer;
public class OfferConnections implements DataBaseConnect {
    public static void setOffer(Offer offer) throws SQLException, ClassNotFoundException
    {
        DataBaseConnect.establish_connection();
        String query="INSERT INTO offer (clientName, driverName, price, source,destination)"+" VALUES(?, ?, ? , ?, ?) ";

        PreparedStatement preparedStmt = DataBaseConnect.establish_connection().prepareStatement(query);
        preparedStmt.setString(1,offer.getClient());
        preparedStmt.setString(2,offer.getDriver());
        preparedStmt.setFloat(3,offer.getPrice());
        preparedStmt.setString(4,offer.getSource());
        preparedStmt.setString(5,offer.getDestination());
        preparedStmt.executeUpdate();

    }
    //offer
    public static void updateOffer(Offer offer) throws SQLException, ClassNotFoundException
    {
        String query="update  offer set status=true   where driverName=? and clientName=? and price=? and source=? and destination=? ";
        PreparedStatement preparedStmt = DataBaseConnect.establish_connection().prepareStatement(query);
        preparedStmt.setString(1,offer.getDriver());
        preparedStmt.setString(2,offer.getClient());
        preparedStmt.setFloat(3,offer.getPrice());
        preparedStmt.setString(4,offer.getSource());
        preparedStmt.setString(5,offer.getDestination());
        preparedStmt.executeUpdate();
        DataBaseConnect.establish_connection().close();
    }

    public static List<Offer> listAllOffers(Client client) throws SQLException, ClassNotFoundException {
        List<Offer> offers = new ArrayList<Offer>();
        Connection c = DataBaseConnect.establish_connection();
        ResultSet re = null;
        System.out.println("client>>>>> :"+client.getUsername());
        String query = "SELECT * FROM offer Where clientName = '" + client.getUsername() + "' and status = false";
        Statement st = c.createStatement();
        re = st.executeQuery(query);
        while (re.next()) {
            Offer offer = new Offer();
            offer.setClient(re.getString("clientName"));
            offer.setDriver(re.getString("driverName"));
            offer.setPrice(re.getFloat("price"));
            offer.setSource(re.getString("source"));
            offer.setDestination(re.getString("destination"));
            offers.add(offer);
        }
        return offers;
    }
}
