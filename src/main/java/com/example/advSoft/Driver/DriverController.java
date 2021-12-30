package com.example.advSoft.Driver;

import com.example.advSoft.User.User;
import com.example.advSoft.connection.ClientDatabaseConnect;
import com.example.advSoft.connection.DataBaseConnect;
import com.example.advSoft.connection.DriverDatabaseConnect;
import com.example.advSoft.connection.RideDatabaseConnect;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@RequestMapping("/api/driver")
@RestController
public class DriverController implements DriverService ,User{
    DataBaseConnect dbDriver = new ClientDatabaseConnect();
    DataBaseConnect dbRide = new RideDatabaseConnect();
    @Autowired
    DriverController(){

    }
    @Override
    @GetMapping
    public String getAll() throws ClassNotFoundException, SQLException {
        JSONArray allDrivers = new JSONArray();
        allDrivers = dbDriver.listAll();
        return allDrivers.toString();
    }

    @PostMapping
    @Override
    public void register( @RequestBody String person) throws SQLException, ClassNotFoundException, SQLException {
        JSONObject jsonObject = new JSONObject(person);
        dbDriver.set(jsonObject);
    }


    @RequestMapping("login")
    @Override
    @PostMapping
    public String login(String person) throws SQLException, ClassNotFoundException, SQLException {
        JSONArray allDrivers;
        JSONObject jsonObject = new JSONObject(person);
        allDrivers = dbDriver.listAll();

        for (int i =0; i<allDrivers.length();i++)
        {
            JSONObject temp = allDrivers.getJSONObject(i);
            Boolean bool1 = temp.get("pass").equals(jsonObject.get("pass"));
            Boolean bool2 = temp.get("username").equals(jsonObject.get("username"));
            if( bool1 && bool2)
            {
                System.out.println("Login successfully");
            }
            break;
        }

        return jsonObject.toString();
    }

    @RequestMapping("FavAreas/{username}")
    @Override
    @PostMapping
    public void FavAreas( @RequestBody String area ,@PathVariable("username") String username) throws SQLException, ClassNotFoundException {
//        Connection c1 = establish_connection();
//        JSONArray jsonArray = new JSONArray(area);
//        for (Object jsonOb : jsonArray)
//        {
//            Statement statement = establish_connection().createStatement();
//
//        }
//        System.out.println("areas added");
    }

    @RequestMapping("listAllRides/{username}")
    @Override
    @GetMapping
    public String listAllRides(@PathVariable("username") String drivername) throws SQLException, ClassNotFoundException {
        JSONArray allRides;
        allRides = dbRide.listAll();
        JSONArray allDriverRides= new JSONArray();
        for (int i =0; i<allRides.length();i++) {
            JSONObject temp = allRides.getJSONObject(i);
            if(temp.get("drivername").equals(drivername))
            {
                allDriverRides.put(temp);
            }

        }
        return allDriverRides.toString();
    }


    @RequestMapping("listAllRequestedRides/{DriverName}")
    @Override
    @GetMapping
    public String listAllRequestedRides(@PathVariable("DriverName") String DriverName) throws SQLException, ClassNotFoundException {
//        Connection c1 = establish_connection();
//        JSONArray arr = new JSONArray();
//        List<String> FavArea = new ArrayList<String>();
//        Statement statement = establish_connection().createStatement();
//            ResultSet rs = statement.executeQuery("select *  from favarea where driverName='"+DriverName+"'");
//        while(rs.next())
//        {
//            FavArea.add(rs.getString("area"));
//        }
//        for (int i=0;i<FavArea.size();i++)
//        {
//             statement = establish_connection().createStatement();
//             rs = statement.executeQuery("select *  from requestedrides where source='"+FavArea.get(i)+"' and  accepted=0");
//            while(rs.next())
//            {
//                JSONObject jsonObject = new JSONObject();
//                jsonObject.put("id",rs.getString("id"));
//                jsonObject.put("clientName",rs.getString("clientName"));
//                jsonObject.put("source",rs.getString("source"));
//                jsonObject.put("destination",rs.getString("destination"));
//                jsonObject.put("accepted",rs.getString("accepted"));
//                arr.put(jsonObject);
//            }
//        }
//        return arr.toString();
        return null;
    }

    @RequestMapping("sendOffer/{id}")
    @Override
    @PostMapping
    public void sendOffer(@PathVariable("id") int id,@RequestBody  String req) throws SQLException, ClassNotFoundException {
//        boolean inRide = false;
//        JSONObject jsonObject = new JSONObject(req);
//        Statement statement = establish_connection().createStatement();
//        ResultSet rs = statement.executeQuery("select *  from offer where driverName='"+jsonObject.get("driverName") + "' and TIMESTAMPDIFF(SECOND, CURRENT_TIMESTAMP, offerTime) <= 1440 and accepted = 1 ");
//        while(rs.next())
//        {
//            Statement statement2 = establish_connection().createStatement();
//            ResultSet rs2 = statement2.executeQuery("select *  from ride where offer_id='"+rs.getInt("id") + "' and arrive_destination_time IS NULL ");
//            if(rs2.next())
//            {
//                System.out.println("You can't send offer while you are in a trip");
//                inRide = true;
//                break;
//            }
//        }
//        if(!inRide)
//        {
//            //float price = Float.parseFloat((String) jsonObject.get("price"));
//            float price = BigDecimal.valueOf(jsonObject.getDouble("price")).floatValue();
//            Connection c1 = establish_connection();
//            String query = " insert into offer (driverName,ReqRID,price,accepted) values (?,?,?,?)";
//            PreparedStatement preparedStmt = c1.prepareStatement(query);
//            preparedStmt.setString(1, (String) jsonObject.get("driverName"));
//            preparedStmt.setInt(2, id);
//            preparedStmt.setFloat(3, price);
//            preparedStmt.setInt(4, 0);
//            preparedStmt.executeUpdate();
//            establish_connection().close();
//            System.out.println("one offer created");
//        }
    }

    @RequestMapping("startTrip/{id}")
    @Override
    @PostMapping
    public void startTrip(@PathVariable("id") int id) throws SQLException, ClassNotFoundException
    {
//        Connection c1 = establish_connection();
//        String query = "update ride set arrive_source_time = CURRENT_TIMESTAMP where id = '" + id + "'";
//        PreparedStatement preparedStmt = c1.prepareStatement(query);
//        preparedStmt.executeUpdate();
//        establish_connection().close();
//        System.out.println("the trip is started");
    }

    @RequestMapping("endTrip/{id}")
    @Override
    @PostMapping
    public void endTrip(@PathVariable("id") int id) throws SQLException, ClassNotFoundException
    {
//        Connection c1 = establish_connection();
//        String query = "update ride set arrive_destination_time = CURRENT_TIMESTAMP where id = '" + id + "'";
//        PreparedStatement preparedStmt = c1.prepareStatement(query);
//        preparedStmt.executeUpdate();
//        establish_connection().close();
//        System.out.println("the trip is ended");
    }
}
