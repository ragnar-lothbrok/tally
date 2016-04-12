package com.he.capillary.chegg1;

import java.util.Random;
import java.util.Scanner;

public class SlotMachine {

	public static void main(String[] args) {

		char[] slots = new char[3];
		int total = 3;

		while (true) {
			if (total < 3) {
				System.out.println("No Money");
				break;
			} else {
				System.out.println("\nYou have $" + total);

				getRandSlots(slots);

				printSlots(slots);

				getWinnings(slots);

				System.out.println("\nYou won $" + getWinnings(slots));

				total += getWinnings(slots);

				if (playAgain()) {
					total--;
					continue;
				} else {
					break;
				}
			}
		}
	}

	public static void getRandSlots(char[] slots) {
		Random r = new Random();
		char[] symbols = { '\u2665', '\u2660', '\u2663', '\u2666' };
		for (int i = 0; i < slots.length; i++) {
			int dice = new Random().nextInt((4 - 1) + 1) + 1;
			slots[i] = symbols[dice % symbols.length];
		}
	}

	public static int getWinnings(char[] slots) {
		if (slots[0] == slots[1] && slots[1] == slots[2]) {
			return 10;
		} else if (slots[0] == slots[1] || slots[1] == slots[2] || slots[0] == slots[2]) {
			return 5;
		}
		return 0;
	}

	public static boolean playAgain() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nWould you like to pay $1 to play again?");
		char choice = sc.next().charAt(0);
		if (choice == 'y') {
			return true;
		} else {
			return false;
		}
	}

	public static void printSlots(char[] slots) {
		char a = '\u250c';
		char b = '\u2510';
		char c = '\u2514';
		char d = '\u2518';
		char e = '\u252c';
		char f = '\u2534';
		char g = '\u2500';
		char h = '\u2502';

		String i = g + "" + "" + g + "" + g;

		System.out.printf("\n%c%s%c%s%c%s%c \n %c%c%c%c%c%c%c\n%c%s%c%s%c%s%c\n", a, i, e, i, e, i, b, 
				h,slots[0], h, slots[1], h, slots[2],h
				, c, i, f, i, f, i, d);
	}
}
