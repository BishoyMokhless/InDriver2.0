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

    public String getUsername() throws SQLException, ClassNotFoundException {
        return username;
    }

    public String getEmail() throws SQLException, ClassNotFoundException {
        return email;
    }

    public String getPassword() throws SQLException, ClassNotFoundException {
        return password;
    }

    public String getMobileNumber() throws SQLException, ClassNotFoundException {
        return mobileNumber;
    }

    public Status getStatus() throws SQLException, ClassNotFoundException {
        return status;
    }

    public String getDrivingLicense() throws SQLException, ClassNotFoundException {
        return drivingLicense;
    }

    public String getNationalID() throws SQLException, ClassNotFoundException {
        return nationalID;
    }

    public String getFavoriteAreas() throws SQLException, ClassNotFoundException {
        return favoriteAreas;
    }

    public void setUsername(String username) throws SQLException, ClassNotFoundException {
        Connect.setter("username", username, this);
        this.username = username;
    }

    @Override
    public void setEmail(String email) throws SQLException, ClassNotFoundException {
        Connect.setter("email", email, this);
        this.email = email;
    }

    @Override
    public void setPassword(String password) throws SQLException, ClassNotFoundException {
        Connect.setter("pass", password, this);
        this.password = password;
    }

    @Override
    public void setStatus(Status status) throws SQLException, ClassNotFoundException {
        String temp = status.toString();
        Connect.setter("status", temp,this);
        this.status = status;
    }

    public void setDrivingLicense(String drivingLicense) throws SQLException, ClassNotFoundException {
        Connect.setter("drive_license", drivingLicense, this);
        this.drivingLicense = drivingLicense;
    }

    public void setNationalID(String nationalID) throws SQLException, ClassNotFoundException {
        Connect.setter("nationalID", nationalID, this);
        this.nationalID = nationalID;
    }

    public void setFavoriteAreas(String favoriteAreas) throws SQLException, ClassNotFoundException {
        Connect.setter("favarea", favoriteAreas, this);
        this.favoriteAreas = favoriteAreas;
    }
    public void registerDriver(String username, String email, String password, String mobileNumber,String drivingLicense, String nationalID, Status status ) throws SQLException, ClassNotFoundException {
        int queryResult= 0;
        String query = "";
        Connect.establish_connection();
        Statement statement = Connect.establish_connection().createStatement();

        //push in database
        query = "INSERT INTO driver(username,email,pass,nationalID,drive_license," +
                "mobileNumber,status) VALUES ("
                +"'"+username+"',"
                +"'"+email+"',"
                +"'"+password+"',"
                +"'"+nationalID+"',"
                +"'"+drivingLicense+"',"
                +"'"+mobileNumber+"',"
                +"'"+status+"')";
        queryResult = statement.executeUpdate(query);
        statement.close();
        this.username = username;
        this.email = email;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.drivingLicense = drivingLicense;
        this.nationalID = nationalID;
        if(Status.UnVerified.toString().equals(status))
            this.status = Status.UnVerified;
        else if(Status.Suspended.toString().equals(status))
            this.status = Status.Suspended;
        else
            this.status = Status.Verified;
    }
}
