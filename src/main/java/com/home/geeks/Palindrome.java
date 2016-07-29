package com.home.geeks;
//http://www.geeksforgeeks.org/dynamic-programming-set-28-minimum-insertions-to-form-a-palindrome/
public class Palindrome {

	public static void main(String[] args) {
		String str = "geeks";
		System.out.println(findMinimalString(str, str.length() - 1, 0));
	}

	public static int findMinimalString(String str, int h, int l) {
		if (l > h)
			return Integer.MAX_VALUE;
		if (l == h)
			return 0;
		if (l == h - 1)
			return (str.charAt(l) == str.charAt(h)) ? 0 : 1;
		return (str.charAt(l) == str.charAt(h) ? findMinimalString(str, h - 1, l + 1)
				: (Math.min(findMinimalString(str, h - 1, l), findMinimalString(str, h, l + 1)) + 1));
	}
	
	public void findMinimumDynamicPrograming(String str){
		int table[][] = new int[str.length()][str.length()];
		
	}
}
