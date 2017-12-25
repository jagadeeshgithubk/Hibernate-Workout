package com.java.core.designpatterns;

abstract public class TemplateDesignPattern {

	private SingleTonClass singleTonClass;
	void initialize(){
		System.out.println("common initialization");
	}
	abstract void execute();
	void closeResources(){
		System.out.println("common destroy");
	}
	
	public TemplateDesignPattern() {
		initialize();
		execute();
		closeResources();
	}
}
