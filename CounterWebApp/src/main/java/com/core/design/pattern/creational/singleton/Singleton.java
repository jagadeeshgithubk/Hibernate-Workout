package com.core.design.pattern.creational.singleton;

public class Singleton {
	private static Singleton singleton;
	private Singleton() {
		// restriction object creation
	}
	public static Singleton getSingleTon(){
		if(singleton == null){
			synchronized (Singleton.class) {
				if(singleton == null){
					System.out.println(Thread.currentThread().getName()+" creating...");
					singleton = new Singleton();	
				}
			}
		}
		return singleton;
	}
	
}
