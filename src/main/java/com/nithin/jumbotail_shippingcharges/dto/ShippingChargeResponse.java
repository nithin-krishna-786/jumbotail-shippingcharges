package com.nithin.jumbotail_shippingcharges.dto;

import lombok.Data;

@Data
public class ShippingChargeResponse {
    private double shippingCharge;

    public ShippingChargeResponse(double shippingCharge) {
        this.shippingCharge = shippingCharge;
    }

    // Getters and setters
}
