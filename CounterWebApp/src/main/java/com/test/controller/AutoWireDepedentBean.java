package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;

public class AutoWireDepedentBean {

	private InnerBean1 innerBean1;
	
	public static final String name="testname";

	public InnerBean1 getInnerBean1() {
		return innerBean1;
	}

	public void setInnerBean1(InnerBean1 innerBean1) {
		this.innerBean1 = innerBean1;
	}
	
}

class InnerBean1{
	
	String stringValue;
	
	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}

	public String getTestInnnerBean1() {
		return stringValue;
	}
	
}