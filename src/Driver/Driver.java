package Driver;

import User.User;
import User.Status;

import java.util.List;

public class Driver implements User
{
    private  String drivingLicense;
    private String nationalID;
    private List<String> favoriteAreas;

    public String getUsername()
    {
        return username;
    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getMobileNumber() {
        return null;
    }

    @Override
    public Status getStatus() {
        return null;
    }

    @Override
    public void setUsername(String username) {

    }

    @Override
    public void setEmail(String email) {

    }

    @Override
    public void setPassword(String password) {

    }

    @Override
    public void setStatus(Status status) {

    }

    @Override
    public void Login() {
        User.super.Login();
    }


    public void registerDriver(String username, String email, String password, String mobileNumber) {

    }


    public String getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public List<String> getFavoriteAreas() {
        return favoriteAreas;
    }

    public void setFavoriteAreas(List<String> favoriteAreas) {
        this.favoriteAreas = favoriteAreas;
    }
}
