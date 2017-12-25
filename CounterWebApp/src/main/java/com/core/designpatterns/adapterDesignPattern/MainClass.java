package com.core.designpatterns.adapterDesignPattern;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class MainClass extends BaseClassBasic {

	public static void main(String args[]) throws IOException {
/*		System.out.println(".........Hey you pass some input..either..laptop/tablet....\n I AM Waiting....");
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
*/		
		
		String test="tedesfst";
		char[] charArray = test.toCharArray();
		Map<Character, Integer> linkedHashMap = new LinkedHashMap<>();
		
		for (char c : charArray) {
			if(linkedHashMap.get(c) != null){
				linkedHashMap.put(c, linkedHashMap.get(c)+1);
			}
			else{
				linkedHashMap.put(c, 1);
			}
		}
		Set<Character> keySet = linkedHashMap.keySet();
		Iterator<Character> iterator = keySet.iterator();
		
		
		for (Character character : keySet) {
			if(linkedHashMap.get(character)==1){
				System.out.println("first non repeatable character is:"+character);
				break;
			}
		}
		
		//fibnacso
		int pre=0;
		int curr=1;
		System.out.println(pre);
		System.out.println(curr);
		int n=13;
		for(int i=0;i<n;i++){
			if(i+curr>=n)
				break;
			if(i==0){
				System.out.println(pre+curr);
				continue;
			}
			System.out.println(i+curr);
			curr=i;
		}
		;
		//factorial using recusion
		System.out.println("fact of ..."+fact(4));
		
		//prime numbers
		for(int i=0;i<10;i++){
			int primeNumberOrNot=0;
			for(int j=1;j<i;j++){
				if(i%j==0){
					primeNumberOrNot++;
				}
			}
			if(primeNumberOrNot==1){
				System.out.println(i);
			}
		}
	}
	
	
	public static Integer fact(int fact){
		if(fact == 0){
			return 1;
		}
		else 
			return fact*=fact(fact-1);
	}
}


