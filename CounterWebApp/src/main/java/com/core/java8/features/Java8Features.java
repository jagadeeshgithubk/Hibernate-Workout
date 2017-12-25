package com.core.java8.features;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Java8Features {

	public static void main(String args[]){

		List<String> arrayList = new ArrayList<String>();
		arrayList.add("test1");
		arrayList.add("test2");
		arrayList.add("test3");
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
		
	}
	
}

class TestImpl{
	
}

interface TestFunctional{
	default void testFunctional(){
		System.out.println("Inside functional");
	}
	public void testNormal();
	
}