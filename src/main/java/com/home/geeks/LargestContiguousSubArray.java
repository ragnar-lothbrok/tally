package com.home.geeks;

public class LargestContiguousSubArray {

	public static void main(String[] args) {
		int arr[] = { 1, 56, 58, 57, 90, 92, 94, 93, 91,
				45 };/* {14, 12, 11, 20}; *//* { 10, 12, 11 }; */
		find(arr);
	}

	private static void find(int arr[]) {
		int min = -1, max = -1;
		int maxLength = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			min = arr[i];
			max = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				min = Math.min(arr[j], min);
				max = Math.max(arr[j], max);

				if (max - min == j - i) {
					if (maxLength < j - i) {
						maxLength = j - i + 1;
					}
				}
			}
		}
		System.out.println(maxLength);
	}
}
