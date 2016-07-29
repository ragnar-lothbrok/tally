package com.home.geeks;

//http://www.geeksforgeeks.org/largest-product-subarray-size-k/
public class SmallestSubArray {

	public static void main(String[] args) {
		int arr[] = { 1, 5, 9, 8, 2, 4, 1, 8, 1, 2 };
		getMaximumProduct(arr, 6);
	}

	private static void getMaximumProduct(int arr[], int k) {
		int maxProduct = 1;
		for (int i = 0; i < k; i++) {
			maxProduct *= arr[i];
		}

		int currProduct = maxProduct;

		for (int i = k; i < arr.length; i++) {
			currProduct = (maxProduct / arr[i - k]) * arr[i];
			maxProduct = Math.max(currProduct, maxProduct);
		}

		System.out.println(maxProduct);
	}
}
