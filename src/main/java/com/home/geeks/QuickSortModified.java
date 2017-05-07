package com.home.geeks;

public class QuickSortModified {

	public static void main(String[] args) {

		int arr[] = { 4, 5, 6, 3, -6, 5, 7 };
		quickSort(arr, 0, arr.length - 1);
		display(arr);
	}

	private static void display(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void quickSort(int arr[], int left, int right) {
		int pivot = (left + right) / 2;
		pivot = partition(arr, pivot, left, right);
		if (left < pivot - 1)
			quickSort(arr, left, pivot - 1);
		if (pivot < right)
			quickSort(arr, pivot, right);
	}

	private static int partition(int arr[], int pivot, int left, int right) {
		while (left <= right) {
			while (arr[left] < arr[pivot]) {
				left++;
			}
			while (arr[right] > arr[pivot]) {
				right--;
			}
			if (left <= right) {
				swap(arr, left, right);
				left++;
				right--;
			}
		}
		return left;
	}

	private static void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
}
