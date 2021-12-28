package com.example.advSoft.Driver;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.sql.SQLException;

public interface DriverService {

    public String listAllRequestedRides(@PathVariable("DriverName") String DriverName) throws SQLException, ClassNotFoundException;
    public String listAllRides(@PathVariable("username") String drivername) throws SQLException, ClassNotFoundException;
    public void FavAreas( @RequestBody String area ,@PathVariable("username") String username) throws SQLException, ClassNotFoundException;
    public void sendOffer(@PathVariable("id") int id, @RequestBody  String req) throws SQLException, ClassNotFoundException ;
}
