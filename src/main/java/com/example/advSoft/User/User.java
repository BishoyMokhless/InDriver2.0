package com.example.advSoft.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.example.advSoft.connection.DataBaseConnect;
import org.springframework.web.bind.annotation.RequestBody;

public interface User {


    public String getUsername() throws SQLException, ClassNotFoundException;
    public String getEmail() throws SQLException, ClassNotFoundException;
    public String getPassword() throws SQLException, ClassNotFoundException;
    public String getMobileNumber() throws SQLException, ClassNotFoundException;
    public String getStatus() throws SQLException, ClassNotFoundException;
    public void setUsername(String username) throws SQLException, ClassNotFoundException;
    public void setEmail(String email) throws SQLException, ClassNotFoundException;
    public void setPassword(String password) throws SQLException, ClassNotFoundException;
    public void setStatus(String status) throws SQLException, ClassNotFoundException;


    public String getAll() throws ClassNotFoundException, SQLException;
    public void register( @RequestBody String person) throws SQLException, ClassNotFoundException, SQLException;
    public String  login(@RequestBody String person)throws SQLException, ClassNotFoundException, SQLException;


 }
