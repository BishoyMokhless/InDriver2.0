package Driver;
import User.User;
import User.Status;
import connection.Connect;
import Ratings.Ratings;
import User.User;
import User.Status;
import User.userData;
import connection.Connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class Driver extends userData implements User
{
    private String drivingLicense;
    private String nationalID;
    private String favoriteAreas;

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
        username = getter().getString("username");
        return username;
    }

    public String getEmail() throws SQLException, ClassNotFoundException {
        email = getter().getString("email");
        return email;
    }

    public String getPassword() throws SQLException, ClassNotFoundException {
        password = getter().getString("pass");
        return password;
    }

    public String getMobileNumber() throws SQLException, ClassNotFoundException {
        mobileNumber = getter().getString("mobileNumber");
        return mobileNumber;
    }

    public Status getStatus() throws SQLException, ClassNotFoundException {
        String data = getter().getString("status");
        if(Status.UnVerified.toString().equals(data))
            status = Status.Verified;
        else if(Status.Suspended.toString().equals(data))
            status = Status.Verified;
        else
            status = Status.Verified;
        return status;
    }

    public String getDrivingLicense() throws SQLException, ClassNotFoundException {
        drivingLicense = getter().getString("drive_license");
        return drivingLicense;
    }

    public String getNationalID() throws SQLException, ClassNotFoundException {
       nationalID = getter().getString("nationalID");
        return nationalID;
    }

    public String getFavoriteAreas() throws SQLException, ClassNotFoundException {
        favoriteAreas = getter().getString("favarea");
        return favoriteAreas;
    }

    public void setUsername(String username) throws SQLException, ClassNotFoundException {
        setter("username", username);
        this.username = username;
    }

    @Override
    public void setEmail(String email) throws SQLException, ClassNotFoundException {
        setter("email", email);
        this.email = email;
    }

    @Override
    public void setPassword(String password) throws SQLException, ClassNotFoundException {
        setter("pass", password);
        this.password = password;
    }

    @Override
    public void setStatus(Status status) throws SQLException, ClassNotFoundException {
        String temp = status.toString();
        setter("status", temp);
        this.status = status;
    }

    public void setDrivingLicense(String drivingLicense) throws SQLException, ClassNotFoundException {
        setter("drive_license", drivingLicense);
        this.drivingLicense = drivingLicense;
    }

    public void setNationalID(String nationalID) throws SQLException, ClassNotFoundException {
        setter("nationalID", nationalID);
        this.nationalID = nationalID;
    }

    public void setFavoriteAreas(String favoriteAreas) throws SQLException, ClassNotFoundException {
        setter("favarea", favoriteAreas);
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
