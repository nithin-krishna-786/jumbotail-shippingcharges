package com.nithin.jumbotail_shippingcharges.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TransportMode {

    @Id
    private Long id;
    private double distance;
    private double ratePerKm;
}
