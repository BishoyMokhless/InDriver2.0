package connection;

import Ride.Ride;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RideConnections implements DataBaseConnect{
    public static void RequestRide(String clientName, String source, String destination) throws SQLException, ClassNotFoundException
    {
        Connection c = DataBaseConnect.establish_connection();
        String query="INSERT INTO requestedRides (clientName, source, destination)"+" VALUES(?, ?, ?) ";
        PreparedStatement preparedStmt = c.prepareStatement(query);
        preparedStmt.setString(1,clientName);
        preparedStmt.setString(2, source);
        preparedStmt.setString(3,destination);
        preparedStmt.executeUpdate();
    }
    public static List<Ride> listAllRides(List<String>areas) throws SQLException, ClassNotFoundException {
        List<Ride> ridesOfFavAreas = new ArrayList<Ride>();
        System.out.println("areas " + areas.size());
        Connection c = DataBaseConnect.establish_connection();
        for (int i = 0; i < areas.size(); i++) {
            ResultSet re = null;
            System.out.println("fo2   :   " + areas.get(i));
            String query = "SELECT * FROM requestedRides Where source = '" + areas.get(i) + "' and accepted = 'false'";
            Statement st = c.createStatement();
            re = st.executeQuery(query);
            while (re.next()) {
                Ride ride = new Ride();
                ride.setClient(re.getString("clientName"));
                ride.setSource(re.getString("source"));
                ride.setDestination(re.getString("destination"));
                ridesOfFavAreas.add(ride);
            }
        }
        return ridesOfFavAreas;
    }
}
