package com.home.geeks;

import java.util.Arrays;
//http://www.geeksforgeeks.org/count-triplets-with-sum-smaller-that-a-given-value/
public class CountTriplets {

	public static void main(String[] args) {
		int arr[] = { 5, 1, 3, 4, 7 }/* { -2, 0, 1, 3 } */;
		countTriplet(arr, 0, 0, 12, 0);
		System.out.println(count);
		countTriplets(arr,12);
	}

	private static int count = 0;

	public static void countTriplets(int arr[],int sum) {
		count = 0;
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			int j=i+1,k=arr.length-1;
			while(j < k){
				if(arr[i]+arr[j]+arr[k] <= sum){
					k--;
				}else{
					count += (k-j);
					j++;
				}
			}
		}
		System.out.println(count);
	}

	public static void countTriplet(int arr[], int index, int modSum, int sum, int totalNum) {
		if (totalNum == 3 && modSum < sum) {
			count++;
		} else if (modSum >= sum || index == arr.length) {

		} else {
			countTriplet(arr, index + 1, modSum + arr[index], sum, totalNum + 1);
			countTriplet(arr, index + 1, modSum, sum, totalNum);
		}
	}
}
