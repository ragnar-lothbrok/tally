package com.home.geeks;

//http://www.geeksforgeeks.org/find-last-digit-of-ab-for-large-numbers/
public class LastDigitNumber {

	public static void main(String[] args) {
		findLastDigit(3, 10);
		findLastDigit(6, 2);
		findLastDigit(150, 53);
	}

	private static void findLastDigit(int number1, int number2) {
		int arr[] = new int[11];
		int mul = number1;
		for (int i = 1; i < arr.length; i++) {
			mul = i * number1;
			arr[i] = mul % 10;
		}
		System.out.println(arr[(number2 % 10 == 0 ? 10 : (number2 % 10))]);
	}
}
