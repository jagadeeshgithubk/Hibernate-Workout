package com.core.design.pattern.creational.builder;

public class Engine {

	private String enginePowerInBHP;
	private Integer mileage;
	
	public Engine(String enginePowerInBHP, Integer mileage) {
		super();
		this.enginePowerInBHP = enginePowerInBHP;
		this.mileage = mileage;
	}
	
	@Override
	public String toString() {
		return "Engine [enginePowerInBHP=" + enginePowerInBHP + ", mileage=" + mileage + "]";
	}
	
}
