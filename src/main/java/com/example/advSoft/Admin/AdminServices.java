package com.example.advSoft.Admin;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.sql.SQLException;
import java.util.List;
@Service
public interface AdminServices {
    Admin admin = new Admin();
    public void verifyDriverRegistration(@RequestBody String person) throws SQLException, ClassNotFoundException;
    public List<String> listPendingDrivers() throws SQLException, ClassNotFoundException;
    public void suspendAccountClient(@PathVariable("username") String username) throws SQLException, ClassNotFoundException;
    public void suspendAccountDriver(@PathVariable("username") String username) throws SQLException, ClassNotFoundException;
    public void setDiscountArea(@RequestBody String areas) throws SQLException, ClassNotFoundException;

}
