package com.hackerrank.mphasis.cib;

public class TwoStrings_66 {

	public static void main(String[] args) {
		String[] result = getResult(new String[]{"hello", "hi"},new String[]{"world", "bye"});
		for (String string : result) {
			System.out.println(string);
		}
	}
	
	public static String[] getResult(String[] str1, String[] str2){
		String[] resultString = new String[2];
		for(int i=0;i<str1.length;i++){
			String firstString = str1[i];
			String secondString = str2[i];
			String eachStringResult="NO";
			for (char eachLetter : secondString.toCharArray()) {
				if(firstString.contains(eachLetter+"")){
					eachStringResult="YES";
					break;
				}
			}
			resultString[i] = eachStringResult;
		}
		return resultString;
	}
}
