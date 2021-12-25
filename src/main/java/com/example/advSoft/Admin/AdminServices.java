package com.example.advSoft.Admin;

import com.example.advSoft.Driver.Driver;
import com.example.advSoft.User.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLException;
import java.util.List;

public interface AdminServices {

    public void verifyDriverRegistration(@RequestBody String person) throws SQLException, ClassNotFoundException;
    public String listPendingDrivers() throws SQLException, ClassNotFoundException;
    public void suspendAccountClient(@PathVariable("username") String username) throws SQLException, ClassNotFoundException;
    public void suspendAccountDriver(@PathVariable("username") String username) throws SQLException, ClassNotFoundException;

}
