package com.core.java8.features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class Java8Features {

	
	public static void main1(String args[]){
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void main(String args[]) throws Exception{
		
		Map<String, String> map = new HashMap<>();
		
		List<String> arrayList = new ArrayList<String>();
//		arrayList.add("111");
//		arrayList.add("1");
//		arrayList.add("11");
		Consumer<String> action = new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		};
		arrayList.forEach(t->System.out.println(t));
		arrayList.stream().filter(new Predicate<String>() {

			@Override
			public boolean test(String t) {
				return !t.equalsIgnoreCase("test1");
			}
		}).forEach(t->System.out.println(t));;
		System.out.println(arrayList);
		
		List<Integer> collect = arrayList.stream().map(new Function<String, Integer>() {
			@Override
			public Integer apply(String t) {
				return new Integer(t);
			}
		}).collect(Collectors.toList());
		
		collect.forEach((Integer i) -> System.out.println(i));
		System.out.println(collect.stream().findFirst());
		
		long start = System.currentTimeMillis();
		System.out.println("Starting time: "+start);
		List<String> list = new ArrayList<>();
		for(int i=0;i<100;i++){
			list.add(((Integer)i).toString());
		}
		
		/*List<Integer> collect2 = list.parallelStream().map(i -> {
			int number = (int)Math.random()*10;
			return new Integer(i+number);
		}).collect(Collectors.toList());
		
		collect2.stream().forEach(i -> System.out.println(i));
		System.out.println("End time:"+(System.currentTimeMillis()-start)/1000);
		*/
		
		Collections.sort(list, (i1,i2) -> i2.compareTo(i1));
		list.forEach(i->System.out.println(i));
		
		list.stream().map(new TestImpl()::append).forEach(System.out::println);
		
		Thread thread = new Thread(() -> {
			try {
				Thread.currentThread().sleep(5000);
				System.out.println("******* Display ********");

			} catch (Exception e) {
				e.printStackTrace();
			}
			});
//		thread.setDaemon(true);
		thread.start();;
//		thread.join();
		System.out.println("Main is continued");
		
		Moniter moniter = new Moniter();
		Thread one = new Thread(()->{
			try {
				moniter.increment(true);
			} catch (Exception e) {
				e.printStackTrace();
			}	
		},"one_true");
		
		Thread two = new Thread(()->{
			try {
				moniter.increment(true);
			} catch (Exception e) {
				e.printStackTrace();
			}	
		},"two_true");

		Thread three = new Thread(()->{
			try {
				moniter.increment(false);
			} catch (Exception e) {
				e.printStackTrace();
			}	
		},"three_false");

		Thread four = new Thread(()->{
			try {
				moniter.increment(false);
			} catch (Exception e) {
				e.printStackTrace();
			}	
		},"four_false");
		one.start();
		two.start();
		three.start();
		four.start();
	}
}

class Moniter {
	private List<Integer> counter = new ArrayList<>();
	
	public void increment(boolean i) throws InterruptedException{
		synchronized (counter) {
//			if(i){
//				if(counter.size()>0){
					System.out.println("Flag: "+i+":"+Thread.currentThread().getName()+" is in waiting state");
					counter.wait();
					System.out.println("Flag: "+i+":"+Thread.currentThread().getName()+" wait is over");
//				}
				System.out.println("size before adding "+counter.size());
				counter.add(1);
				System.out.println("Flag: "+i+":"+Thread.currentThread().getName()+" notifing ");
//				counter.notify();
//			}
//			else{
//				if(counter.size()==0){
					System.out.println("Flag: "+i+":"+Thread.currentThread().getName()+" is in waiting state");
					counter.wait();
					System.out.println("Flag: "+i+":"+Thread.currentThread().getName()+" wait is over");
//				}
				System.out.println("size before removing "+counter.size());
				counter.remove(0);
				System.out.println("Flag: "+i+":"+Thread.currentThread().getName()+" notifing ");
//				counter.notify();
			}
//		}
	}
}

class TestImpl implements TestFunctional,TestFunctional2{
	public String append(String tests){
		return "TestImpl: "+tests;
	}

	@Override
	public void testFunctional() {
		// TODO Auto-generated method stub
		TestFunctional.super.testFunctional();
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}
}

class TestClassMultipleInterfaceConcept implements TestMultipleInterfaceConcept{

	@Override
	public void display() {
		
	}
	
}

interface TestMultipleInterfaceConcept extends TestFunctional, TestFunctional2{

	static void display1(){
		System.out.println("TestMultipleInterfaceConcept");
	}
	@Override
	default void testFunctional() {
		TestFunctional.super.testFunctional();
	}
	
}

@FunctionalInterface
interface TestFunctional{
	static void display1(){
		System.out.println("TestFunctional");
		
	}
	default void testFunctional(){
		System.out.println("Inside functional");
	}
	void display();
}

@FunctionalInterface
interface TestFunctional2{
	default void testFunctional(){
		System.out.println("Inside functional");
	}
	void display();
}


