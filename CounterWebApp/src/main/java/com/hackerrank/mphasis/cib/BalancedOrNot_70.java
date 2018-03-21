package com.hackerrank.mphasis.cib;

public class BalancedOrNot_70 {

	public static void main(String[] args) {
		System.out.println(getBalancedArray("<>>>>", 2));
	}
	
	public static int getBalancedArray(String input, int attempts){
		String finalStringToBeEvalued = "";
		String[] split = input.split("");
		String previousString = "";
		String remainingElements = "";
		int counter=0;
		for(int i=0;i<split.length;i++){
			if(counter>=attempts){
				remainingElements = input.substring(i);
				break;
			}
			String replace = split[i];
			if(previousString.equalsIgnoreCase(">") && replace.equalsIgnoreCase(">")){
				counter++;
				replace="<>";
			}
			finalStringToBeEvalued+=replace;
			previousString=split[i];
		}
		System.out.println(finalStringToBeEvalued+remainingElements);
		return (finalStringToBeEvalued+remainingElements).replaceAll("<>", "").trim().length()==0?1:0;
	}
}
