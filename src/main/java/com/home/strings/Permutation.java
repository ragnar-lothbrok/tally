package com.home.strings;

public class Permutation {

	private static String inputString = "abc";

	public static void main(String[] args) {
		findPermutation("",inputString);
	}

	private static void findPermutation(String prefix, String str) {
		int n = str.length();
		if (n == 0)
			System.out.println(prefix);
		else {
			for (int i = 0; i < n; i++)
				findPermutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
		}
	}

}
