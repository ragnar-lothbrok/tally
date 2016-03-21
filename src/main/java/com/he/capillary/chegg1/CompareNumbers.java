package com.he.capillary.chegg1;

import java.util.Scanner;

public class CompareNumbers {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter numbers : ");

		String line = scanner.nextLine();
		String str[] = line.split(" ");

		double firstNum = Double.parseDouble(str[0]);

		double secondNum = Double.parseDouble(str[1]);

		int num = Integer.parseInt(str[2]);

		long tempFirst = (long) (firstNum * Math.pow(10, num));
		long tempSecond = (long) (secondNum * Math.pow(10, num));

		if (tempFirst == tempSecond) {
			System.out.printf("%.10f", Math.abs(firstNum - secondNum));
			System.out.print(" , Numbers are equal to " + num + " decimal places\n");
		} else {
			System.out.printf("%.10f", Math.abs(firstNum - secondNum));
			System.out.print(" , Numbers are not equal to " + num + " decimal places\n");
		}
	}
}
