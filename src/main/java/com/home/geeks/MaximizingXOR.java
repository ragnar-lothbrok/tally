package com.home.geeks;

import java.math.BigInteger;
import java.util.Scanner;

public class MaximizingXOR {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		BigInteger temp =new BigInteger(line);
		boolean isLouise = true;
		while(temp.intValue() != 1){
			
		}
		System.out.println(new BigInteger(line).toString());
	}

	private static void maxOR(Scanner scanner) {
		int lower = scanner.nextInt();
		int higher = scanner.nextInt();

		int max = 0;
		for (int i = lower; i <= higher; i++) {
			for (int j = i; j <= higher; j++) {
				int value = i ^ j;
				if (max < value) {
					max = value;
				}
			}
		}
		System.out.println(max);
	}

}
