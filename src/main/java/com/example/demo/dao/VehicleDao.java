package com.example.demo.dao;

import java.util.List;
import com.example.demo.model.Vehicle;

public interface VehicleDao {


    public List<Vehicle> findAll();

    public Vehicle findById(int id);

    public Vehicle create(Vehicle vehicle);

    public Vehicle updateVehicle(int id, Vehicle updateVehicle);

    public Vehicle deleteById(int id);

}
