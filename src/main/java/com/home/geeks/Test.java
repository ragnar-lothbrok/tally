package com.home.geeks;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Scanner;

import com.google.gson.JsonIOException;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

public class Test {

	void function() {
		String line;
		String yo = "";

		try (InputStream fis = new FileInputStream("readme.txt");
				InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
				BufferedReader br = new BufferedReader(isr);) {
			while ((line = br.readLine()) != null) {
				line = line.toLowerCase();
				yo = yo.toLowerCase();
				if (line.indexOf(yo) != -1) {
					System.out.print("Hello");
				}
				line = br.readLine();
			}
		} catch (IOException ex) {
		}
	}

	public static void main(String[] args) {
		int[][] a = new int[5][8];
		// initialize the 2-dimensional array with random number range(1~100)
		assignNestedArray(a);
		printNestedArray(a);
		int[] arr = new int[a.length * a[0].length];
		for (int i = 0, k = 0; i < a.length; ++i, k += a[i].length) {
			System.arraycopy(a[i], 0, arr, k, a[i].length);
		}

	}

	public static void printNestedArray(int[][] a) {
		for (int[] sub_arr : a) {
			for (int v : sub_arr)
				System.out.print(v + " ");
			System.out.println();
		}
	}

	public static void assignNestedArray(int[][] a) {
		for (int i = 0; i < a.length; ++i)
			for (int j = 0; j < a[i].length; ++j)
				a[i][j] = (int) (Math.random() * 100);
	}

