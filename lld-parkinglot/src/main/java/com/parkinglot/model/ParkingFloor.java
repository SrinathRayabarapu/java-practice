package com.parkinglot.model;

import lombok.Data;

import java.util.List;

@Data
public class ParkingFloor {

    private int floorNumber;

    private List<ParkingSpot> parkingSpots;
}
