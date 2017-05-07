package com.he.capillary.chegg1;

import java.util.Scanner;

public class TestMenu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		testInput(sc);
	}

	public static void testInput(Scanner sc) {
		boolean flag = true;
		System.out.println("Enter number : ");
		int num = sc.nextInt();
		int var = 0;
		for (int i = 0; i < 4; i++) {
			System.out.println("Enter number : ");
			var = sc.nextInt();
			if (num < var) {
				flag = false;
			}
			num = var;
		}
		if (flag) {
			//when numbers are in decreasing order.
			System.out.println("yes");
		} else {
			//when numbers are not in decreasing order.
			System.out.println("no");
		}
	}
}
