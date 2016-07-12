package com.home.geeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://www.hackerearth.com/amazon-hiring-challenge-1/problems/5428d3f4b2044a4688b8db588899ccb6/
public class ChocLateIndex {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numOfBox = Integer.parseInt(br.readLine());
		String choc[] = br.readLine().split(" ");
		int chocCount[] = new int[numOfBox];
		for (int i = 0; i < choc.length; i++) {
			if (i == 0) {
				chocCount[i] = Integer.parseInt(choc[i]);
			} else {
				chocCount[i] = Integer.parseInt(choc[i]) + chocCount[i - 1];
			}
		}
		int numOfQ = Integer.parseInt(br.readLine());
		for (int i = 0; i < numOfQ; i++) {
			System.out.println(findBox(Integer.parseInt(br.readLine()), chocCount) + 1);
		}
	}

	private static int findBox(int num, int choc[]) {
		if (num > choc[choc.length - 1] || num <= 0) {
			return -2;
		}
		int low = 0, high = choc.length, mid = 0;
		while (low < high) {
			mid = (low + high) / 2;
			if ((choc[mid] <= num && (mid == choc.length - 1 || (choc[mid + 1] >= num && mid + 1 < choc.length))) || (mid == 0 && choc[mid] > num)) {
				if (mid == 0 && choc[mid] > num) {
					return mid;
				} else {
					if (num == choc[mid]) {
						return mid;
					} else {
						return mid + 1;
					}
				}
			} else if (choc[mid] > num) {
				high = mid;
			} else {
				low = mid;
			}
		}
		return -2;
	}
}
