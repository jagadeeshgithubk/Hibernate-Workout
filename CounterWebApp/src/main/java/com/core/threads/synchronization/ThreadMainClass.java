package com.core.threads.synchronization;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class ThreadMainClass {

	public static void main(String[] args) {
		List<String> arrayList = new ArrayList<String>();
		Date currentDate = new Date();
		currentDate.setYear(9);
		System.out.println(currentDate);
		
		Integer integer = new Integer(9);
		System.out.println(integer);
		try{
			Collections.sort(test, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return 0;
				}
			});
		}
		catch(Exception e){
			
		}
		catch(SQLException | IOException | RuntimeException e){
			
		}
/*		final MonitorCaller monitorCaller = new MonitorCaller();
			for(int i=0;i<10;i++){
				new Thread(new LocalThread(monitorCaller)).start();
		}
*/	
	
	}
}

class LocalThread implements Runnable{
	MonitorCaller monitorCaller;
	public LocalThread(MonitorCaller monitorCaller) {
		this.monitorCaller = monitorCaller;
		A a= new B();
		a.test();
	}
	@Override
	public void run() {
		monitorCaller.display();
	}
	
}


class A {
	public void test() throws RuntimeException{
		
	}
}

class B extends A{
	public void test() throws Arithimetic{
		
	}
}