package com.core.design.pattern.structural.adaptor;

public class AdaptorCaller {

	public static void main(String[] args) {
		IndianMobileCharger indianMobileCharger = () -> System.out.println("Charging Indian mobile");
//		IndianMobileSocket indianMobileSocket = new IndianMobileSocket(indianMobileCharger);
//		indianMobileSocket.chargeMobile();
//		
//		UsMobileSocket usMobileSocket = new UsMobileSocket(() -> System.out.println("Charging US mobile"));
//		usMobileSocket.chargeMobile();
//		
		AdaptorToChargeIndianMobileInUsSocket adaptorToChargeIndianMobileInUsSocket = new AdaptorToChargeIndianMobileInUsSocket(indianMobileCharger);
		UsMobileSocket usMobileSocket2 = new UsMobileSocket(adaptorToChargeIndianMobileInUsSocket);
		usMobileSocket2.chargeMobile();
		
		
;	}
}
