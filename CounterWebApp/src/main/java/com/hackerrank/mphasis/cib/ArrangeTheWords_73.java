package com.hackerrank.mphasis.cib;

import java.util.Arrays;
import java.util.Comparator;

public class ArrangeTheWords_73 {

	public static void main(String[] args) {
		String arrangeTheWords = getArrangeTheWords("Here i come");
		System.out.println(arrangeTheWords);
	}
	public static String getArrangeTheWords(String input){
		String[] split = input.split(" ");
		Arrays.sort(split, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.trim().length()<o2.trim().length()){
					return -1;
				}
				else if(o1.trim().length()>o2.trim().length()){
					return 1;
				}
				else 
					return 0;
			}	
		});
		boolean firstToUpperCase=true;
		String finalString = "";
		for (String string : split) {
			if(firstToUpperCase){
				if(string.length()>0){
					char charAt = string.charAt(0);
					String lowerCaseString = ""+charAt;
					String replaceFirst = string.replaceFirst(lowerCaseString, lowerCaseString.toUpperCase());
					finalString+=replaceFirst;
				}
				firstToUpperCase = false;
			}
			else{
				finalString+=" "+string.toLowerCase();
			}
		}
		return finalString;
	}
}
