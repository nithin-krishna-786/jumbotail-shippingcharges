package com.nithin.jumbotail_shippingcharges.dto;


import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ShippingChargeRequest {

    @NotNull(message = "Warehouse latitude is required")
    @DecimalMin(value = "-90", message = "Warehouse latitude must be between -90 and 90")
    @DecimalMax(value = "90", message = "Warehouse latitude must be between -90 and 90")
    private Double warehouseLatitude;

    @NotNull(message = "Warehouse longitude is required")
    @DecimalMin(value = "-180", message = "Warehouse longitude must be between -180 and 180")
    @DecimalMax(value = "180", message = "Warehouse longitude must be between -180 and 180")
    private Double warehouseLongitude;

    @NotNull(message = "Shop latitude is required")
    @DecimalMin(value = "-90", message = "Shop latitude must be between -90 and 90")
    @DecimalMax(value = "90", message = "Shop latitude must be between -90 and 90")
    private Double shopLatitude;

    @NotNull(message = "Shop longitude is required")
    @DecimalMin(value = "-180", message = "Shop longitude must be between -180 and 180")
    @DecimalMax(value = "180", message = "Shop longitude must be between -180 and 180")
    private Double shopLongitude;

    @NotNull(message = "Weight is required")
    @Positive(message = "Weight must be positive")
    private Double weight;
}
