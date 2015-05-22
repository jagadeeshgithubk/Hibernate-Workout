package com.core.designpatterns.adapterDesignPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.internal.runners.model.EachTestNotifier;

public class MainClass extends BaseClassBasic {

	public static void main(String args[]) throws IOException {
		System.out.println(".........Hey you pass some input..either..laptop/tablet....\n I AM Waiting....");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String readLine = bufferedReader.readLine();
		Adapter adapter = new Adapter(readLine);
		adapter.dataToBeRead();
		
		Integer[] testArray = {90,78,23,80,89};
		for(int i=0;i<testArray.length;i++){
			for(int j=0;j<i;j++){
				if(testArray[i]<testArray[j]){
					int temp=testArray[i];
					testArray[i]=testArray[j];
					testArray[j]=temp;
				}
			}
		}
		for(Integer integer: testArray){
			System.out.println(integer);
		}
	}
}
