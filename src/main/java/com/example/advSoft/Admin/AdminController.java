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
    public String listPendingDrivers() throws SQLException, ClassNotFoundException {
        JSONArray allDrivers = dbDriver.listAll();
        JSONObject driver;
        List<String> allPendingDrivers = new ArrayList<>();

        for (int i=0;i<allDrivers.length();i++)
        {
            driver = allDrivers.getJSONObject(i);
            if (driver.get("status").equals("UnVerified"))
            {
                allPendingDrivers.add(driver.toString());
            }
        }
        return allPendingDrivers.toString();
    }

    @RequestMapping("verifyDriver")
    @Override
    @PostMapping
    public void verifyDriverRegistration(@RequestBody String req) throws SQLException, ClassNotFoundException {
        JSONArray allDrivers = dbDriver.listAll();
        JSONObject jsonObject = new JSONObject(req);

        int id = 0;
        for (int i=0;i<allDrivers.length();i++) {
            if (allDrivers.getJSONObject(i).get("username").equals(jsonObject.get("username")))
            {
                id = (int) allDrivers.getJSONObject(i).get("id");
                jsonObject=allDrivers.getJSONObject(i);
                break;
            }
        }
        String license = jsonObject.getString("drive_license");
        String nationalID = jsonObject.getString("nationalID");

        if(license.length() == 14 && nationalID.length() == 14)
        {
            jsonObject.remove("status");

            jsonObject.put("status","Verified");
        }
        dbDriver.update(jsonObject,id);
        System.out.println("one driver Verified");

    }

    @RequestMapping("suspendAccountDriver")
    @Override
    @PostMapping
    public void suspendAccountDriver( @RequestBody String req) throws SQLException, ClassNotFoundException {
        JSONArray allDrivers = dbDriver.listAll();
        JSONObject jsonObject = new JSONObject(req);

        int id = 0;
        for (int i=0;i<allDrivers.length();i++) {
            if (allDrivers.getJSONObject(i).get("username").equals(jsonObject.get("username")))
            {
                id = (int) allDrivers.getJSONObject(i).get("id");
                jsonObject=allDrivers.getJSONObject(i);
                break;
            }
        }
        jsonObject.remove("status");
        jsonObject.put("status","Suspended");
        dbDriver.update(jsonObject,id);
        System.out.println("one driver Suspended");

    }

    @RequestMapping("suspendAccountClient")
    @Override
    @PostMapping
    public void suspendAccountClient( @RequestBody  String req) throws SQLException, ClassNotFoundException {
        JSONArray allClients = dbClient.listAll();
        JSONObject jsonObject = new JSONObject(req);

        int id = 0;
        for (int i=0;i<allClients.length();i++) {
            if (allClients.getJSONObject(i).get("username").equals(jsonObject.get("username")))
            {
                id = (int) allClients.getJSONObject(i).get("id");
                jsonObject=allClients.getJSONObject(i);
                break;
            }
        }
        jsonObject.remove("status");
        jsonObject.put("status","Suspended");
        dbClient.update(jsonObject,id);
        System.out.println("one client Suspended");
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
