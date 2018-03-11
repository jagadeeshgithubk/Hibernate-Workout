package com.java.core.designpatterns;

import java.util.Collections;

public class SingleTonClass {

	private static SingleTonClass single = null;

	private SingleTonClass() {
		
	}

	public static SingleTonClass getSingleTon() {
		if (single == null) {
			return single = new SingleTonClass();
		} 
		return single;
	}

}