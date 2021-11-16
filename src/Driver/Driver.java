package Driver;

import User.User;
import User.Status;
import connection.Connect;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

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


    public void registerDriver(String username, String email, String password, String mobileNumber,String drivingLicense, String nationalID ) throws SQLException, ClassNotFoundException {

        Scanner scanner = new Scanner(System.in);
        int queryResult= 0;
        String query = "";
        Connect C1 = new Connect();
        C1.establish_connection();
        Statement statement = C1.establish_connection().createStatement();






        System.out.print("Enter the userName: ");
        username = scanner.nextLine();
        System.out.print("Enter the Email: ");
        email = scanner.nextLine();
        System.out.print("Enter the Password: ");
        password = scanner.nextLine();
        System.out.print("Enter the mobileNumber: ");
        mobileNumber = scanner.nextLine();
        System.out.print("Enter the drivingLicense: ");
        drivingLicense = scanner.nextLine();
        System.out.print("Enter the nationalID: ");
        nationalID = scanner.nextLine();

        //push in database

        query = "INSERT INTO client(username,email,pass,nationalID,drive_license," +
                "mobileNumber) VALUES ("
                +"'"+username+"',"
                +"'"+email+"',"
                +"'"+password+"',"
                +"'"+mobileNumber+"')";

        queryResult = statement.executeUpdate(query);

        statement.close();

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
