package com.core.designpatterns.adapterDesignPattern;

public class Adapter implements SdCard {

	AdaptorSlot adapterSlot;
	private String inputDeviceToGo;
	
	public Adapter(String inputDeviceToGo) {
		this.inputDeviceToGo = inputDeviceToGo;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void dataToBeRead() {
		adapterSlot = new AdaptorSlot(inputDeviceToGo);
		adapterSlot.dataToBeRead();
	}
}
