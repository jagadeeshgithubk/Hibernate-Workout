package com.hackerrank.mphasis.cib;

import java.util.Set;
import java.util.TreeSet;

public class Build_The_Subsequences_71 {

	public static void main(String[] args) {
		String[] buildTheSubsequences = getBuildTheSubsequences("abc");
		for (String string : buildTheSubsequences) {
			System.out.println(string);
		}
	}
	
	public static String[] getBuildTheSubsequences(String input){
		if(input.trim().length()>0){
			Set<String> set = new TreeSet<>();
			String[] split = input.trim().split("");
			for(int i=0;i<split.length;i++){
				String firstString = input.substring(i, i+1);
				String completeString = input.substring(i);
				set.add(firstString);
				set.add(completeString);
				for(int j=i+1;j<split.length;j++){
					String mid = split[i]+""+split[j];
					set.add(mid);
				}
			}
			return set.toArray(new String[0]);
		}
		return new String[0];
	}
}
