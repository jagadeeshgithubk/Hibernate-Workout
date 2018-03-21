package com.hackerrank.mphasis.cib;

public class DeletingSubstrings_74 {

	public static void main(String[] args) {
/*		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter string as input");
		String nextLine = scanner.nextLine();
		System.out.println(nextLine);
*/		
		String  s = "aabb";
		String t = "b";
		int count=0;
		
		while(s.contains(t)){
			s = s.replaceFirst(t, "");
			count++;
		}
		System.out.println(count);
	}
}
