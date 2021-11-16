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

     public default void Login(){
          System.out.println("Welcome");
     }
 }
