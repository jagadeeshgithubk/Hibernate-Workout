package com.core.design.pattern.structural.adaptor;

public class UsMobileSocket {

	private UsMobileCharger usMobileCharger;

	public UsMobileSocket(UsMobileCharger usMobileCharger) {
		this.usMobileCharger = usMobileCharger;
	}

	public void chargeMobile() {
		usMobileCharger.chargeMobile();
	}

}
