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
     public default void Login(){
          System.out.println("Welcome");
     }
 }
