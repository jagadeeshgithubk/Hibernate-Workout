package com.hackerrank.mphasis.cib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FindFirstRepeatingLetterInAString_69 {

	public static void main(String[] args) {
		String firstRepeatingLetterInAString = getFirstRepeatingLetterInAString("finding");
		System.out.println(firstRepeatingLetterInAString);
	}

	public static String getFirstRepeatingLetterInAString(String input) {
		String[] split = input.split("");
		Map<String, Integer> map = new LinkedHashMap<>();
		for (String string : split) {
			Integer integer = map.get(string);
			if (integer != null) {
				map.put(string, integer + 1);
			} else {
				map.put(string, 1);
			}
		}
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		List<Entry<String, Integer>> treeSet = new ArrayList<>();
		for (Entry<String, Integer> entry : entrySet) {
			treeSet.add(entry);
		}
		Collections.sort(treeSet, new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		String stringValue = "";
		Entry<String, Integer> entryToRetrieve = !treeSet.isEmpty() ? treeSet.get(0) : null;
		if(treeSet.size()==1)
			return entryToRetrieve.getKey();
		for (Entry<String, Integer> entry : treeSet) {
			if (entryToRetrieve == entry) {
				continue;
			}
			if (entryToRetrieve.getValue() == entry.getValue()) {
				stringValue = (input.lastIndexOf(entryToRetrieve.getKey()) > input.lastIndexOf(entry.getKey()))
						? entryToRetrieve.getKey() : entry.getKey();
			}
			else{
				return entryToRetrieve.getKey();
			}
		}
		return stringValue;
	}
}
