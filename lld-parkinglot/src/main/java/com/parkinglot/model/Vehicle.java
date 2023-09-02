package com.parkinglot.model;

import lombok.Data;

@Data
public class Vehicle {

    private String registrationNumber;

    private VehicleType vehicleType;
}
