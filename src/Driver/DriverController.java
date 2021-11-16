package Driver;

import connection.Connect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DriverController implements DriverServices {

    public String listAllRides(String username) throws SQLException, ClassNotFoundException
    {
        Scanner scanner = new Scanner(System.in);
        int queryResult= 0, i = 0;
        String result = "";
        Connect C1 = new Connect();
        C1.establish_connection();
        Statement statement = C1.establish_connection().createStatement();
        ResultSet rs = statement.executeQuery("select * from rides Where driver = '" + username + "'");
        while(rs.next())
        {
            result += "Ride no. " + i;
            result += "driver: " + rs.getString("driver") + "\n";
            result += "client: " + rs.getString("client") + "\n";
            result += "driver: " + rs.getString("price") + "\n";
            result += "source: " + rs.getString("source") + "\n";
            result += "destination: " + rs.getString("destination") + "\n";
            i++;
        }
        return result;
    }

    @Override
    public float suggestRidePrice() {
        return 0;
    }

    @Override
    public String FavAreas() {
        return null;
    }

    @Override
    public String NotifyUser() {
        return null;
    }
}
