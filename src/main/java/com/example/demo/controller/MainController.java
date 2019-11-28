package com.example.demo.controller;

import com.example.demo.dao.VehicleDao;
import com.example.demo.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    private VehicleDao vehicleDao;


    //Find all Vehicles
    @GetMapping(value = "/Vehicles")
    public List<Vehicle> list() {
        List<Vehicle> all = vehicleDao.findAll();
        return all;

    }

    //Find Vehicle by {id}
    @GetMapping(value = "Vehicle/{id}")
    public Vehicle showVehicle(@PathVariable int id, HttpServletResponse response){
        Vehicle vehicle = null;
        try {
            vehicle = vehicleDao.findById(id).orElseThrow(()->new Exception());
        } catch (Exception e) {
            response.setStatus(HttpStatus.NO_CONTENT.value());
        }
        return vehicle;
    }
    //Add a new vehicle
    @PostMapping(value = "/Vehicle")
    public Vehicle create(@RequestBody Vehicle vehicle) {
        return vehicleDao.save(vehicle);

    }

    //Edit a Vehicle
    @PutMapping(value = "/Vehicle/{id}")
    public void update(@PathVariable int id, @RequestBody Vehicle vehicle) {
        vehicleDao.save(vehicle);
    }

    //Delete by id
    @DeleteMapping(value = "/Vehicle/{id}")
    public void deleteById(@PathVariable int id) {
        vehicleDao.deleteById(id);
    }


}
