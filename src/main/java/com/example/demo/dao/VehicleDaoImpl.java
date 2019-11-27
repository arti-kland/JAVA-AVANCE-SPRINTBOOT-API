package com.example.demo.dao;

import com.example.demo.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleDaoImpl implements VehicleDao {

    public static List<Vehicle> vehicles = new ArrayList<>();
    static {

        vehicles.add(new Vehicle(1, "Renaud", "Clio"));
        vehicles.add(new Vehicle(2, "Citroen", "C4"));
        vehicles.add(new Vehicle(3, "Ferrari", "Enzo"));
        vehicles.add(new Vehicle(4, "Fiat", "Tipo"));
        vehicles.add(new Vehicle(5, "Peugot", "308"));
    }

    //Find all Vehicle
    @Override
    public List<Vehicle> findAll() {
        return vehicles;
    }

    //Find by Id Vehicle
    @Override
    public Vehicle findById(int id) {
        return vehicles.get(id-1);
    }

    // Add Vehicle
    @Override
    public Vehicle create(Vehicle vehicle) {
        vehicles.add(vehicle);
        return vehicle;
    }

    // Delete a Vehicle
    @Override
    public Vehicle deleteById(int Id) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId() == Id) {
                vehicles.remove(vehicle);
                return vehicle;
            }
        }
        return null;
    }


    //Edit a Vehicle
    @Override
    public Vehicle updateVehicle(int id, Vehicle updateVehicle) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId() == id) {
                if (updateVehicle.getCarModel() != null) {
                    vehicle.setCarModel(updateVehicle.getCarModel());
                }
                if (updateVehicle.getBrand() != null) {
                    vehicle.setBrand(updateVehicle.getBrand());
                }
                return vehicle;
            }
        }
        return null;
    }
}
