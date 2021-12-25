package com.example.advSoft.Admin;

import com.example.advSoft.Client.Client;
import com.example.advSoft.Driver.Driver;
import com.example.advSoft.User.User;
import com.example.advSoft.connection.DataBaseConnect;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.sql.*;
import java.util.List;

import static com.example.advSoft.connection.DataBaseConnect.establish_connection;

@RequestMapping("/api/admin")
@RestController
public class AdminController  extends Admin implements AdminServices {




    @Autowired



    @RequestMapping("listPendingDrivers")
    @Override
    @GetMapping
    public String listPendingDrivers() throws SQLException, ClassNotFoundException {
        Connection c1 = establish_connection();

        JSONArray arr = new JSONArray();

        Statement statement = establish_connection().createStatement();
        ResultSet rs = statement.executeQuery("select *  from driver where  status ='UnVerified' ");
        while(rs.next())
        {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("username",rs.getString("username"));
            jsonObject.put("email",rs.getString("email"));
            jsonObject.put("mobileNumber",rs.getString("mobileNumber"));
            jsonObject.put("nationalID",rs.getString("nationalID"));
            jsonObject.put("drive_license",rs.getString("drive_license"));
            jsonObject.put("status",rs.getString("status"));
            arr.put(jsonObject);
        }

        return arr.toString();


    }



    @RequestMapping("verifyDriver")
    @Override
    @PostMapping
    public void verifyDriverRegistration(String person) throws SQLException, ClassNotFoundException {

        JSONObject jsonObject = new JSONObject(person);
        Connection c1 = establish_connection();
        String query = " update driver set status='Verified' where  username='"+(String) jsonObject.get("username")+"'";
        PreparedStatement preparedStmt = c1.prepareStatement(query);
        preparedStmt.executeUpdate();
        establish_connection().close();
        System.out.println("one driver Verified");

    }


    @RequestMapping("suspendAccountDriver/{username}")
    @Override
    @PostMapping
    public void suspendAccountDriver( @PathVariable("username") String username) throws SQLException, ClassNotFoundException {

        Connection c1 = establish_connection();
        String query = " update driver set status='Suspended' where  username='"+username+"'";
        PreparedStatement preparedStmt = c1.prepareStatement(query);
        preparedStmt.executeUpdate();
        establish_connection().close();
        System.out.println("one driver suspended");
        System.out.println(username);
    }

    @RequestMapping("suspendAccountClient/{username}")
    @Override
    @PostMapping
    public void suspendAccountClient( @PathVariable("username") String username) throws SQLException, ClassNotFoundException {

        Connection c1 = establish_connection();
        String query = " update client set status='Suspended' where  username='"+username+"'";
        PreparedStatement preparedStmt = c1.prepareStatement(query);
        preparedStmt.executeUpdate();
        establish_connection().close();
        System.out.println("one Client suspended");


    }
}
