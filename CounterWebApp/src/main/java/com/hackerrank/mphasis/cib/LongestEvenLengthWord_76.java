package com.hackerrank.mphasis.cib;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class LongestEvenLengthWord_76 {

	public static void main(String[] args) {
		System.out.println(getLongestEvenLengthWord("You can do it the way you like"));
	}

	public static String getLongestEvenLengthWord(String input) {
		Map<Integer, String> treeMap = new TreeMap<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		if(!input.trim().isEmpty()){
			String[] split = input.split(" ");
			for (String string : split) {
				if (string.length() % 2 == 0) {
					String value = treeMap.get(string.length());
					if (value != null) {
						continue;
					}
					treeMap.put(string.length(), string);
				}
			}
		}
		return treeMap.isEmpty() ? "00" : treeMap.values().stream().findFirst().get();
	}

}
