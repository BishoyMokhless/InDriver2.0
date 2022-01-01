package com.example.advSoft.Ride;

import com.example.advSoft.connection.IOfferDatabaseConnect;
import com.example.advSoft.connection.IRideDatabaseConnect;
import com.example.advSoft.connection.OfferDatabaseConnect;
import com.example.advSoft.connection.RideDatabaseConnect;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;


@RequestMapping("/api/ridemanager")
@RestController
public class RideController implements  RideService {


    @RequestMapping("showDriverPrice/{rideID}")
    @Override
    @GetMapping
    public String showDriverPrice(@PathVariable("rideID") int rideID) throws SQLException, ClassNotFoundException {

        IRideDatabaseConnect RDB=new RideDatabaseConnect();
        int getRequstID=  RDB.getRequstID(rideID);
        String offers= RDB.getOffersWithReqID(getRequstID);
        return offers;

    }

    @RequestMapping("showAcceptedPriceOffer/{rideID}")
    @Override
    @GetMapping
    public String showAcceptedPriceOffer(@PathVariable("rideID") int rideID) throws SQLException, ClassNotFoundException {
        IOfferDatabaseConnect ODB=new OfferDatabaseConnect();
         JSONObject acceptedOffer= ODB.get(rideID);
         return acceptedOffer.toString();
    }

    @RequestMapping("driverArriveToSource/{rideID}")
    @Override
    @GetMapping
    public String driverArriveToSource(@PathVariable("rideID") int rideID) throws SQLException, ClassNotFoundException {
         IRideDatabaseConnect RDB=new RideDatabaseConnect();
         JSONObject ride= RDB.get(rideID);
         JSONObject RideArriveTime=new JSONObject();
         RideArriveTime.put("arrive_source_time",ride.get("arrive_source_time"));
         return RideArriveTime.toString();
    }

    @RequestMapping("driverArriveToDestination/{rideID}")
    @Override
    @GetMapping
    public String driverArriveToDestination(@PathVariable("rideID") int rideID) throws SQLException, ClassNotFoundException {
        IRideDatabaseConnect RDB=new RideDatabaseConnect();
        JSONObject ride= RDB.get(rideID);
        JSONObject RideArriveTime=new JSONObject();
        RideArriveTime.put("arrive_destination_time",ride.get("arrive_destination_time"));
        return RideArriveTime.toString();
    }


}
