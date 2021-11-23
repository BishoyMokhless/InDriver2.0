package connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RateConnections implements DataBaseConnect{

    public static void addRate(String clientName, String driverName,int rate) throws SQLException, ClassNotFoundException 
    {
        DataBaseConnect.establish_connection();
        String query="INSERT INTO rate (clientName, driverName, rate)"+" VALUES(?, ?, ? ) ";
        PreparedStatement preparedStmt = DataBaseConnect.establish_connection().prepareStatement(query);
        preparedStmt.setString(1, clientName);
        preparedStmt.setString(2, driverName);
        preparedStmt.setInt(3,rate);
        preparedStmt.executeUpdate();
    };

    public static List<Float> viewClientsRate(String clientName) throws SQLException, ClassNotFoundException {
        int queryResult= 0;
        List<Float> ratings = new ArrayList<Float>();
        String query = "";
        DataBaseConnect.establish_connection();
        Statement statement = DataBaseConnect.establish_connection().createStatement();
        query = "SELECT rate FROM rate Where clientName = " + clientName + ");";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            ratings.add(resultSet.getFloat("rate"));
        }
        statement.close();
        return ratings;
    };
    public static List<Float> viewDriverRate(String driverName) throws SQLException, ClassNotFoundException {
        List<Float> rates = new ArrayList<Float>();
        DataBaseConnect.establish_connection();
        String query="select rate from rate where driverName = ?  ";
        PreparedStatement preparedStmt = DataBaseConnect.establish_connection().prepareStatement(query);
        preparedStmt.setString(1, driverName);
        ResultSet rs = preparedStmt.executeQuery();
        while(rs.next())
        {
            rates.add(rs.getFloat("rate"));
        }
        return rates;
    };
}
