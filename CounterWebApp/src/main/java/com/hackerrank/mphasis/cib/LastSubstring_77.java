package com.hackerrank.mphasis.cib;

public class LastSubstring_77 {

	public static void main(String[] args) {
		System.out.println(getLastSubString("aaa"));
	}

	public static String getLastSubString(String input) {
		char[] charArray = input.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			for (int j = 0; j < i; j++) {
				if (charArray[i] < charArray[j]) {
					char t = charArray[i];
					charArray[i] = charArray[j];
					charArray[j] = t;
				}
			}
		}
		int minLimit = charArray.length-1;
		if(minLimit>0){
			return input.substring(input.indexOf(charArray[minLimit]));
		}
		return null;
	}
	
}
