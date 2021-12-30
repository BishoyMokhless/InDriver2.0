package com.example.advSoft.Client;
import com.example.advSoft.User.UserModel;

import java.util.Date;

public class Client extends UserModel  {

    Date birthdate;
    public Client() {
    }
    public Client(Date birthdayDate) {
        this.birthdate = birthdayDate;
    }


    public Date getBirthdayDate() {
        return birthdate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdate = birthdayDate;
    }
}
