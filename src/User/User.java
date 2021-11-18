package User;

import connection.DataBaseConnect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public interface User {


     public String getUsername() throws SQLException, ClassNotFoundException;
     public String getEmail() throws SQLException, ClassNotFoundException;
     public String getPassword() throws SQLException, ClassNotFoundException;
     public String getMobileNumber() throws SQLException, ClassNotFoundException;
     public Status getStatus() throws SQLException, ClassNotFoundException;

     public void setUsername(String username) throws SQLException, ClassNotFoundException;
     public void setEmail(String email) throws SQLException, ClassNotFoundException;
     public void setPassword(String password) throws SQLException, ClassNotFoundException;
     public void setStatus(Status status) throws SQLException, ClassNotFoundException;

     public default void Login(String username, String password) throws SQLException, ClassNotFoundException {
          Scanner scanner = new Scanner(System.in);
          int queryResult= 0;
          String query = "";
           DataBaseConnect.establish_connection();
          Statement statement = DataBaseConnect.establish_connection().createStatement();
          ResultSet rs = statement.executeQuery("select * from driver Where username = '" + username + "and pass = '" + password + "'");
          if(rs.next())
               System.out.println("Logged in successfully");
          else
          {
               rs = statement.executeQuery("select * from client Where username = '" + username + "' and pass = '" + password + "'");
               if(rs.next())
                    System.out.println("Logged in successfully");
               else
                    System.out.println("username or password is incorrect");
          }

          statement.close();
     }
 }
