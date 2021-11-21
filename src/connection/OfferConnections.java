package connection;

import Offer.OfferModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OfferConnections implements DataBaseConnect {
    public static void setOffer(OfferModel offer) throws SQLException, ClassNotFoundException
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
    public static void updateOffer(OfferModel offer) throws SQLException, ClassNotFoundException
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
}
