package com.core.threads;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

public class ConsumerProducerForNumbers {
	
	private static LinkedList<Integer> list = new LinkedList<>();
	private static Integer i=0;
/*	static{
		for(int i=0;i<100;i++){
			list.add(i);
		}
	}
*/	
	public void produce() throws InterruptedException{
		while(true){
			synchronized (this) {
				i++;
				System.out.println(Thread.currentThread().getName()+":"+i);
				i.wait();
//				System.out.println("Wait has finished");
			}
		}
	}

	public void consume() throws InterruptedException{
		Thread.sleep(3000);
		while(true){
			synchronized (this) {
				i++;
				System.out.println(Thread.currentThread().getName()+":"+i);
				i.notify();
				
			}
//			System.out.println("List size:"+list.size());
			
			System.out.println("...................");
			Thread.sleep(5000);
		}
	}
}
