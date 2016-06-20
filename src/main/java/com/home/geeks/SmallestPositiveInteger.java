package com.home.geeks;

public class SmallestPositiveInteger {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 4, 5 };
		findSmallest(arr);
	}

	private static void findSmallest(int arr[]) {
		int sum = 1;
		for (int i = 0; i < arr.length && arr[i] <= sum; i++) {
			sum += arr[i];
		}
		System.out.println(sum);
	}
}
