package com.hackerrank.mphasis.cib;

import java.util.ArrayList;
import java.util.Stack;

public class Braces_BalancedBrackets_64 {

	public static void main(String[] args) {
		String[] balancedBrackerts = getBalancedBrackerts(new String[]{"{[()]}","{[(])}","{{[[(())]]}}"});
		for (String string : balancedBrackerts) {
			System.out.println(string);
		}
	}

	public static String[] getBalancedBrackerts(String[] input){
		String[] output = new String[input.length];
		for (int i=0;i<input.length;i++) {
			char[] charArray = input[i].toCharArray();
			String lastString = "";
			Stack<String> test = new Stack<>();
			for (char c : charArray) {
				if((lastString.equals("(") && new String(c+"").equals(")")) ||
						(lastString.equals("[") && new String(c+"").equals("]")) ||
						(lastString.equals("{") && new String(c+"").equals("}"))
						){
					test.pop();
					lastString = test.isEmpty()?"":test.peek();
				}
				else{
					test.push(c+"");
					lastString = test.peek();
				}
			}
			output[i] = test.isEmpty()?"YES":"NO";
		}
		return output;
	}
	
}
