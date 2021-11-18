package Client;

import User.User;
import User.Status;
import connection.DataBaseConnect;
import User.UserModel;

import java.sql.SQLException;
import java.sql.Statement;

public class Client extends UserModel implements User {


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

    }


}