package com.core.design.pattern.creational.builder;

public class CarBuildCaller {

	public static void main(String[] args) {
		CarBuilder carBuilder = new CarBuilder();
		carBuilder.setAirBags(true).setAutomaticLocking(true).
		setEngine(new Engine("900bhp", 50));
		Car build = carBuilder.build();
		System.out.println(build);
	}
}
