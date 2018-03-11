package com.core.design.pattern.creational.builder;

public class Car {

	private Engine engine;
	private Seats seats;
	private boolean airBags;
	private boolean soundsystem;
	private boolean automaticLocking;
	public Car(Engine engine, Seats seats, boolean airBags, boolean soundsystem, boolean automaticLocking) {
		super();
		this.engine = engine;
		this.seats = seats;
		this.airBags = airBags;
		this.soundsystem = soundsystem;
		this.automaticLocking = automaticLocking;
	}
	public Engine getEngine() {
		return engine;
	}
	public Seats getSeats() {
		return seats;
	}
	public boolean isAirBags() {
		return airBags;
	}
	public boolean isSoundsystem() {
		return soundsystem;
	}
	public boolean isAutomaticLocking() {
		return automaticLocking;
	}
	@Override
	public String toString() {
		return "Car [engine=" + engine + ", seats=" + seats + ", airBags=" + airBags + ", soundsystem=" + soundsystem
				+ ", automaticLocking=" + automaticLocking + "]";
	}
	
}
