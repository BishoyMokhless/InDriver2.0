package com.example.advSoft.Driver;

import com.example.advSoft.Client.Client;
import com.example.advSoft.Client.ClientService;
import com.example.advSoft.User.User;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static com.example.advSoft.connection.DataBaseConnect.establish_connection;

@RequestMapping("/api/driver")
@RestController
public class DriverController extends Driver implements DriverService , User {

    @Autowired



    @Override
    @GetMapping
    public String getAll() throws ClassNotFoundException, SQLException {
        Connection c1 = establish_connection();

        JSONArray arr = new JSONArray();

        Statement statement = establish_connection().createStatement();
        ResultSet rs = statement.executeQuery("select *  from driver ");
        while(rs.next())
        {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("username",rs.getString("username"));
            jsonObject.put("email",rs.getString("email"));
            jsonObject.put("pass",rs.getString("pass"));
            jsonObject.put("mobileNumber",rs.getString("mobileNumber"));
            jsonObject.put("nationalID",rs.getString("nationalID"));
            jsonObject.put("drive_license",rs.getString("drive_license"));
            jsonObject.put("status",rs.getString("status"));
            arr.put(jsonObject);
        }

        return arr.toString();

    }

    @PostMapping
    @Override
    public void register( @RequestBody String person) throws SQLException, ClassNotFoundException, SQLException {

        JSONObject jsonObject = new JSONObject(person);
        Connection c1 = establish_connection();
        String query = " insert into driver (username,email,pass,mobileNumber,nationalID,drive_license,status) values (?,?,?,?,?,?,?)";
        PreparedStatement preparedStmt = c1.prepareStatement(query);
        preparedStmt.setString (1, (String) jsonObject.get("username"));
        preparedStmt.setString (2, (String) jsonObject.get("email"));
        preparedStmt.setString (3, (String) jsonObject.get("pass"));
        preparedStmt.setString (4, (String) jsonObject.get("mobileNumber"));
        preparedStmt.setString (5, (String) jsonObject.get("nationalID"));
        preparedStmt.setString (6, (String) jsonObject.get("drive_license"));
        preparedStmt.setString (7, "UnVerified");
        preparedStmt.executeUpdate();
        establish_connection().close();
        System.out.println("onr driver created");
    }


    @RequestMapping("login")
    @Override
    @PostMapping
    public String login(String person) throws SQLException, ClassNotFoundException, SQLException {
        Connection c1 = establish_connection();
        JSONArray arr = new JSONArray();

        JSONObject jsonObject = new JSONObject(person);

        Statement statement = establish_connection().createStatement();
        ResultSet rs = statement.executeQuery("select *  from driver where username='"+ (String) jsonObject.get("username") +"' and pass='"+ (String) jsonObject.get("pass") + "'" );
        while(rs.next())
        {
            System.out.println("in login");

            JSONObject newjsonObject = new JSONObject();
            newjsonObject.put("username",rs.getString("username"));
            newjsonObject.put("email",rs.getString("email"));
            newjsonObject.put("mobileNumber",rs.getString("mobileNumber"));
            newjsonObject.put("nationalID",rs.getString("nationalID"));
            newjsonObject.put("drive_license",rs.getString("drive_license"));
            newjsonObject.put("status",rs.getString("status"));
            arr.put(newjsonObject);
        }

        return arr.toString();
    }


}
