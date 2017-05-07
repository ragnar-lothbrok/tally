package com.home.geeks;

public class ContiguousArrayDifference {

	public static void main(String[] args) {
		int arr[] = { -2, -3, -1, 4, -1, -2, 1, 5, -3 };
		diffContiguousSubArray(arr);
	}

	private static void diffContiguousSubArray(int arr[]) {
		int minSum = Integer.MAX_VALUE, maxSum = Integer.MIN_VALUE;
		int maxLength = 0;
		int min, max;

		for (int i = 0; i < arr.length - 1; i++) {
			min = arr[i];
			max = arr[i];

			for (int j = i + 1; j < arr.length; j++) {
				min = Math.min(arr[j], min);
				max = Math.max(arr[j], max);
				if (max - min == j - i) {
					if (maxLength < j - i + 1) {
						int sum = sum(arr, min, max);
						if (min > sum) {
							min = sum;
						}
						if (max < sum) {
							max = sum;
						}
					}
					System.out.println("Min Index : " + i + " Max Index : " + j);
				}
			}
		}
	}

	private static int sum(int arr[], int min, int max) {
		int sum = 0;
		for (int i = min; i <= max; i++) {
			sum += arr[i];
		}
		return sum;
	}
}
