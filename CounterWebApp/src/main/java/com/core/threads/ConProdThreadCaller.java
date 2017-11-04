package com.core.threads;

public class ConProdThreadCaller {

	
	public static void main(String args[]) throws InterruptedException{
		final ConsumerProducerForNumbers consumerProducerObj = new ConsumerProducerForNumbers();
		Thread producerThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					
					consumerProducerObj.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread consumerThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					consumerProducerObj.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		producerThread.start();
		consumerThread.start();
		producerThread.join();
		consumerThread.join();
	}
}
