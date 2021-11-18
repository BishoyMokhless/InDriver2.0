package Driver;
import Ride.Ride;
import User.User;
import User.Status;
import connection.Connect;
import User.UserModel;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Driver extends UserModel implements User
{
    private String drivingLicense;
    private String nationalID;
    private List<String> favoriteAreas;
    private List<Ride> allRides;
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

    public List<String> getFavoriteAreas() throws SQLException, ClassNotFoundException {
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

    public void setFavoriteAreas(String area) throws SQLException, ClassNotFoundException {
        Connect.setFavorite(username, area);
        favoriteAreas.add(area);
    }

    public void registerDriver(String username, String email, String password, String mobileNumber,String drivingLicense, String nationalID, Status status, List<String> areas) throws SQLException, ClassNotFoundException {
        int queryResult= 0;
        String query = "";
        Connect.establish_connection();
        Statement statement = Connect.establish_connection().createStatement();
        favoriteAreas = areas;
        for(int i = 0; i < areas.size(); i++)
        {
            Connect.setFavorite(username, areas.get(i));
        }
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

    public List<Ride> getAllRides() {
        return allRides;
    }

    public void setAllRides(List<Ride> allRides) {
        this.allRides = allRides;
    }
}
