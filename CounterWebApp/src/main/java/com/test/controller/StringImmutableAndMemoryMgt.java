package com.test.controller;

public class StringImmutableAndMemoryMgt {

	public static void main(String[] args) {
		TestClassForMemory originalState = new TestClassForMemory();
		originalState.setName("original state");
		changeObjectState(originalState);
		System.out.println(originalState.getName());
	}
	
	public static void changeObjectState(TestClassForMemory classForMemory){
		TestClassForMemory tempTestClass = classForMemory;
//		tempTestClass.setName("temp change");
//		classForMemory.setName("tampered state");
		classForMemory = new TestClassForMemory();
		classForMemory.setName("double tampered");
	}
}

class TestClassForMemory{
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}