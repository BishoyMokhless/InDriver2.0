package com.example.advSoft.Driver;

import com.example.advSoft.User.User;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
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

    @RequestMapping("FavAreas/{username}")
    @Override
    @PostMapping
    public void FavAreas( @RequestBody String area ,@PathVariable("username") String username) throws SQLException, ClassNotFoundException {
        Connection c1 = establish_connection();
        JSONArray jsonArray = new JSONArray(area);
        for (Object jsonOb : jsonArray)
        {
            Statement statement = establish_connection().createStatement();
            String query = " insert into favarea (area,driverName) values (?,?)";
            PreparedStatement preparedStmt = c1.prepareStatement(query);
            preparedStmt.setString (1, (String) jsonOb);
            preparedStmt.setString (2,  username);
            preparedStmt.executeUpdate();
        }
        System.out.println("areas added");
    }

    @RequestMapping("listAllRides/{username}")
    @Override
    @GetMapping
    public String listAllRides(@PathVariable("username") String drivername) throws SQLException, ClassNotFoundException {
        Connection c1 = establish_connection();
        JSONArray arr = new JSONArray();
        Statement statement = establish_connection().createStatement();
        ResultSet rs = statement.executeQuery("select *  from ride where driverName='"+drivername+"'");
        while(rs.next())
        {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id",rs.getString("id"));
            jsonObject.put("driverName",rs.getString("driverName"));
            jsonObject.put("clientName",rs.getString("clientName"));
            jsonObject.put("source",rs.getString("source"));
            jsonObject.put("price",rs.getString("price"));
            jsonObject.put("destination",rs.getString("destination"));
            jsonObject.put("clients_number",rs.getString("clients_number"));
            jsonObject.put("arrive_source_time",rs.getString("arrive_source_time"));
            jsonObject.put("arrive_estination_time",rs.getString("arrive_estination_time"));
            arr.put(jsonObject);
        }
        return arr.toString();
    }


    @RequestMapping("listAllRequestedRides/{DriverName}")
    @Override
    @GetMapping
    public String listAllRequestedRides(@PathVariable("DriverName") String DriverName) throws SQLException, ClassNotFoundException {
        Connection c1 = establish_connection();
        JSONArray arr = new JSONArray();
        List<String> FavArea = new ArrayList<String>();
        Statement statement = establish_connection().createStatement();
            ResultSet rs = statement.executeQuery("select *  from favarea where driverName='"+DriverName+"'");
        while(rs.next())
        {
            FavArea.add(rs.getString("area"));
        }
        for (int i=0;i<FavArea.size();i++)
        {
             statement = establish_connection().createStatement();
             rs = statement.executeQuery("select *  from requestedrides where source='"+FavArea.get(i)+"' and  accepted=0");
            while(rs.next())
            {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id",rs.getString("id"));
                jsonObject.put("clientName",rs.getString("clientName"));
                jsonObject.put("source",rs.getString("source"));
                jsonObject.put("destination",rs.getString("destination"));
                jsonObject.put("accepted",rs.getString("accepted"));
                arr.put(jsonObject);
            }
        }
        return arr.toString();
    }

    @RequestMapping("sendOffer/{id}")
    @Override
    @PostMapping
    public void sendOffer(@PathVariable("id") int id,@RequestBody  String req) throws SQLException, ClassNotFoundException {
        JSONObject jsonObject = new JSONObject(req);
        System.out.println(id);
        Float price =Float.parseFloat((String) jsonObject.get("price"));
        Connection c1 = establish_connection();
        String query = " insert into offer (driverName,ReqRID,price,accepted) values (?,?,?,?)";
        PreparedStatement preparedStmt = c1.prepareStatement(query);
        preparedStmt.setString (1, (String) jsonObject.get("driverName"));
        preparedStmt.setInt (2, id);
        preparedStmt.setFloat (3,  price);
        preparedStmt.setInt (4,0 );
        preparedStmt.executeUpdate();
        establish_connection().close();
        System.out.println("onr offer created");
    }
}
