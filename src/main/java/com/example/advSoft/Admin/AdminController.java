package com.example.advSoft.Admin;

import com.example.advSoft.Driver.Driver;
import com.example.advSoft.connection.*;
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
        JSONArray allDrivers = dbDriver.listAll();
        JSONObject jsonObject = new JSONObject(person);
        int id = 0;
        for (int i=0;i<allDrivers.length();i++) {
            if (allDrivers.getJSONObject(i).equals(jsonObject))
                id = i;
            break;
        }
        String license = jsonObject.getString("drive_license");
        String nationalID = jsonObject.getString("nationalID");
        if(license.length() == 14 && nationalID.length() == 14)
        {
            jsonObject.append("status","Verified");
        }
        dbDriver.update(jsonObject,id);
        System.out.println("one driver Verified");
    }

    @RequestMapping("suspendAccountDriver/{username}")
    @Override
    @PostMapping
    public void suspendAccountDriver( @PathVariable("username") String username) throws SQLException, ClassNotFoundException {
        JSONArray allDrivers = dbDriver.listAll();
        JSONObject jsonObject = new JSONObject();
        int id = 0;
        for (int i=0;i<allDrivers.length();i++) {
            if (allDrivers.getJSONObject(i).get("username").equals(username))
                id =i;
            break;
        }
        jsonObject.append("status","Suspended");
        dbDriver.update(jsonObject,id);
    }

    @RequestMapping("suspendAccountClient/{username}")
    @Override
    @PostMapping
    public void suspendAccountClient( @PathVariable("username") String username) throws SQLException, ClassNotFoundException {
        JSONArray allClients = dbClient.listAll();
        JSONObject jsonObject = new JSONObject();
        int id = 0;
        for (int i=0;i<allClients.length();i++) {
            if (allClients.getJSONObject(i).get("username").equals(username))
                id =i;
            break;
        }
        jsonObject.append("status","Suspended");
        dbClient.update(jsonObject,id);
    }

    @RequestMapping("setDiscountArea")
    @Override
    @PostMapping
    public void setDiscountArea(@RequestBody String areas) throws SQLException, ClassNotFoundException {

               System.out.println(areas);
               DataBaseConnect DB=new AreaDiscountDatabseConnect();
               JSONArray arr=new JSONArray(areas);
               System.out.println(arr);
               for (int i=0;i<arr.length();i++)
               {
                   JSONObject object=new JSONObject();
                   object.put("area",arr.get(i));
                   DB.set(object);
               }

    }
}
