package Client;

import Ratings.Ratings;
import User.User;
import User.Status;
import connection.Connect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Client implements User {


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
    public void Login() {
        User.super.Login();
    }

    @Override
    public void setStatus(Status status) {

    }


    public void registerClient(String username,String email,String password,String mobileNumber) throws SQLException, ClassNotFoundException {
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


        //push in database

        query = "INSERT INTO client(username,email,pass," +
                "mobileNumber) VALUES ("
                +"'"+username+"',"
                +"'"+email+"',"
                +"'"+password+"',"
                +"'"+mobileNumber+"')";

        queryResult = statement.executeUpdate(query);

        statement.close();

    }


}