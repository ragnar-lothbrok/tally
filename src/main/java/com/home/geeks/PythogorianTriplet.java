package com.home.geeks;

import java.util.Arrays;

public class PythogorianTriplet {

	public static void main(String[] args) {
		// int arr[] = { 3, 1, 4, 6, 5 };

		int arr[] = { 10, 4, 6, 12, 8 };
		findPythogorianTriplets(arr);
	}

	public static void findPythogorianTriplets(int arr[]) {
		Arrays.sort(arr);

		for (int i = 0; i < arr.length; i++) {
			int l = i + 1;
			int r = arr.length - i - 1;

			while (l < r) {
				int left = arr[i] * arr[i] + arr[l] * arr[l];
				int right = arr[r] * arr[r];
				if (left < right) {
					left++;
				} else if (left > right) {
					right--;
				} else {
					System.out.println(arr[i] + " " + arr[l] + " " + arr[r]);
				}
				l++;
				r--;
			}

		}
	}
}
