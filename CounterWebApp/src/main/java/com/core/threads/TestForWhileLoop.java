package com.core.threads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

import com.sun.xml.internal.bind.v2.runtime.reflect.ListIterator;

public class TestForWhileLoop {
	
	public static void main(String[] args) {
		int i=10;
		while(i!=0){
			i--;
		}
		System.out.println(i);
		List<Integer> asList = Arrays.asList(19,0,89,6,77);
		Stack<Object> stack = new Stack<>();
		Vector<Object> vector = new Vector<>();
		
		
		
		java.util.ListIterator<Integer> listIterator = asList.listIterator();
		int j=0;
		while(listIterator.hasNext()){
			j++;
			Integer next = listIterator.next();
			listIterator.remove();
			System.out.println(next);
		}
//		System.out.println(j);
//		System.out.println(i);
	}
	
	
	
	
}
