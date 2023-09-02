package com.parkinglot.model;

import lombok.Data;

import java.util.Date;

@Data
public class Ticket {

    private String id;

    private Date entryTime;

    private ParkingSpot parkingSpot;

    private Gate issuingGate;

    private ParkingAttendant parkingAttendant;

    private Vehicle vehicle;

}