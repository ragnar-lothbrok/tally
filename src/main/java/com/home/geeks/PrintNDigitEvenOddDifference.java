package com.home.geeks;

//http://www.geeksforgeeks.org/print-all-n-digit-numbers-with-absolute-difference-between-sum-of-even-and-odd-digits-is-1/
public class PrintNDigitEvenOddDifference {

	public static void main(String[] args) {

		int n = 3;
		String out = "";

		for (int i = 1; i <= 9; i++) {
			out = i + "";
			generateNumbers(1, 0, i, out, n);
		}

	}

	private static void generateNumbers(int index, int evenSum, int oddSum, String out, int digits) {
		if (index == digits && Math.abs(evenSum - oddSum) == 1) {
			System.out.println(out);
			return;
		}
		if (index >= digits) {
			return;
		}
		for (int i = 0; i <= 9 && index <= digits; i++) {
			if (index % 2 != 0) {
				generateNumbers(index + 1, evenSum + i, oddSum, out + "" + i, digits);
			} else {
				generateNumbers(index + 1, evenSum, oddSum + i, out + "" + i, digits);
			}
		}
	}
}
