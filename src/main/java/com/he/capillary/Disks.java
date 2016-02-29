package com.he.capillary;

public class Disks {

	static int swap = 0;

	public static void main(String[] args) {
		int arr[] = { 1, 0, 1, 0, 1, 0, 1, 0 };
		// int arr[] = { 1, 1 };
		
		System.out.println("UnSorted : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		int pos = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1 && pos == -1) {
				pos = i;
			} else if (arr[i] == 0) {
				int j = i;
				if (pos != -1) {
					if (pos == i - 1) {
						swap(arr, pos, i);
						i = pos;
						pos = -1;
					} else {
						while (j > pos) {
							swap(arr, j, j - 1);
							j--;
						}
						i = pos;
						;
						pos = -1;
					}
				}
			}
		}

		System.out.println("\nSorted : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		System.out.println("\nSwap Count : " + swap);
	}

	public static void swap(int[] arr, int i, int k) {
		swap++;
		int temp = arr[i];
		arr[i] = arr[k];
		arr[k] = temp;
	}

}
