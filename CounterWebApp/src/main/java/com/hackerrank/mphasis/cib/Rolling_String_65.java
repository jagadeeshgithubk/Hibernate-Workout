package com.hackerrank.mphasis.cib;

public class Rolling_String_65 {

	public static void main(String[] args) {
		String input = "bbc";
		String finalString = getRolledString(input);
		System.out.println(finalString);

	}

	private static String getRolledString(String input) {
		int startingIndex = 0;
		int endingIndex = 2;
		String direction = "R";
		int endIndexForModification = endingIndex + 1;
		char[] innerCharArray = input.substring(startingIndex, endIndexForModification).toCharArray();
		String innerCharArrayString = "";
		for (char c : innerCharArray) {
			int characterInInt = c;
			int valueBasedOnDirection = 0;
			if (direction.equalsIgnoreCase("L")) {
				if (c == 'a') {
					valueBasedOnDirection = 'z';
				} else {
					valueBasedOnDirection = characterInInt - 1;
				}
			} else {
				valueBasedOnDirection = characterInInt + 1;
			}
			innerCharArrayString += (char) valueBasedOnDirection;
		}
		String finalString = innerCharArrayString+input.substring(endIndexForModification);
		return finalString;
	}

}
