package User;

public interface User {
     String username = null;
     String email = null;
     String password = null;
     String mobileNumber = null;
     Status status = null;
     public void Login();
     public void Register(String username,String email,String password,String mobileNumber);
}
