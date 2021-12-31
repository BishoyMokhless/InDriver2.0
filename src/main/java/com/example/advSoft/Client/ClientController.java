package com.example.advSoft.Client;
 import com.example.advSoft.Discount.*;
 import com.example.advSoft.User.UserServices;
 import com.example.advSoft.connection.*;
 import org.json.JSONArray;
 import org.json.JSONObject;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.*;
 import java.sql.*;
 import java.time.LocalDateTime;
 import java.time.format.DateTimeFormatter;
 import java.util.ArrayList;
 import java.util.List;

@RequestMapping("/api/client")
@RestController
public class ClientController  implements  ClientService , UserServices {
    IClientDatabaseConnect dbClient = new ClientDatabaseConnect();
    IOfferDatabaseConnect dbOffer = new OfferDatabaseConnect();
    IReqRideDatabaseConnect dbReqRide = new ReqRideDatabaseConnect();
    IRideDatabaseConnect dbRide = new RideDatabaseConnect();

    @Autowired
    ClientController(){

    }

    //TEST REQUIRED
    @Override
    @GetMapping
    public String getAll() throws SQLException, ClassNotFoundException {
        JSONArray allClients = new JSONArray();
        allClients = dbClient.listAll();
        return allClients.toString();
    }

    @RequestMapping("register")
    @Override
    @PostMapping
    public void register( @RequestBody String person) throws  ClassNotFoundException, SQLException {
        JSONObject jsonObject = new JSONObject(person);
        dbClient.set(jsonObject);
    }

    @RequestMapping("login")
    @Override
    @PostMapping
    public String login(String person) throws  ClassNotFoundException, SQLException {
        JSONObject jsonObject =   dbClient.login(person);
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

    @RequestMapping("viewOffers/{clientName}")
    @Override
    @GetMapping
    public String viewOffers(@PathVariable("clientName") String clientName) throws SQLException, ClassNotFoundException {
        return dbOffer.viewOffersOfClient(clientName);
    }

    @RequestMapping("acceptOffer/{id}")
    @Override
    @PostMapping
    public void acceptOffer(@PathVariable("id") int id) throws SQLException, ClassNotFoundException
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        JSONObject offer = new JSONObject();
        JSONObject reqride = new JSONObject();
        JSONObject ride = new JSONObject();
        offer = dbOffer.get(id);
        System.out.println(offer.get("requestedrides_id").toString());
        String temp = offer.get("requestedrides_id").toString();
        int reqId = Integer.parseInt(temp);
        offer.put("accepted", 1);
        offer.put("accepted_time", dtf.format(now));
        //System.out.println(offer.get(""));
        dbOffer.update(offer, id);

        /*reqride = dbReqRide.get(reqId);
        reqride.append("accepted", 1);
        dbReqRide.update(reqride, reqId);
        ride.put("id", id);
        dbRide.set(ride);*/
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
