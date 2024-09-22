package com.nithin.jumbotail_shippingcharges.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nithin.jumbotail_shippingcharges.dto.ShippingChargeRequest;
import com.nithin.jumbotail_shippingcharges.entity.TransportMode;
import com.nithin.jumbotail_shippingcharges.enums.Mode;
import com.nithin.jumbotail_shippingcharges.repo.ShippingChargeRepository;

@Service
public class ShippingChargeService {

    @Autowired 
    private ShippingChargeRepository shippingChargeRepository;

    public double calculateShippingCharge(String type, ShippingChargeRequest request) {
        double distance = calculateDistance(
                request.getWarehouseLatitude(),
                request.getWarehouseLongitude(),
                request.getShopLatitude(),
                request.getShopLongitude()
        );

        double shippingCharge = 0;

        if (type.equalsIgnoreCase("STANDARD")) {
            shippingCharge = calculateStandardShippingCharge(distance, request.getWeight());
        } else if (type.equalsIgnoreCase("EXPRESS")) {
            shippingCharge = calculateExpressShippingCharge(distance, request.getWeight());
        }

        return shippingCharge;
    }
    
    private double calculateStandardShippingCharge(double distance, double weight) {
        // Base charge for standard delivery
        double baseCharge = 10;

        // Transportation charge based on distance and weight
        double transportationCharge = calculateTransportationCharge(distance, weight);

        return baseCharge + transportationCharge;
    }

    private double calculateExpressShippingCharge(double distance, double weight) {
        // Base charge for express delivery
        double baseCharge = 10;

        // Express charge per kg
        double expressChargePerKg = 1.2;

        // Transportation charge based on distance and weight
        double transportationCharge = calculateTransportationCharge(distance, weight);

        return baseCharge + (expressChargePerKg * weight) + transportationCharge;
    }
    
    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Earth's radius in kilometers
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c;
        return distance;
    }
    
    private double calculateTransportationCharge(double distance, double weight) {
        // Determine transport mode based on distance
        Mode transportMode = getTransportMode(distance);

        // Calculate transportation charge based on transport mode and weight
        return transportMode.getRatePerKm() * distance * weight;
    }

    private Mode getTransportMode(double distance) {
        // Determine transport mode based on distance
        if (distance >= 500) {
            return Mode.AEROPLANE;
        } else if (distance >= 100) {
            return Mode.TRUCK;
        } else {
            return Mode.MINIVAN;
        }
    }
    
    
    
    // Other methods (calculateStandardShippingCharge, calculateExpressShippingCharge, etc.)
}