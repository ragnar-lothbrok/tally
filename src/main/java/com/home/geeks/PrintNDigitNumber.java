package com.home.geeks;

//http://www.geeksforgeeks.org/print-all-n-digit-numbers-whose-sum-of-digits-equals-to-given-sum/
public class PrintNDigitNumber {

	public static void main(String[] args) {

		int sum = 6, digit = 3;
		generateNDigitNum(sum, digit, "");
	}

	private static void generateNDigitNum(int reducedSum, int digit, String out) {
		if (digit == 0 && reducedSum == 0) {
			System.out.println(out);
			return;
		} else if (digit == 0 && reducedSum != 0) {
			return;
		}
		for (int i = reducedSum; i >= 0; i--) {
			if (!(i == 0 && out.length() == 0)) {
				generateNDigitNum(reducedSum - i, digit - 1, out + "" + i);
			}
		}
	}
}
