package com.hackerrank.mphasis.cib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Pangrams_75 {

	public static void main(String[] args) {
		int pangram = isPangram("We promptly judged antique ivory buckles for the next prize");
		System.out.println(pangram);
	}
	
	public static int isPangram(String input){
		
		String[] stringArray = input.trim().split("");
		Arrays.sort(stringArray);
		List<String> arrayInputList = new ArrayList<>();
		for (String string : stringArray) {
			if(!string.trim().isEmpty() && !arrayInputList.contains(string)){
				arrayInputList.add(string.toLowerCase());
			}
		}
		String compareInput = "abcdefghijklmnopqrstuvwxyz";
		String[] comparedInputArray = compareInput.split("");
		List<String> comparedArrayList = Arrays.asList(comparedInputArray);
		return arrayInputList.containsAll(comparedArrayList)?1:0;
	}
}
