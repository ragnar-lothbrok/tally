package com.home.geeks;

//http://www.geeksforgeeks.org/dynamic-programming-set-14-maximum-sum-increasing-subsequence/
public class MaximumSumLongestIncresing {

	public static void main(String[] args) {
		int arr[] = { 1, 101, 2, 3, 100, 4, 5 };
		findMaximumSum(arr);
	}

	private static void findMaximumSum(int arr[]) {
		int path[] = new int[arr.length];
		int sum[] = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			sum[i] = arr[i];
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && sum[i] < sum[j] + arr[i]) {
					sum[i] = sum[j] + arr[i];
					path[i] = j;
				}
			}
		}

		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (max < sum[i]) {
				max = sum[i];
			}
		}

		System.out.println(max);
	}
}
