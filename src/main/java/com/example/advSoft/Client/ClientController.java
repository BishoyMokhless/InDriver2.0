package com.example.advSoft.Client;

 import com.example.advSoft.Discount.*;
 import com.example.advSoft.User.User;
 import com.example.advSoft.connection.ClientDatabaseConnect;
 import com.example.advSoft.connection.DataBaseConnect;
 import org.json.JSONArray;
 import org.json.JSONObject;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.*;
 import java.sql.*;
 import java.util.ArrayList;
 import java.util.List;

@RequestMapping("/api/client")
@RestController
public class ClientController  implements  ClientService , User {
    DataBaseConnect dbClient = new ClientDatabaseConnect();
    @Autowired


    @Override
    @GetMapping
    public String getAll() throws SQLException, ClassNotFoundException {
        JSONArray arr = new JSONArray();
        arr = dbClient.listAll();
        return arr.toString();
    }
    @PostMapping
    public void register( @RequestBody String person) throws SQLException, ClassNotFoundException, SQLException {
        JSONObject jsonObject = new JSONObject(person);
        dbClient.set(jsonObject);
    }

    @RequestMapping("login")
    @Override
    @PostMapping
    public String login(String person) throws SQLException, ClassNotFoundException, SQLException {

        JSONArray allClients = new JSONArray();
        JSONObject jsonObject = new JSONObject(person);
        allClients = dbClient.listAll();

        for (int i =0; i<allClients.length();i++)
        {
            JSONObject temp = allClients.getJSONObject(i);
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
