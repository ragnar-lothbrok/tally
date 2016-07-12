package com.home.geeks;

import java.util.HashMap;
import java.util.Map;
//http://www.geeksforgeeks.org/find-subarray-with-given-sum-in-array-of-integers/
public class SubArrayGivenSum {

	public static void main(String[] args) {
		int arr[] = /* { 1, 4, 20, 3, 10, 5 } */ { 10, 2, -2, -20, 10 };
		findArray(arr, -10);
	}

	private static void findArray(int arr[], int sum) {
		int currSum = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			currSum += arr[i];
			if (currSum == sum) {
				System.out.println("Start Index : " + (0) + " End Index : " + i);
				return;
			}
			if (map.get(currSum - sum) != null) {
				System.out.println("Start Index : " + (map.get(currSum - sum) + 1) + " End Index : " + i);
				return;
			}
			map.put(currSum, i);
		}
		System.out.println("Not Exists");
	}
}
