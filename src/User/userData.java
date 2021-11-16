package User;

import Ratings.Ratings;

import java.util.List;

public class userData {
    public String username;
    public String email;
    public String password;
    public String mobileNumber;
    public Status status;
    public List<Ratings> ratings;

    public userData()
    {
        username = "";
        email = "";
        password = "";
        mobileNumber = "";
        status = null;
        ratings = null;
    }
}
