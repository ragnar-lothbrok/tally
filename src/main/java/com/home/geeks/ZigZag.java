package com.home.geeks;

import java.util.Arrays;

//http://www.geeksforgeeks.org/convert-array-into-zig-zag-fashion/
public class ZigZag {

	public static void main(String[] args) {
		int arr[] = { 4, 3, 7, 8, 6, 2, 1 };
		convertToZigZag(arr);

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void convertToZigZag(int arr[]){
		Arrays.sort(arr);
		for(int i=1;i<arr.length-1;i++){
			swap(arr,i,i+1);
			i++;
		}
	}

	public static void convertZigZag(int arr[]) {
		boolean flag = true;
		for (int i = 0; i < arr.length - 2; i++) {
			if (flag) {
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
				}
				flag = false;
			} else {
				if (arr[i] < arr[i + 1]) {
					swap(arr, i, i + 1);
				}
				flag = true;
			}
		}
	}

	private static void swap(int arr[], int pos1, int pos2) {
		int temp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = temp;
	}
}
