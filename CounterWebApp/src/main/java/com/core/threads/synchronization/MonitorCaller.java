package com.core.threads.synchronization;

public class MonitorCaller {
	public  void display(){
		MonitorInstance monitorInstance = new MonitorInstance();
		synchronized (MonitorInstance.class) {
			monitorInstance.increment();
			System.out.println(monitorInstance.getCounter());
		}
	}
	
}
