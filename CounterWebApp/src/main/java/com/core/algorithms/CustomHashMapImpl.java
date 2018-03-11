package com.core.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

class CustomMap<K, V> {

	
	
	
	
	static Integer capacity = 5;
	Entry<K, V>[] table = new Entry[capacity];
	
	static class Entry<K, V> {
		private Entry<K, V> next;
		private K key;
		private V value;

		public Entry(K key, V value, Entry<K, V> next) {
			this.next = next;
			this.key = key;
			this.value = value;
		}
	}

	public void put(K key, V value) {
		Map<K, V> linkedHashMap = new LinkedHashMap<K, V>();
		// get the bucket index
		Integer bucketIndex = getBucketIndex(key);
		// when we put the element for the first time
		if (table[bucketIndex] == null) {
			table[bucketIndex] = new Entry(key, value, null);
		} else {
			Entry<K, V> existingEnty = table[bucketIndex];
			// if key matches, no need to insert new one
			if (existingEnty.key.equals(key)) {
				return;
			} else {
				// Checking the existing element next value
				Entry<K, V> nextNode = existingEnty.next;
				// travers till the last element in that bucket
				while (nextNode != null) {
					existingEnty = nextNode;
					nextNode = nextNode.next;
				}
				nextNode = new Entry(key, value, null);
				existingEnty.next = nextNode;
			}
		}
	}

	public V get(K key){
		if(key == null){
			return null;
		}
		Integer bucketIndex = getBucketIndex(key);
		Entry<K, V> entry = table[bucketIndex];
		if(entry == null)
			return null;
		Entry<K, V>  next = entry.next;
		while(next!=null){
			if(next.key.equals(key))
				return next.value;
			next = next.next;
		}
		return entry.key.equals(key)?entry.value : null;
	}
	
	public V delete(K key){
		if(key == null)
			return null;
		Integer bucketIndex = getBucketIndex(key);
		Entry<K, V> entry = table[bucketIndex];
		if(entry == null)
			return null;
		Entry<K, V> next = entry;
		while(next!=null){
			if(next.key.equals(key)){
				table[bucketIndex]=table[bucketIndex].next;
				return next.value;
			}
			next = next.next;
		}
/*		if(entry.key.equals(key)){
			table[bucketIndex] = null;
			return entry.value;
		}
*/		
		return null;
	}
	
	private Integer getBucketIndex(K key) {
		return key.hashCode() % capacity;
	}

	@Override
	public String toString() {
		return table.toString();
	}
}

public class CustomHashMapImpl {
	
	
	public static int Cuckoo_Sequence(int input1){
		int output1=0;
		if(input1<3){
			throw new UnsupportedOperationException("COCO");
		}
		int decrement=input1-2;
		for(int i=1;i<input1;i++){
			output1+=i*decrement;
			decrement = decrement-1;
		}
		return output1+3*1;
	}
	public static void main(String args[]){		
		String srt= "";
		System.out.println(srt.isEmpty());
		System.out.println(Cuckoo_Sequence(4));
//		throw new UnsupportedOperationException("COCO");
	}
	
	
	public static void main2(String args[]) {
		CustomMap<Integer, Integer> customMap = new CustomMap<>();
		customMap.put(6, 123);
		customMap.put(11, 223);
		customMap.put(16, 223);
		System.out.println(customMap);
		
		System.out.println(customMap.get(55));
		System.out.println(customMap.delete(6));
		System.out.println(customMap);

		LinkedList<Integer> linkedList = new LinkedList<Integer>();

		Integer test = 549;
		List<Integer> arrayList = new ArrayList<Integer>();
		int currentModValue = test;
		while (currentModValue != 0) {
			arrayList.add(currentModValue % 10);

			currentModValue = currentModValue / 10;
		}
		Collections.sort(arrayList, (o1, o2) -> o2.compareTo(o1));

		System.out.println(arrayList);
	}

	public static void main1(String args[]) {
		int[] array = { 8, 6, 7, 9 };

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				if (array[i] < array[j]) {
					int t = array[i];
					array[i] = array[j];
					array[j] = t;
				}
			}
			for (int k : array) {
				System.out.println(k);
			}
		}
		Map<TestUnique, Integer> hashMap = new LinkedHashMap<TestUnique, Integer>();
		hashMap.put(new TestUnique("name1", 123), 1);
		hashMap.put(new TestUnique("name2", 456), 2);
		Set<TestUnique> keySet = hashMap.keySet();
		Iterator<TestUnique> iterator = keySet.iterator();
		while (iterator.hasNext()) {
			TestUnique next = iterator.next();

		}
		System.out.println("hash:" + hashMap);

	}

}

class TestUnique {
	private String name;
	private Integer number;

	public TestUnique(String name, Integer number) {
		super();
		this.name = name;
		this.number = number;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		return true;
	}
}