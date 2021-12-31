package com.example.advSoft.Ride;

import org.springframework.web.bind.annotation.PathVariable;

public interface RideService {

    public  void showDriverPrice(@PathVariable("DriverName") String DriverName);
}
