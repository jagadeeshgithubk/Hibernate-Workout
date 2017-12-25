package com.java.core.designpatterns;

public class FacadeDesignPattern{

	private QaTest qaTest;
	private DeveloperTest deleloperTest;
	public FacadeDesignPattern() {
		qaTest = new QaTest();
		deleloperTest = new DeveloperTest();
	}
	
	public void executeMethod(String input){
		if(input.equals("Qa")){
			qaTest.execute();	
		}
		else{
			deleloperTest.execute();
		}
	}
}