	public static void main1(String[] args) throws Exception, JsonIOException, FileNotFoundException {

		// initialization
		Scanner key = new Scanner(System.in);
		final double COST_WINE = 13.99; // What is the size of the bottle of
										// wine?
										// ***********************************
		final double COST_BEER_6 = 11.99, COST_BEER_12 = 19.99, COST_BEER_24 = 34.99;
		final double spirits_750 = 25.99, spirits_1000 = 32.99;
		final double gst = 0.05; // confirm if this number is
									// right***************************************************
		final double deposit750 = 0.10, deposit1000 = 0.25;

		double wineSubTotal, wineTotal, total_cost;
		double beer_6_SubTotal, beer_6_Total;
		double beer_12_SubTotal, beer_12_Total;
		double beer_24_SubTotal, beer_24_Total;
		double spirits_750_SubTotal, spirits_750_Total;
		double spirits_1000_SubTotal, spirits_1000_Total;
		int wineQuantity, beer_6_Quantity, beer_12_Quantity;
		int beer_24_Quantity, spirits_750_Quantity, spirits_1000_Quantity;
		int beer_choice, spirits_choice;
		char choice;
		String input, again;

		// loop for fun
		for (int i = 0; i < 40; i++) {
			System.out.print("-");
		}
		System.out.printf("\n*** Welcome to Yoshi's Liquor Mart ***\n");
		System.out.printf("Today's date is \n"); // Reserved for
													// date***********************************************

		// another loop for fun
		for (int i = 0; i < 40; i++) {
			System.out.print("-");
		}

		// first actual loop, not for fun anymore

		do {
			System.out.printf("\nWine is $13.99" + "\nBeer 6 pack is $11.99\n" + "Beer 12 pack is $19.99\n" + "Beer 24 pack is $34.99\n"
					+ "Spirits 750 mL is $25.99\n" + "Spirits 1000 mL is $32.99\n" + "What is the item being purchased?\n"
					+ "W for Wine, B for Beer and S for Spirits, or X to quit: ");
			input = key.nextLine();
			choice = input.charAt(0);

			switch (choice) {
			case ('w'):
			case ('W'):
				System.out.printf("\nHow many bottles of wine is being purchased? ");
				wineQuantity = key.nextInt();
				wineSubTotal = wineQuantity * COST_WINE;
				wineTotal = (wineSubTotal * gst) + wineSubTotal + (deposit750 * wineQuantity);
				System.out.printf("\nThe cost of " + wineQuantity + " bottles of wine including GST and deposit is %.2f\n", wineTotal);
				break;
			case ('b'):
			case ('B'):
				System.out.printf("What is size of the beer pack?\n" + "6, 12 or 24?");
				beer_choice = key.nextInt();
				if (beer_choice == 6) {
					System.out.printf("\nHow many 6 pack of beer is being purchased?");
					beer_6_Quantity = key.nextInt();
					beer_6_SubTotal = beer_6_Quantity * COST_BEER_6;
					beer_6_Total = (beer_6_SubTotal * gst) + beer_6_SubTotal;
					System.out.printf("\nThe cost of %d cases of 6 pack of beer" + "including GST and deposit is %.2f\n", beer_6_Quantity,
							beer_6_Total);
				} else if (beer_choice == 12) {
					System.out.printf("How many 12 pack of beer is being purchased?");
					beer_12_Quantity = key.nextInt();
					beer_12_SubTotal = beer_12_Quantity * COST_BEER_12;
					beer_12_Total = (beer_12_SubTotal * gst) + beer_12_SubTotal;
					System.out.printf("\nThe cost of %d cases of 12 pack of beer" + "including GST and deposit is %.2f\n", beer_12_Quantity,
							beer_12_Total);
				} else if (beer_choice == 24) {
					System.out.printf("How many 24 pack of beer is being purchased?");
					beer_24_Quantity = key.nextInt();
					beer_24_SubTotal = beer_24_Quantity * COST_BEER_24;
					beer_24_Total = (beer_24_SubTotal * gst) + beer_24_SubTotal;
					System.out.printf("\nThe cost of %d cases of 24 pack of beer" + "including GST and deposit is %.2f\n", beer_24_Quantity,
							beer_24_Total);
				} else {
					System.out.println("Invalid number");
				}
				break;
			case ('s'):
			case ('S'):
				System.out.printf("What is size of Spirits?\n" + "750ml or 1000ml?");
				spirits_choice = key.nextInt();
				if (spirits_choice == 750) {
					System.out.printf("How many bottles are being purchased?");
					spirits_750_Quantity = key.nextInt();
					spirits_750_SubTotal = spirits_750_Quantity * spirits_750;
					spirits_750_Total = (spirits_750_SubTotal * gst) + spirits_750_SubTotal + (deposit750 * spirits_750_Quantity);
					System.out.printf("\nThe cost of %d bottle(s) of Spirits 750ml " + "including GST and deposit is %.2f\n", spirits_750_Quantity,
							spirits_750_Total);
				} else if (spirits_choice == 1000) {
					System.out.printf("How many bottles are being purchased?");
					spirits_1000_Quantity = key.nextInt();
					spirits_1000_SubTotal = spirits_1000_Quantity * spirits_1000;
					spirits_1000_Total = (spirits_1000_SubTotal * gst) + spirits_1000_SubTotal + (deposit1000 * spirits_1000_Quantity);
					System.out.printf("\nThe cost of %d bottle(s) of Spirits 1000ml " + "including GST and deposit is %.2f\n", spirits_1000_Quantity,
							spirits_1000_Total);
				} else {
					System.out.println("Invalid number");
				}
				break;
			case ('x'):
			case ('X'):

				break;
			default:
				System.out.printf("Invalid choice");
				break;

			}

			System.out.println("Is this customer's order complete? ");
			again = key.nextLine();
		} while (again.equals("n"));

		// Total cost

		/*
		 * total_cost = wineTotal + beer_6_Total + beer_12_Total + beer_24_Total
		 * + spirits_750_Total + spirits_1000_Total;
		 * 
		 * System.out.printf("The total cost for this customer is %f",
		 * total_cost);
		 */

		key.close(); // There was a warning message(not error), so I found out
						// on StackOverFlow that this would close the Scanner
	}
}
