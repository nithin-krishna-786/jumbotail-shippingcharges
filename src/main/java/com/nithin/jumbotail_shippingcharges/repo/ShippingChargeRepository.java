package com.nithin.jumbotail_shippingcharges.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nithin.jumbotail_shippingcharges.entity.TransportMode;

@Repository
public interface ShippingChargeRepository extends JpaRepository<TransportMode, Long> {

    @Query("SELECT tm.ratePerKm FROM TransportMode tm WHERE tm.distance >= :distance")
    double getRatePerKm(@Param("distance") double distance);
}
