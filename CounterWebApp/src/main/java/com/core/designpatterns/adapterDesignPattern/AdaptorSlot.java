package com.core.designpatterns.adapterDesignPattern;


public class AdaptorSlot implements SdCard{

	ExternalDevice laptop;

	AdaptorSlot(String readDataFrom){
		laptop = (ExternalDevice) (readDataFrom.equalsIgnoreCase("Laptop")?new Laptop():new Tablet());
	}
	@Override
	public void dataToBeRead() {
		String sdCardData = "sample data";
		laptop.saveData(sdCardData);
	}
}
