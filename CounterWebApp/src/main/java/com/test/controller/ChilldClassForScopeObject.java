package com.test.controller;

import org.springframework.stereotype.Component;

public class ChilldClassForScopeObject {
	
	private String lastName1;
	private String lastName2;
	private String lastName3;
	
	public String getLastName1() {
		return lastName1;
	}
	public void setLastName1(String lastName1) {
		this.lastName1 = lastName1;
	}
	public String getLastName2() {
		return lastName2;
	}
	public void setLastName2(String lastName2) {
		this.lastName2 = lastName2;
	}
	public String getLastName3() {
		return lastName3;
	}
	public void setLastName3(String lastName3) {
		this.lastName3 = lastName3;
	}
	
}
