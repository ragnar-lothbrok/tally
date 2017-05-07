package com.home.geeks;

//http://www.geeksforgeeks.org/maximum-difference-between-two-elements/	
public class MaxMinDifference {

	public static void main(String[] args) {
		int arr[] = { 2, 3, 10, 6, 4, 8, 1 }/* ,{7, 9, 5, 6, 3, 2} */;
		findDifference(arr);
	}

	private static void findDifference(int arr[]) {
		int maxSum = 0;
		int minNum = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (minNum > arr[i]) {
				minNum = arr[i];
			}
			if (maxSum < arr[i] - minNum) {
				maxSum = arr[i] - minNum;
			}
		}

		System.out.println(maxSum + " " + minNum);
	}
}
