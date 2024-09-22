package com.nithin.jumbotail_shippingcharges.enums;

public enum Mode {
	AEROPLANE(1), TRUCK(2), MINIVAN(3);

	private final double ratePerKm;

	Mode(double ratePerKm) {
		this.ratePerKm = ratePerKm;
	}

	public double getRatePerKm() {
		return ratePerKm;
	}
}