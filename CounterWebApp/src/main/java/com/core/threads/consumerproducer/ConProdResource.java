package com.core.threads.consumerproducer;

import java.util.ArrayList;
import java.util.List;

public class ConProdResource {

	private List<Integer> sourceInput = new ArrayList<>();
	private List<Integer> destination = new ArrayList<>();
	
	public void produce() throws InterruptedException{
		int i=0;
		while(destination.size()<10){
			synchronized (sourceInput) {
				if(sourceInput.size()>0){
					System.out.println("Producer is waiting for consumer to consume an element");
					sourceInput.wait();
				}
				sourceInput.add(i);
				System.out.println("Produced element :"+i);
				sourceInput.notify();
				System.out.println("Prod after notify is called");
				i++;
			}
		}
	}
	
	public void consume() throws InterruptedException{
		Thread.currentThread().sleep(3000);
		while(destination.size()<10){
			synchronized (sourceInput) {
				if(sourceInput.size()==0){
					System.out.println("Consumer is waiting for producer to produce an element");
					sourceInput.wait();
				}
				if(sourceInput.size()>0){
					Integer integer = sourceInput.get(0);
					System.out.println("Consumed element :"+integer);
					destination.add(integer);
					sourceInput.remove(integer);
				}
				System.out.println("consumer consumed and notify prod for further elements");
				sourceInput.notify();
				Thread.currentThread().sleep(3000);
			}
		}
		System.out.println("source elements...");
		System.out.println(sourceInput);
		System.out.println("Destination elements...");
		System.out.println(destination);
	}
	
}
