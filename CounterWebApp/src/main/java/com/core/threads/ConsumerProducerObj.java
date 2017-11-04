package com.core.threads;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ConsumerProducerObj {
	
	private static LinkedList<Integer> list = new LinkedList<>();
	
/*	static{
		for(int i=0;i<100;i++){
			list.add(i);
		}
	}
*/	
	public void produce() throws InterruptedException{
		while(true){
			synchronized (list) {
				System.out.println("Produced and waing for consumption");
				if(list.size()>0){
					list.notify();
				}
				list.add(0);
				System.out.println("added....");
				list.wait();
				System.out.println("Wait has finished");
			}
		}
	}

	public void consume() throws InterruptedException{
		Thread.sleep(3000);
		while(true){
			synchronized (list) {
				System.out.println("Consuming...");
				if(list.size()==0){
					list.wait();
				}
				Integer remove = list.removeFirst();
				System.out.println("removed...."+remove);
				list.notify();
				
			}
			System.out.println("List size:"+list.size());
			
			System.out.println("...................");
			Thread.sleep(5000);
		}
	}
}
