package com.core.designpatterns.adapterDesignPattern;

public class Laptop  implements ExternalDevice{

	@Override
	public void saveData(String data) {
		System.out.println("Saving the data from sd card to Laptop:"+data);
		
	}

}
