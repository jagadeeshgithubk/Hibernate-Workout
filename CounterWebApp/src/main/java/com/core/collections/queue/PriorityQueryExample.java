package com.core.collections.queue;

import java.util.concurrent.PriorityBlockingQueue;

public class PriorityQueryExample {

	public static void main(String[] args) {
		PriorityBlockingQueue<PriorityQueueResource> priorityBlockingQueue = new PriorityBlockingQueue<>();
		priorityBlockingQueue.add(new PriorityQueueResource("Test",123));
		priorityBlockingQueue.add(new PriorityQueueResource("Ram",123));
		System.out.println(priorityBlockingQueue);
	}
	
}

class PriorityQueueResource implements Comparable<PriorityQueueResource>{
	private String name;
	private Integer number;
	public PriorityQueueResource(String name, Integer number) {
		super();
		this.name = name;
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public Integer getNumber() {
		return number;
	}
	@Override
	public int compareTo(PriorityQueueResource o) {
		return o.getName().compareTo(name);
	}
	@Override
	public String toString() {
		return this.getClass().getName()+":"+name;
	}
	
}
