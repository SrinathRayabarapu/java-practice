package com.parkinglot.model;

import lombok.Data;

import java.util.List;

@Data
public class ParkingLot {

    private String name;

    private String address;

    private List<ParkingFloor> parkingFloors;

    private List<Gate> entryGates;

    private List<Gate> exitGates;
}
