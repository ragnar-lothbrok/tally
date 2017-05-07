package com.home.geeks;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		System.out.println(factorial(number));
	}

	private static int factorial(int number) {
		if (number <= 0) {
			return 1;
		}
		return number * factorial(number - 1);
	}

}
