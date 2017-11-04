package com.core.threads.synchronization;

public class ThreadMainClass {

	public static void main(String[] args) {
		
		final MonitorCaller monitorCaller = new MonitorCaller();
			for(int i=0;i<10;i++){
				new Thread(new LocalThread(monitorCaller)).start();
		}
	}
}

class LocalThread implements Runnable{
	MonitorCaller monitorCaller;
	public LocalThread(MonitorCaller monitorCaller) {
		this.monitorCaller = monitorCaller;
	}
	@Override
	public void run() {
		monitorCaller.display();
	}
	
}