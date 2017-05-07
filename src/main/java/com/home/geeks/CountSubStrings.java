package com.home.geeks;

//http://www.geeksforgeeks.org/find-number-times-string-occurs-given-string/
public class CountSubStrings {

	public static void main(String[] args) {
		String a = "GeeksforGeeks";
		String b = "Gee";

		countSubStrings(0, 0, b, a);
		System.out.println(count);
		dynamicProgramming(b, a);
	}

	static int count = 0;

	private static void countSubStrings(int subStart, int start, String pattern, String inputString) {
		if (start == inputString.length()) {
			return;
		} else if (subStart == pattern.length() - 1 && pattern.charAt(subStart) == inputString.charAt(start)) {
			count++;
		}
		if (subStart < pattern.length() && pattern.charAt(subStart) == inputString.charAt(start)) {
			countSubStrings(subStart + 1, start + 1, pattern, inputString);
		}
		countSubStrings(subStart, start + 1, pattern, inputString);
	}

	private static void dynamicProgramming(String pattern, String inputString) {

		int patternLength = pattern.length();
		int inputLength = inputString.length();

		int mat[][] = new int[inputLength + 1][patternLength + 1];

		for (int i = 0; i < inputLength + 1; i++) {
			mat[i][0] = 1;
		}

		for (int i = 1; i < inputLength + 1; i++) {
			for (int j = 1; j < patternLength + 1; j++) {

				if (inputString.charAt(i - 1) == pattern.charAt(j - 1)) {
					mat[i][j] = mat[i - 1][j - 1] + mat[i - 1][j];
				} else {
					mat[i][j] = mat[i - 1][j];
				}

			}
		}

		System.out.println(mat[inputLength][patternLength]);

	}
}
