package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    @Column(name="brand")
    private String brand;

    @Column(name="car_model")
    private String carModel;

    public Vehicle() {

    }

    public Vehicle(int Id, String brand, String carModel) {

        this.Id = Id;
        this.brand = brand;
        this.carModel = carModel;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }


    @Override
    public String toString() {
        return "Vehicle{" +
                "Id=" + Id +
                ", brand='" + brand + '\'' +
                ", carModel='" + carModel + '\'' +
                '}';
    }
}