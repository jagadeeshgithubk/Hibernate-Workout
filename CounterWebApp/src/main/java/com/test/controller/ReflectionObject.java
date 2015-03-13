package com.test.controller;

public class ReflectionObject {
	
	public ReflectionObject(Integer integer) {
		
	}

	@CustomAnnotation
	public void display(Integer value){
		System.out.println("displaying vlaue:"+value);
	}

	@CustomAnnotation
	private void display(String value){
		System.out.println("displaying vlaue:"+value);
	}
}
