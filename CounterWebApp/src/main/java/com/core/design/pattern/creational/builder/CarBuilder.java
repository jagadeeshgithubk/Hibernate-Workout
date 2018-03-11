package com.core.design.pattern.creational.builder;


//Since car object creatation involvs a lof of complexity, 
//that is passing in all the parameters which is not required to build
// a car
public class CarBuilder {

	private Engine engine;
	private Seats seats;
	private boolean airBags;
	private boolean soundsystem;
	private boolean automaticLocking;
	
	public CarBuilder() {
		
	}

	public CarBuilder setEngine(Engine engine) {
		this.engine = engine;
		return this;
	}

	public CarBuilder setSeats(Seats seats) {
		this.seats = seats;
		return this;
	}

	public CarBuilder setAirBags(boolean airBags) {
		this.airBags = airBags;
		return this;
	}

	public CarBuilder setSoundsystem(boolean soundsystem) {
		this.soundsystem = soundsystem;
		return this;
	}

	public CarBuilder setAutomaticLocking(boolean automaticLocking) {
		this.automaticLocking = automaticLocking;
		return this;
	}
	
	public Car build(){
		return new Car(engine, seats, airBags, soundsystem, automaticLocking);
	}

	@Override
	public String toString() {
		return "CarBuilder [engine=" + engine + ", seats=" + seats + ", airBags=" + airBags + ", soundsystem="
				+ soundsystem + ", automaticLocking=" + automaticLocking + "]";
	}
	
	
}
