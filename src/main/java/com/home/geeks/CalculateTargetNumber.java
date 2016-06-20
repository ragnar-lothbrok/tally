package com.home.geeks;
//http://www.geeksforgeeks.org/number-of-ways-to-calculate-a-target-number-using-only-array-elements/
public class CalculateTargetNumber {

	public static void main(String[] args) {
		int arr[] = { -3, 1, 3, 5 };
		int sum = 6;
		findNumberOfWays(arr, 0, 0, sum);
		System.out.println(count);
	}

	private static int count = 0;

	private static void findNumberOfWays(int arr[], int index, int reducedSum, int sum) {
		if (reducedSum == sum) {
			count++;
			return;
		} else {
			if (index < arr.length) {
				findNumberOfWays(arr, index + 1, reducedSum - arr[index], sum);
				findNumberOfWays(arr, index + 1, reducedSum + arr[index], sum);
				findNumberOfWays(arr, index + 1, reducedSum, sum);
			}
		}
	}
}
