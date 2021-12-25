package com.example.advSoft.User;

//import connection.DataBaseConnect;


public class UserModel {

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String username;
    public String email;
    public String password;
    public String mobileNumber;
    public String status;

    public UserModel()
    {
        username = "";
        email = "";
        password = "";
        mobileNumber = "";
        status = "";
     }


}
