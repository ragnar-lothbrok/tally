package com.home.geeks;

//http://www.geeksforgeeks.org/print-all-n-digit-strictly-increasing-numbers/
public class IncreeasingNumbers {

	public static void main(String[] args) {
		incresingNumber("", 2, 0);
	}

	private static void incresingNumber(String out, int n, int i) {
		if (n == 0) {
			System.out.println(out);
			return;
		}
		for (int j = i; j <= 9; j++) {
			incresingNumber(out+""+j, n-1, i+1);
		}
	}
}
