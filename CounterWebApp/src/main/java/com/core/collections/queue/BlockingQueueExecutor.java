package com.core.collections.queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import ch.qos.logback.core.net.SyslogOutputStream;

public class BlockingQueueExecutor {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		List<String> list = new ArrayList<>();
		list.add("123");
		list.add("456");
		list.add("789");
		System.out.println("tests");
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 10, 1000, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1));
		List<Future<String>> arrayList = new ArrayList<>();
		for(int i=0;i<10;i++){
			arrayList.add(threadPoolExecutor.submit(() -> {
				Thread.currentThread().sleep(5000);
				return Thread.currentThread().getName()+" : returned";
			}));
		}
		System.out.println("main flow");
		arrayList.forEach((Future<String> future) -> {
			try {
				System.out.println(future.get());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}

class Task implements Runnable{
	
	@Override
	public void run() {
		
	}
}
