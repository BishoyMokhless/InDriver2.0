package com.example.advSoft.Client;

 import com.example.advSoft.Discount.*;
 import com.example.advSoft.User.User;
 import com.example.advSoft.connection.ClientDatabaseConnect;
 import com.example.advSoft.connection.DataBaseConnect;
 import com.example.advSoft.connection.OfferDatabaseConnect;
 import com.example.advSoft.connection.ReqRideDatabaseConnect;
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
    DataBaseConnect dbOffer = new OfferDatabaseConnect();
    DataBaseConnect dbReqRide = new ReqRideDatabaseConnect();
    @Autowired
    ClientController(){

    }

    @Override
    @GetMapping
    public String getAll() throws SQLException, ClassNotFoundException {
        JSONArray allClients = new JSONArray();
        allClients = dbClient.listAll();
        return allClients.toString();
    }
    @PostMapping
    public void register( @RequestBody String person) throws  ClassNotFoundException, SQLException {
        JSONObject jsonObject = new JSONObject(person);
        dbClient.set(jsonObject);
    }

    @RequestMapping("login")
    @Override
    @PostMapping
    public String login(String person) throws  ClassNotFoundException, SQLException {

        JSONArray allClients;
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
        dbReqRide.set(jsonObject);
        System.out.println("one request created");
    }

    @RequestMapping("viewOffers/{ClientName}")
    @GetMapping
    public String viewOffers(@PathVariable("ClientName") String ClientName) throws SQLException, ClassNotFoundException {
        JSONArray allOffers ;
        allOffers = dbOffer.listAll();
        JSONArray allClientOffers= new JSONArray();
        for (int i =0; i<allOffers.length();i++) {
            JSONObject temp = allOffers.getJSONObject(i);
            if(temp.get("ClientName").equals(ClientName))
            {
                allClientOffers.put(temp);
            }

        }
        return allClientOffers.toString();
    }

    @RequestMapping("acceptOffer/{id}")
    @PostMapping
    public void acceptOffer(@PathVariable("id") String id) throws SQLException, ClassNotFoundException
    {
//         JSONArray arrOffers = new JSONArray();
//         JSONArray arr = new JSONArray();
//        List<String> Ids = new ArrayList<String>();
//        Connection c1 = establish_connection();
//        String query = "update offer set accepted=1 where id ="+id+" ";
//        PreparedStatement preparedStmt = c1.prepareStatement(query);
//        preparedStmt.executeUpdate();
//        String reqId="";
//        Statement statement = establish_connection().createStatement();
//        ResultSet rs = statement.executeQuery("select * from offer where  id='"+id+"'");
//        while(rs.next())
//        {
//            reqId=rs.getString("ReqRID");
//        }
//        query = "update requestedrides set accepted=1 where id ="+reqId+" ";
//        preparedStmt = c1.prepareStatement(query);
//        preparedStmt.executeUpdate();
//         c1 = establish_connection();
//         query = " insert into ride (offer_id) values (?)";
//         preparedStmt = c1.prepareStatement(query);
//        preparedStmt.setString (1, id);
//        preparedStmt.executeUpdate();
//        establish_connection().close();
//        System.out.println("one accepted Offer ");
    }

    @RequestMapping("checkDiscount/{ClientName}")
    @Override
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
