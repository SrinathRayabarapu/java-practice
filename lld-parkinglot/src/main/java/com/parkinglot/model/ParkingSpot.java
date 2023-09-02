package com.parkinglot.model;

import lombok.Data;

@Data
public class ParkingSpot {

    private int spotNumber;

    private SpotStatus spotStatus;

    private VehicleType vehicleType;

    private Vehicle vehicle;

}
