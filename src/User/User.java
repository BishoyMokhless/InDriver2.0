package User;

import Ratings.Ratings;

import java.util.List;

public interface User {
     String username = null;
     String email = null;
     String password = null;
     String mobileNumber = null;
     Status status = null;
     List<Ratings> ratings = null;
     public String getUsername();
     public String getEmail();
     public String getPassword();
     public String getMobileNumber();
     public Status getStatus();

     public void setUsername(String username);
     public void setEmail(String email);
     public void setPassword(String password);
     public void setStatus(Status status);

     public default void Login(String username, String password)
     {
          Scanner scanner = new Scanner(System.in);
          int queryResult= 0;
          String query = "";
          Connect C1 = new Connect();
          C1.establish_connection();
          Statement statement = C1.establish_connection().createStatement();
          ResultSet rs = statement.executeQuery("select * from driver Where username = " + username + "and pass = " + password);
          if(rs.next())
               System.out.println("Logged in successfully");
          else
          {
               rs = statement.executeQuery("select * from client Where username = " + username + "and pass = " + password);
               if(rs.next())
                    System.out.println("Logged in successfully");
               else
                    System.out.println("username or password is incorrect");

          }
          statement.close();
     }
 }
