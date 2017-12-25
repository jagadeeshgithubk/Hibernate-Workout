package com.core.threads;

import java.util.LinkedHashMap;
import java.util.Map;

public class ThreadMainClass {

	public static void main(String args[]){
		int[] a = {7,8,9,1,2};
		for(int i=0;i<a.length;i++){
			for(int j=0;j<i;j++){
				if(a[i]<a[j]){
					int t=a[i];
					a[i]=a[j];
					a[j]=t;
				}
			}
		}
		int i=0;
		while(i<a.length){
			System.out.println(a[i]);
			i++;
		}
		
	}
	
	public static void main1(String args[]) throws InterruptedException{
		
		String str1="test1";
		String str2 = new String("test1");
		str1=str1+"dfd";
		System.out.println(str1==str2);
		System.out.println(str1);
		System.out.println(str1.hashCode()+":"+str2.hashCode());
		
		Thread1 thread1 = new Thread1();
		thread1.setName("The1:");
		Thread thread2 = new Thread(new Thread2(), "The2");
		thread2.start();
		thread2.join(0);
		thread1.start();
		thread1.join(0);

//		Thread.currentThread().join();
		System.out.println("I am at lastr");
/*		Map<Object, Object> hashMap = hashMap2;
		byte b = 0b1111;
		int i = (int)b;
		System.out.println(i);
*/		
		Map<TestHashCode, Integer> hashMap2 = new LinkedHashMap<>();
		hashMap2.put(new TestHashCode("test1", 123), 123);
		hashMap2.put(new TestHashCode("test2", 456), 123);
		hashMap2.put(new TestHashCode("test3", 789), 123);
		System.out.println(hashMap2);
		
	}
	
}
class Thread1 extends Thread{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		for(int i=0;i<1000;i++){
			System.out.println(i+"first");
		}
		
	}
}

class Thread2 implements Runnable{
	@Override
	public void run(){
			System.out.println(Thread.currentThread().getName());
			for(int i=0;i<1000;i++){
				System.out.println(i+"second");
			}
	}
}

class TestHashCode{
	String name;
	Integer number;
	public TestHashCode(String name, Integer number) {
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
	public int hashCode() {
		return 0;
	}
	@Override
	public boolean equals(Object obj) {
		return true;
	}
	
	 
}
