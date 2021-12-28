package com.example.advSoft.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.example.advSoft.connection.DataBaseConnect;
import org.springframework.web.bind.annotation.RequestBody;

public interface User {

    public String getAll() throws ClassNotFoundException, SQLException;
    public void register( @RequestBody String person) throws SQLException, ClassNotFoundException, SQLException;
    public String  login(@RequestBody String person)throws SQLException, ClassNotFoundException, SQLException;
 }
