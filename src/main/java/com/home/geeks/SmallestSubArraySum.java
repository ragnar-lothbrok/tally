package com.home.geeks;

public class SmallestSubArraySum {

	public static void main(String[] args) {
		int arr[] = { 1, 11, 100, 1, 0, 200, 3, 2, 1,
				250 }/* {1, 4, 45, 6, 0, 19} */;
		int sum = 280;

		findLengthSubArray(arr, sum);
	}

	private static void findLengthSubArray(int[] arr, int sum) {
		int start = 0, end = 0, length = arr.length, currSum = 0, maxLength = arr.length;

		while (end < length) {
			if (currSum <= sum && end < length) {
				currSum += arr[end++];
			}

			if (currSum > sum && start < length) {
				if (maxLength > end - start) {
					maxLength = (end - start);
					System.out.println("Index " +start+" Index Max : "+end);
				}
				currSum -= arr[start++];
			}
		}

		System.out.println(maxLength);
	}

}
