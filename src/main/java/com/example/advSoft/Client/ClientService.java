package com.example.advSoft.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLException;
import java.util.List;


public interface ClientService {

    Client client = new Client();
    public void RequestRide(@RequestBody String req) throws SQLException, ClassNotFoundException;


}
