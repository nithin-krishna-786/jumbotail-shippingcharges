package com.nithin.jumbotail_shippingcharges.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nithin.jumbotail_shippingcharges.dto.ShippingChargeRequest;
import com.nithin.jumbotail_shippingcharges.dto.ShippingChargeResponse;
import com.nithin.jumbotail_shippingcharges.service.ShippingChargeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/shipping-charge")
public class ShippingChargeController {

    @Autowired
    private ShippingChargeService shippingChargeService;

    @GetMapping("/{type}")
    public ResponseEntity<ShippingChargeResponse> calculateShippingCharge(
            @PathVariable String type,
            @Valid @RequestBody ShippingChargeRequest request) {

        double shippingCharge = shippingChargeService.calculateShippingCharge(type, request);

        return ResponseEntity.ok(new ShippingChargeResponse(shippingCharge));
    }
}