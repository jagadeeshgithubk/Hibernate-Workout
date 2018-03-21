package com.hackerrank.mphasis.cib;

import java.util.LinkedHashMap;
import java.util.Map;

public class CountDuplicates_63 {

	public static void main(String[] args) {
		System.out.println(countDuplicates(new int[]{1,2,3,3}));
	}
	
	public static int countDuplicates(int[] array){
		Map<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
		int duplicateCount = 0;
		for (int i : array) {
			Integer value = linkedHashMap.get(i);
			if(value != null){
				if(value==1){
					duplicateCount++;
				}
				linkedHashMap.put(i, value+1);
			}
			else{
				linkedHashMap.put(i,1);
			}
		}
		return duplicateCount;
	}
}
