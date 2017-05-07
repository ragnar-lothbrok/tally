package com.home.geeks;
//http://www.geeksforgeeks.org/lexicographically-previous-permutation-in-c/
public class PermutationLexicographically {

	public static void main(String[] args) {

		String str = "4321";

		int n = str.length();
		int i = n - 1;

		while (i > 0 && str.charAt(i - 1) <= str.charAt(i)) {
			i--;
		}
		if (i < 0) {
			System.out.println("Not exists.");
			return;
		}
		int j = i - 1;
		while (j <= n && str.charAt(j - 1) <= str.charAt(i - 1)) {
			j++;
		}

		StringBuilder sb = new StringBuilder(str);
		char ch = sb.charAt(i - 1);
		sb.setCharAt(i - 1, sb.charAt(j + 1));
		sb.setCharAt(j + 1, ch);

		System.out.println(sb.toString());

	}
}
