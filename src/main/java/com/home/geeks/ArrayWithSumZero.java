package com.home.geeks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//http://www.geeksforgeeks.org/print-all-subarrays-with-0-sum/
public class ArrayWithSumZero {

	public static void main(String[] args) {

		int arr[] = { 6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7 };
		findSumZero(arr);
	}

	private static void findSumZero(int[] arr) {
		Map<Integer, List<Integer>> sumMap = new HashMap<Integer, List<Integer>>();
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (sum == 0) {
				System.out.println("Start : " + 0 + " End : " + i);
			}

			if (sumMap.get(sum) != null) {
				for (Integer index : sumMap.get(sum)) {
					System.out.println("Start : " + (index + 1) + " End : " + i);
				}
			}

			if (sumMap.get(sum) == null) {
				sumMap.put(sum, new ArrayList<Integer>());
			}
			sumMap.get(sum).add(i);

		}
	}
}
