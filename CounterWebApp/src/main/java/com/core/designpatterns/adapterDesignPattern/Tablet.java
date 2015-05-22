package com.core.designpatterns.adapterDesignPattern;

public class Tablet implements ExternalDevice{

	@Override
	public void saveData(String data) {
		System.out.println("Saving the data to Tablet:"+data);
	}

}
