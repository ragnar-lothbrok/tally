package com.home.geeks;
//http://www.geeksforgeeks.org/longest-common-increasing-subsequence-lcs-lis/
public class LongestCommonIncresingSubArray {

	public static void main(String[] args) {
		int arr1[] = { 1, 3, 4, 9 };
		int arr2[] = { 1, 5, 3, 8, 9, 10, 2 };
		getLongestCommonIncresingSubSequence(arr1, arr2);
	}

	private static void getLongestCommonIncresingSubSequence(int arr1[], int arr2[]) {
		int table[] = new int[arr2.length];
		int parent[] = new int[arr2.length];
		for (int i = 0; i < arr1.length; i++) {
			int current = 0;
			for (int j = 0; j < arr2.length; j++) {
				if (arr1[i] == arr2[j]) {
					if (current + 1 > table[j]) {
						table[j] = current + 1;
						parent[j] = arr2[j];
					}
				}

				if (arr1[i] > arr2[j]) {
					if (table[j] > current) {
						current = table[j];
						parent[j] = arr2[j];
					}
				}
			}
		}

		int max = 0;
		for (int i = 0; i < arr2.length; i++) {
			if (max < table[i]) {
				max = table[i];
			}
		}
		System.out.println(max);
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(parent[i] + " ");
		}

	}
}
