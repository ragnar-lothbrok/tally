package com.home.geeks;

//http://www.geeksforgeeks.org/dynamic-programming-set-28-minimum-insertions-to-form-a-palindrome/
public class Palindrome {

	public static void main(String[] args) {
		System.out.println(cramble("ijkl"));
//		String str = "geeks";
//		System.out.println(findMinimalString(str, str.length() - 1, 0));
	}

	static int cramble(String str) {
		int size = str.length();
		int count = 0;
		for (int i = 0, j = size - 1; i < j; ++i, --j) {
			if (str.charAt(i) != str.charAt(j)) {
				count += Math.abs(str.charAt(i) - str.charAt(j));
			}
		}
		return count;
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

	public void findMinimumDynamicPrograming(String str) {
		int table[][] = new int[str.length()][str.length()];

	}
}
