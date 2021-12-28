package com.example.advSoft.Client;

import org.springframework.web.bind.annotation.RequestBody;
import java.sql.SQLException;

public interface ClientService {

    Client client = new Client();
    public void RequestRide(@RequestBody String req) throws SQLException, ClassNotFoundException;
    public String checkDiscount(@RequestBody String req) throws SQLException, ClassNotFoundException;
}
