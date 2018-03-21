package com.hackerrank.mphasis.cib;

import java.util.Arrays;

public class RearrangingAWord_68 {

	public static void main(String[] args) {
		System.out.println(biggerIsGreater("dkhc"));
		
	}
	static String biggerIsGreater(String w) {
		char[] charArray = w.toCharArray();
		   // we need to replace some char from right with some on the left which is smaller than right char
        int len = charArray.length;
        
        for (int i = len - 2; i > -1; i--) {
            int swapIndex = -1;
            
            for (int j = i+1; j < len; j++) {
                
                if (charArray[j] > charArray[i] ) {
                    if (swapIndex > -1 && charArray[j] < charArray[swapIndex]) {
                        swapIndex = j;
                    }
                    else if (swapIndex < 0){
                        swapIndex = j;
                    }
                    
                }
            }
            
            if (swapIndex > i) {
                char t = charArray[swapIndex];
                charArray[swapIndex] = charArray[i];
                charArray[i] = t;
                
                Arrays.sort(charArray, i+1, len);
                return new String(charArray);
            }
        }
         
        return "no answer";
	}
}
