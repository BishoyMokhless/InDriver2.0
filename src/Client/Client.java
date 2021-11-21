package Client;

import User.User;
import User.Status;
import connection.DataBaseConnect;
import User.UserModel;
import connection.UserConnections;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Client extends UserModel implements User {


    public String getUsername()
    {
        return username;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getMobileNumber() {
        return mobileNumber;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public void setUsername(String username) throws SQLException, ClassNotFoundException {
        UserConnections.setter("username", username, this);
        this.username = username;

    }

    @Override
    public void setEmail(String email) throws SQLException, ClassNotFoundException {
        UserConnections.setter("email", username, this);
        this.email = email;
    }

    @Override
    public void setPassword(String password) throws SQLException, ClassNotFoundException {
        UserConnections.setter("pass", username, this);
        this.password = password;
    }

    @Override
    public void setStatus(Status status) throws SQLException, ClassNotFoundException {
        String temp = status.toString();
        UserConnections.setter("status", temp,this);
        this.status = status;

    }


    public void registerClient(String username,String email,String password,String mobileNumber) throws SQLException, ClassNotFoundException {
        int queryResult= 0;
        String query = "";
        Connection db = DataBaseConnect.establish_connection();
        Statement statement = db.createStatement();

        //push in database

        query = "INSERT INTO client(username,email,pass," +
                "mobileNumber, status) VALUES ("
                +"'"+username+"',"
                +"'"+email+"',"
                +"'"+password+"',"
                +"'"+mobileNumber+"',"
                +"'Unverified')";

        queryResult = statement.executeUpdate(query);

        statement.close();

    }


}