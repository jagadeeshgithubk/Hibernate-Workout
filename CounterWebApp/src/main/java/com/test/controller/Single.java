package com.test.controller;

public class Single {

	public static Single single;
	private Single() {
		
	}
	public static Single getSingle(){
		if(single==null){
			System.out.println("......in.....");
			single = new Single();
		}
		return single;
	}
}
