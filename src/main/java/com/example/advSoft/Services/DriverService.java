package com.example.advSoft.Services;

import com.example.advSoft.DB.DriverDB;
import com.example.advSoft.Models.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {
    DriverDB driverData;
    @Autowired
    public DriverService(@Qualifier("repo")DriverDB driverData) {
        this.driverData = driverData;
    }
    public List<Driver> getAllDrivers(){
        //return templates;
        List<Driver> n= this.driverData.findAll();
        return n;
    }
    public void add(Driver template){
        //templates.add(template);
        this.driverData.save(template);
    }
}
