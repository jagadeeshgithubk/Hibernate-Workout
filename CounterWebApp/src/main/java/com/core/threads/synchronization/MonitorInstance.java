package com.core.threads.synchronization;

public class MonitorInstance {

	private static Integer counter=0;
	
	public void increment(){
		counter++;
	}
	public Integer getCounter(){
		return counter;
	}
}
