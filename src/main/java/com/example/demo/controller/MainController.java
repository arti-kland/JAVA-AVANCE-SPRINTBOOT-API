package com.example.demo.controller;

import com.example.demo.dao.VehicleDao;
import com.example.demo.dao.VehicleDaoImpl;
import com.example.demo.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private VehicleDao vehicleDao;


    //Vehicles All
    @GetMapping(value = "/Vehicles")
    public List<Vehicle> list() {
        List<Vehicle> all = vehicleDao.findAll();
        return all;

    }

    //Vehicle/{id}
    @GetMapping(value = "Vehicle/{id}")
    public Vehicle showVehicle(@PathVariable int id){

        return vehicleDao.findById(id);
    }
    //Add vehicle
    @PostMapping(value = "/Vehicle")
    public Vehicle create(@RequestBody Vehicle vehicle) {
        return vehicleDao.create(vehicle);

    }

    //Edit a Vehicle
    @PutMapping(value = "/Vehicle/{id}")
    public void update(@PathVariable int id, @RequestBody Vehicle vehicle) {
        vehicleDao.updateVehicle(id, vehicle);
    }

    //Delete by id
    @DeleteMapping(value = "/Vehicle/{id}")
    public void deleteById(@PathVariable int id) {
        vehicleDao.deleteById(id);
    }


}
