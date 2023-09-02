package com.parkinglot.model;

import lombok.Data;

@Data
public class Gate {

    private int gateNumber;

    private ParkingAttendant parkingAttendant;

    private GateType gateType;
}
