package com.hackerrank.mphasis.cib;

public class AmazingStrings_67_incomplete {

	public static void main(String[] args) {
		int result = getResult("abaaaba");
		System.out.println(result);
	}
	
	public static int getResult(String input){
		String[] charArray = input.split("");
		int count=0;
		String previous = "";
		String next ="";
		for(int i=0;i<charArray.length;i++){
			if(i+1<charArray.length){
				next = charArray[i+1];
			}
			if(i>=1){
				if(previous.equalsIgnoreCase(charArray[i])){
					charArray[i]=""+9;
					count++;
				}
			}
			previous=charArray[i];
		}
		return count;
	}
}
