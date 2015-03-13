package com.test.controller;

import java.util.Map;

public class TestEnumInjector {
	
	private TestEnum enum1;
	private Map<TestEnum, String> linkedHashMap; 
	
	public TestEnumInjector(Map<TestEnum, String> linkedHashMap) {
		// TODO Auto-generated constructor stub
		this.linkedHashMap = linkedHashMap;
	}
	
	public Map<TestEnum, String> getTestEnum(){
		return linkedHashMap;
	}
}
