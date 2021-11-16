package Driver;

import User.User;
import User.Status;
import connection.Connect;
import Ratings.Ratings;
import User.User;
import User.Status;
import connection.Connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class Driver implements User
{
    private  String drivingLicense;
    private String nationalID;
    private List<String> favoriteAreas;

    private ResultSet getter() throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int queryResult= 0;
        String query = "";
        Connect C1 = new Connect();
        C1.establish_connection();
        Statement statement = C1.establish_connection().createStatement();
        ResultSet rs = statement.executeQuery("select * from driver Where username = '" + username + "'");
        rs.next();
        return rs;
    }
    private void setter(String column , String rowData) throws SQLException, ClassNotFoundException
    {
        Scanner scanner = new Scanner(System.in);
        int queryResult= 0;
        Connect C1 = new Connect();
        C1.establish_connection();
        String query = "update driver set " + column + " = ?";
        PreparedStatement preparedStmt = C1.establish_connection().prepareStatement(query);
        preparedStmt.setString(1, rowData);
        preparedStmt.executeUpdate();
        C1.establish_connection().close();
    }

    public String getUsername() throws SQLException, ClassNotFoundException {

        String data = getter().getString("username");
        return data;
    }

    public String getEmail() throws SQLException, ClassNotFoundException {
        String data = getter().getString("email");
        return data;
    }

    public String getPassword() throws SQLException, ClassNotFoundException {
        String data = getter().getString("pass");
        return data;
    }

    public String getMobileNumber() throws SQLException, ClassNotFoundException {
        String data = getter().getString("mobileNumber");
        return data;
    }

    public Status getStatus() throws SQLException, ClassNotFoundException {
        String data = getter().getString("status");

        if(Status.UnVerified.toString().equals(data))
            status.equals(Status.Verified);
        else if(Status.Suspended.toString().equals(data))
            status.equals(Status.Verified);
        else
            status.equals(Status.Verified);
        return status;
    }

    public String getDrivingLicense() throws SQLException, ClassNotFoundException {
        String data = getter().getString("drive_license");
        return data;
    }

    public String getNationalID() throws SQLException, ClassNotFoundException {
        String data = getter().getString("nationalID");
        return data;
    }


    public void setUsername(String username) throws SQLException, ClassNotFoundException {
        setter("username", username);
    }

    @Override
    public void setEmail(String email) throws SQLException, ClassNotFoundException {
        setter("email", email);
    }

    @Override
    public void setPassword(String password) throws SQLException, ClassNotFoundException {
        setter("pass", password);
    }

    @Override
    public void setStatus(Status status) throws SQLException, ClassNotFoundException {
        String temp = status.toString();
        setter("status", temp);
    }

    public void setDrivingLicense(String drivingLicense) throws SQLException, ClassNotFoundException {
        setter("drive_license", drivingLicense);
    }


    public void setNationalID(String nationalID) throws SQLException, ClassNotFoundException {

    }

    public List<String> getFavoriteAreas() {
        return favoriteAreas;
    }

    public void setFavoriteAreas(List<String> favoriteAreas) {
        this.favoriteAreas = favoriteAreas;
    }

    public void registerDriver(String username, String email, String password, String mobileNumber,String drivingLicense, String nationalID ) throws SQLException, ClassNotFoundException {

        int queryResult= 0;
        String query = "";
        Connect C1 = new Connect();
        C1.establish_connection();
        Statement statement = C1.establish_connection().createStatement();

        //push in database

        query = "INSERT INTO driver(username,email,pass,nationalID,drive_license," +
                "mobileNumber) VALUES ("
                +"'"+username+"',"
                +"'"+email+"',"
                +"'"+password+"',"
                +"'"+mobileNumber+"')";

        queryResult = statement.executeUpdate(query);

        statement.close();

    }
}
