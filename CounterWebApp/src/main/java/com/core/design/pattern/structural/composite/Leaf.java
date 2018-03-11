package com.core.design.pattern.structural.composite;

public class Leaf implements Component{

	private String name;
	private Long price;
	
	public Leaf(String name, Long price) {
		super();
		this.name = name;
		this.price = price;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Long getPrice() {
		return price;
	}

}
