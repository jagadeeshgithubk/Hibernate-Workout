package com.core.design.pattern.creational.builder;

public class Seats {

	private String seatColor;
	private String type;
	public Seats(String seatColor, String type) {
		super();
		this.seatColor = seatColor;
		this.type = type;
	}
	@Override
	public String toString() {
		return "Seats [seatColor=" + seatColor + ", type=" + type + "]";
	}
	 
}
