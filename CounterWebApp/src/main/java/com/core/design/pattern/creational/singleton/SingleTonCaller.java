package com.core.design.pattern.creational.singleton;

public class SingleTonCaller {

	public static void main(String[] args) {
		/*Singleton singleTon2 = Singleton.getSingleTon();
		Singleton singleTon = Singleton.getSingleTon();
		
		System.out.println(singleTon2 == singleTon);
*/
		Runnable target = () -> {
			Singleton singleTon = Singleton.getSingleTon();
			System.out.println(singleTon);
			};
		new Thread(target,"t1").start();
		new Thread(target,"t2").start();
	}
}
