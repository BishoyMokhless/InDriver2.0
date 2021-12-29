package com.example.advSoft.Client;

 import com.example.advSoft.Discount.*;
 import com.example.advSoft.User.User;
 import org.json.JSONArray;
 import org.json.JSONObject;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.*;
 import java.sql.*;
 import java.util.ArrayList;
 import java.util.List;
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

    @RequestMapping("RequestRide")
    @Override
    @PostMapping
    public void RequestRide(@RequestBody String req) throws SQLException, ClassNotFoundException {
        JSONObject jsonObject = new JSONObject(req);
        Integer clientsNumber =Integer.parseInt((String) jsonObject.get("clients_number"));
        Connection c1 = establish_connection();
        String query = " insert into requestedrides (clientName,source,destination,accepted,clients_number) values (?,?,?,?,?)";
        PreparedStatement preparedStmt = c1.prepareStatement(query);
        preparedStmt.setString (1, (String) jsonObject.get("ClientName"));
        preparedStmt.setString (2, (String) jsonObject.get("source"));
        preparedStmt.setString (3, (String) jsonObject.get("destination"));
        preparedStmt.setInt (4, 0);
        preparedStmt.setInt (5, clientsNumber);
        preparedStmt.executeUpdate();
        establish_connection().close();
        System.out.println("onr request created");
    }

    @RequestMapping("viewOffers/{ClientName}")
    @GetMapping
    public String viewOffers(@PathVariable("ClientName") String ClientName) throws SQLException, ClassNotFoundException {
        Connection c1 = establish_connection();
        JSONArray arrOffers = new JSONArray();
        List<String> Ids = new ArrayList<String>();
        JSONArray arr = new JSONArray();
        Statement statement = establish_connection().createStatement();
        ResultSet rs = statement.executeQuery("select id from requestedrides where  clientName='"+ClientName+"' and  accepted=0 ");
        while(rs.next())
        {
            Ids.add(rs.getString("id"));
        }

       for (int i =0;i<Ids.size();i++)
       {
           rs = statement.executeQuery("select *  from offer where ReqRID='"+Ids.get(i)+"' and  accepted=0 ");
           while(rs.next())
           {
               JSONObject jsonObject = new JSONObject();
               jsonObject.put("driverName",rs.getString("driverName"));
               jsonObject.put("id",rs.getString("id"));
               jsonObject.put("ReqRID",rs.getString("ReqRID"));
               jsonObject.put("offerTime",rs.getString("offerTime"));
               jsonObject.put("price",rs.getString("price"));
               arr.put(jsonObject);
           }
       }
        return arr.toString();
    }

    @RequestMapping("acceptOffer/{id}")
    @PostMapping
    public void acceptOffer(@PathVariable("id") String id) throws SQLException, ClassNotFoundException {
         JSONArray arrOffers = new JSONArray();
         JSONArray arr = new JSONArray();
        List<String> Ids = new ArrayList<String>();
        Connection c1 = establish_connection();
        String query = "update offer set accepted=1 where id ="+id+" ";
        PreparedStatement preparedStmt = c1.prepareStatement(query);
        preparedStmt.executeUpdate();
        String reqId="";
        Statement statement = establish_connection().createStatement();
        ResultSet rs = statement.executeQuery("select * from offer where  id='"+id+"'");
        while(rs.next())
        {
            reqId=rs.getString("ReqRID");
        }
        query = "update requestedrides set accepted=1 where id ="+reqId+" ";
        preparedStmt = c1.prepareStatement(query);
        preparedStmt.executeUpdate();
         c1 = establish_connection();
         query = " insert into ride (offer_id) values (?)";
         preparedStmt = c1.prepareStatement(query);
        preparedStmt.setString (1, id);
        preparedStmt.executeUpdate();
        establish_connection().close();
        System.out.println("one accepted Offer ");
    }

    @RequestMapping("checkDiscount/{ClientName}")
    @GetMapping
    public String checkDiscount(@PathVariable("ClientName") String ClientName) throws SQLException, ClassNotFoundException
    {
        JSONArray arrDiscounts = new JSONArray();
        List<Double> discounts = new ArrayList<Double>();
        JSONArray arr = new JSONArray();
        Discount discount = new BirthdayDiscount();
        discounts.add(discount.getDiscount(ClientName));
        discount = new NclientsDiscount();
        discounts.add(discount.getDiscount(ClientName));
        discount = new AreaDiscount();
        discounts.add(discount.getDiscount(ClientName));
        discount = new FirstRideDiscount();
        discounts.add(discount.getDiscount(ClientName));

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Birthday Discount", discounts.get(0));
        jsonObject.put("Nclients Discount", discounts.get(1));
        jsonObject.put("Area Discount", discounts.get(2));
        jsonObject.put("First time Discount", discounts.get(3));
        arr.put(jsonObject);
        return arr.toString();
    }
}
