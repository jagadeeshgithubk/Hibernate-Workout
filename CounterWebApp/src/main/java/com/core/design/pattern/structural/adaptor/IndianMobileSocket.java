package com.core.design.pattern.structural.adaptor;

public class IndianMobileSocket {

	private IndianMobileCharger indianMobileCharger;

	public IndianMobileSocket(IndianMobileCharger indianMobileCharger) {
		this.indianMobileCharger = indianMobileCharger;
	}

	public void chargeMobile() {
		indianMobileCharger.chargeMobile();
	}

}
