package com.example.advSoft.Client;

 import com.example.advSoft.User.User;
 import com.example.advSoft.connection.DataBaseConnect;
 import com.fasterxml.jackson.databind.util.JSONPObject;
 import org.json.JSONArray;
 import org.json.JSONObject;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

 import java.sql.*;

 import static com.example.advSoft.connection.DataBaseConnect.establish_connection;

@RequestMapping("/api/client")
@RestController
public class ClientController  extends Client implements  ClientService , User {
    @Autowired




    @Override
    @GetMapping
    public String getAll() throws SQLException, ClassNotFoundException {
        Connection c1 = establish_connection();

        JSONArray arr = new JSONArray();

        Statement statement = establish_connection().createStatement();
        ResultSet rs = statement.executeQuery("select *  from client ");
        while(rs.next())
        {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("username",rs.getString("username"));
            jsonObject.put("email",rs.getString("email"));
            jsonObject.put("pass",rs.getString("pass"));
            jsonObject.put("mobileNumber",rs.getString("mobileNumber"));
             jsonObject.put("status",rs.getString("status"));
            arr.put(jsonObject);
         }

        return arr.toString();

    }

    @Override
    @PostMapping
    public void register( @RequestBody String person) throws SQLException, ClassNotFoundException, SQLException {

        JSONObject jsonObject = new JSONObject(person);
        Connection c1 = establish_connection();
        String query = " insert into client (username,email,pass,mobileNumber,status) values (?,?,?,?,?)";
        PreparedStatement preparedStmt = c1.prepareStatement(query);
        preparedStmt.setString (1, (String) jsonObject.get("username"));
        preparedStmt.setString (2, (String) jsonObject.get("email"));
        preparedStmt.setString (3, (String) jsonObject.get("pass"));
        preparedStmt.setString (4, (String) jsonObject.get("mobileNumber"));
        preparedStmt.setString (5, (String) jsonObject.get("status"));
        preparedStmt.executeUpdate();
        establish_connection().close();
        System.out.println("onr user created");
    }


    @RequestMapping("login")
    @Override
    @PostMapping
    public String login(String person) throws SQLException, ClassNotFoundException, SQLException {
        Connection c1 = establish_connection();
        JSONArray arr = new JSONArray();

        JSONObject jsonObject = new JSONObject(person);

        Statement statement = establish_connection().createStatement();
        ResultSet rs = statement.executeQuery("select *  from client where username='"+ (String) jsonObject.get("username") +"' and pass='"+ (String) jsonObject.get("pass") + "'" );
        while(rs.next())
        {
            System.out.println("in login");

            JSONObject newjsonObject = new JSONObject();
            newjsonObject.put("username",rs.getString("username"));
            newjsonObject.put("email",rs.getString("email"));
            newjsonObject.put("mobileNumber",rs.getString("mobileNumber"));
             newjsonObject.put("status",rs.getString("status"));
            arr.put(newjsonObject);
        }

        return arr.toString();
    }

    @Override
    public void RequestRide(String clientName, String source, String destination) throws SQLException, ClassNotFoundException {

    }
}
