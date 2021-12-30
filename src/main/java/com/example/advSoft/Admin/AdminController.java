package com.example.advSoft.Admin;

import com.example.advSoft.connection.AdminDatabaseConnect;
import com.example.advSoft.connection.ClientDatabaseConnect;
import com.example.advSoft.connection.DataBaseConnect;
import com.example.advSoft.connection.DriverDatabaseConnect;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@RequestMapping("/api/admin")
@RestController
public class AdminController implements AdminServices{
    DataBaseConnect dbAdmin = new AdminDatabaseConnect();
    DataBaseConnect dbDriver = new DriverDatabaseConnect();
    DataBaseConnect dbClient = new ClientDatabaseConnect();
    @Autowired
    AdminController(){

    }

    @RequestMapping("listPendingDrivers")
    @Override
    @GetMapping
    public List<String> listPendingDrivers() throws SQLException, ClassNotFoundException {
        JSONArray allDrivers = dbDriver.listAll();
        JSONObject driver;
        List<String> allPendingDrivers = new ArrayList<>();
        for (int i=0;i<allDrivers.length();i++)
        {
            driver = allDrivers.getJSONObject(i);
            if (driver.get("status").equals("Unverified"))
            {
                allPendingDrivers.add(driver.toString());
            }
        }
        return allPendingDrivers;
    }

    @RequestMapping("verifyDriver")
    @Override
    @PostMapping
    public void verifyDriverRegistration(@RequestBody String person) throws SQLException, ClassNotFoundException {
        JSONObject jsonObject = new JSONObject(person);
        dbDriver.update(jsonObject);
        System.out.println("one driver Verified");
    }

    @RequestMapping("suspendAccountDriver/{username}")
    @Override
    @PostMapping
    public void suspendAccountDriver( @PathVariable("username") String username) throws SQLException, ClassNotFoundException {
//        JSONObject jsonObject = new JSONObject(username);
//        dbDriver.update(jsonObject);
//        System.out.println("one driver suspended");
//        System.out.println(username);
    }

    @RequestMapping("suspendAccountClient/{username}")
    @Override
    @PostMapping
    public void suspendAccountClient( @PathVariable("username") String username) throws SQLException, ClassNotFoundException {
//        Connection c1 = establish_connection();
//        String query = " update client set status='Suspended' where  username='"+username+"'";
//        PreparedStatement preparedStmt = c1.prepareStatement(query);
//        preparedStmt.executeUpdate();
//        establish_connection().close();
//        System.out.println("one Client suspended");
    }

    @RequestMapping("setDiscountArea")
    @Override
    @PostMapping
    public void setDiscountArea(@RequestBody String areas) throws SQLException, ClassNotFoundException {
//        System.out.println(areas);
//        Connection c1 = establish_connection();
//        JSONArray jsonArray = new JSONArray(areas);
//        for (Object jsonOb : jsonArray)
//        {
//            Statement statement = establish_connection().createStatement();
//            String query = " insert into DiscountAreas (area) values (?)";
//            PreparedStatement preparedStmt = c1.prepareStatement(query);
//            preparedStmt.setString (1, (String) jsonOb);
//            preparedStmt.executeUpdate();
//        }
//        System.out.println("areas added");
    }
}
