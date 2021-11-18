package connection;

import Ride.Ride;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RideConnections implements DataBaseConnect{
    public static void RequestRide(String clientName, String source, String destination) throws SQLException, ClassNotFoundException
    {
        DataBaseConnect.establish_connection();
        String query="INSERT INTO requestedRides (clientName, source, destination)"+" VALUES(?, ?, ?) ";
        PreparedStatement preparedStmt = DataBaseConnect.establish_connection().prepareStatement(query);
        preparedStmt.setString(1,clientName);
        preparedStmt.setString(2, source);
        preparedStmt.setString(3,destination);
        preparedStmt.executeUpdate();
    }
    public static List<Ride> listAllRides(List<String>areas) throws SQLException, ClassNotFoundException
    {
        List<Ride> ridesOfFavAreas = new ArrayList<Ride>();
        Ride ride = new Ride();
        DataBaseConnect.establish_connection();
        for (int i =0; i<areas.size(); i++) {
            String query = "SELECT * FROM RequestedRides Where source = "+areas.get(i);
            Statement st = DataBaseConnect.establish_connection().createStatement();
            ResultSet re = st.executeQuery(query);
            while (re.next()) {
                ride.setClient(re.getString("clientName"));
                ride.setSource(re.getString("source"));
                ride.setDestination(re.getString("destination"));
                ridesOfFavAreas.add(ride);
            }
        }
        return ridesOfFavAreas;
    }
}
