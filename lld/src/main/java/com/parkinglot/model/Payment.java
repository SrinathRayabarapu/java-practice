package com.parkinglot.model;

import lombok.Data;

import java.util.Date;

@Data
public class Payment {

    private String reference;

    private Double amount;

    private PaymentMode paymentMode;

    private PaymentStatus paymentStatus;

    private Date time;

    private Ticket ticket;

}
