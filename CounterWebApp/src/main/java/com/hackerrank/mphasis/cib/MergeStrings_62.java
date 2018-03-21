package com.hackerrank.mphasis.cib;

public class MergeStrings_62 {
	
	public static void main(String[] args) {
		MergeStrings_62 mergeStrings = new MergeStrings_62();
		System.out.println(mergeStrings.mergeGivenStrings("abc","xyz"));
	}
	
	public String mergeGivenStrings(String one, String two){
		String partOne = "";
		char[] oneCharArray = one.toCharArray();
		char[] twoCharArray = two.toCharArray();
		int i=0;
		for(;i<oneCharArray.length;i++){
			partOne+=(oneCharArray[i]+""+twoCharArray[i]+"");
		}
		String partTwo = two.substring(i++);
		return partOne+partTwo;
	}
	
}
