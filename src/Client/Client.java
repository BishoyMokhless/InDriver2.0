package Client;

import User.User;
import User.Status;
import connection.DataBaseConnect;
import User.UserModel;
import connection.UserConnections;

import java.sql.SQLException;
import java.sql.Statement;

public class Client extends UserModel implements User {

    @Override
    public String getUsername() throws SQLException, ClassNotFoundException {
        return username;
    }
    @Override
    public String getEmail() throws SQLException, ClassNotFoundException {
        return email;
    }
    @Override
    public String getPassword() throws SQLException, ClassNotFoundException {
        return password;
    }
    @Override
    public String getMobileNumber() throws SQLException, ClassNotFoundException {
        return mobileNumber;
    }
    @Override
    public Status getStatus() throws SQLException, ClassNotFoundException {
        return status;
    }
    @Override
    public void setUsername(String username) throws SQLException, ClassNotFoundException {
        UserConnections.setter("username", username, this);
        this.username = username;
    }

    @Override
    public void setEmail(String email) throws SQLException, ClassNotFoundException {
        UserConnections.setter("email", email, this);
        this.email = email;
    }

    @Override
    public void setPassword(String password) throws SQLException, ClassNotFoundException {
        UserConnections.setter("pass", password, this);
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

        DataBaseConnect.establish_connection();
        Statement statement = DataBaseConnect.establish_connection().createStatement();

        //push in database

        query = "INSERT INTO client(username,email,pass," +
                "mobileNumber) VALUES ("
                +"'"+username+"',"
                +"'"+email+"',"
                +"'"+password+"',"
                +"'"+mobileNumber+"')";

        queryResult = statement.executeUpdate(query);
        statement.close();

        this.username = username;
        this.email = email;
        this.password = password;
        this.mobileNumber = mobileNumber;
        if(Status.UnVerified.toString().equals(status))
            this.status = Status.UnVerified;
        else if(Status.Suspended.toString().equals(status))
            this.status = Status.Suspended;
        else
            this.status = Status.Verified;

    }


}