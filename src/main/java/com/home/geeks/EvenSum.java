package com.home.geeks;

//http://www.geeksforgeeks.org/find-number-subarrays-even-sum/

public class EvenSum {

	private static int count = 0;

	public static void main(String[] args) {
		int arr[] =  {1, 2, 2, 3, 4, 1} ;
		evenSumCount(arr, 0, 0);
		System.out.println(count);
	}

	private static void evenSumCount(int arr[], int index, int sum) {
		if (sum % 2 == 0 && sum != 0) {
			count++;
		}
		if (index >= arr.length) {
			return;
		}
		evenSumCount(arr, index + 1, sum + arr[index]);
		if (sum == 0)
			evenSumCount(arr, index + 1, sum);
	}
}
