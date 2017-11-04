package com.core.threads.consumerproducer;

public class ConsumerProducesMainClass {

	public static void main(String[] args) {
		final ConProdResource conProdResource = new ConProdResource();
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					conProdResource.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					conProdResource.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

	}
	
}
