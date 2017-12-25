package com.java.core.designpatterns;

final public class ImmutableClass {

	private final Integer integer;
	
	private ImmutableClass(Integer number) {
		this.integer = number;
	}
	
	public static ImmutableClass getInstance(Integer integer){
		integer = new Integer(integer);
		return new ImmutableClass(integer);
	}

	public Integer getInteger() {
		return integer;
	}
	
}

