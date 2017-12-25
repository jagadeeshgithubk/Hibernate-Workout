package com.core.java;

public class StaticKeywordTest {


	
	public static void main(String args[]){
		
		System.out.println("main");
	}
	 static 
	 {
		 System.out.println(StaticKeywordTest.string+" "+StaticKeywordTest.integer);
	 }
	 final static String string="static";
	 final static int integer=1;
	 
}
