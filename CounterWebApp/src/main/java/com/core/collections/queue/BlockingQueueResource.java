package com.core.collections.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueResource {
	BlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
	public void produce() throws InterruptedException{
		for(int i=0;i<10;i++){
			arrayBlockingQueue.put(""+i);
//			arrayBlockingQueue.add(""+i);
			System.out.println(Thread.currentThread().getName()+" is Adding an element:"+i);
		}
	}
	
	public void consume() throws InterruptedException{
		for(int i=0;i<10;i++){
			Thread.currentThread().sleep(2000);
			String take = arrayBlockingQueue.take();
			System.out.println(Thread.currentThread().getName()+" is removing an element:"+take);
		}
	}
}
