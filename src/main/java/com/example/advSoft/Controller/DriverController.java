package com.example.advSoft.Controller;

import com.example.advSoft.Models.Driver;
import com.example.advSoft.Services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/driver")
@RestController
public class DriverController {
    DriverService driverService;
    @Autowired

    public DriverController(@RequestBody DriverService driverService) {
        this.driverService = driverService;
    }
    @GetMapping
    public List<Driver> getAll(){
        return driverService.getAllDrivers();
    }

    @PostMapping
    public void add(@RequestBody Driver driver){
        driverService.add(driver);
    }
}
