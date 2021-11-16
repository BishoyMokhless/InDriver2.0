package User;

import Ratings.Ratings;
import connection.Connect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public interface User {
     String username = null;
     String email = null;
     String password = null;
     String mobileNumber = null;
     Status status = null;
     List<Ratings> ratings = null;
     public String getUsername() throws SQLException, ClassNotFoundException;
     public String getEmail() throws SQLException, ClassNotFoundException;
     public String getPassword() throws SQLException, ClassNotFoundException;
     public String getMobileNumber() throws SQLException, ClassNotFoundException;
     public String getStatus() throws SQLException, ClassNotFoundException;

     public void setUsername(String username);
     public void setEmail(String email);
     public void setPassword(String password);
     public void setStatus(Status status);

     public default void Login(String username, String password) throws SQLException, ClassNotFoundException {
          Scanner scanner = new Scanner(System.in);
          int queryResult= 0;
          String query = "";
          Connect C1 = new Connect();
          C1.establish_connection();
          Statement statement = C1.establish_connection().createStatement();
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
