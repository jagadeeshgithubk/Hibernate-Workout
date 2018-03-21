package com.hackerrank.mphasis.cib;

public class LastAndSecondLast_72 {

	public static void main(String[] args) {
		String lastAndSecondLast = getLastAndSecondLast("HACK");
		System.out.println(lastAndSecondLast);
	}
	public static String getLastAndSecondLast(String input){
		String resultString = "";
		String[] split = input.split("");
		int index=0;
		for (int i=split.length-1;i>=0;i--) {
			if(index>=2){
				break;
			}
			if(resultString.length()>0){
				resultString+=" ";
			}
			resultString+=split[i];
			index++;
		}
		return resultString;
	}
}
