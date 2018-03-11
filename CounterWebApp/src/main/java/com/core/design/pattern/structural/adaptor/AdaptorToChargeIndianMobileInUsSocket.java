package com.core.design.pattern.structural.adaptor;

public class AdaptorToChargeIndianMobileInUsSocket implements UsMobileCharger{
	
	private IndianMobileCharger indianMobileCharger;

	public AdaptorToChargeIndianMobileInUsSocket(IndianMobileCharger indianMobileCharger) {
		this.indianMobileCharger = indianMobileCharger;
	}

	@Override
	public void chargeMobile() {
		indianMobileCharger.chargeMobile();
	}
	
}
