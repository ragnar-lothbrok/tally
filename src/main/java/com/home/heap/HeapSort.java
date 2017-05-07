package com.home.heap;

public class HeapSort {

	private static int N;

	private static boolean asc = true;

	public static void main(String[] args) {

		int arr[] = { 1, 3, 5, 7, 8, 9, 4, 6, 3, 10, 25, 31, 12 };
		heapSort(arr);
		
		boolean isFound = false;
		int findElement = 6;
		for(int i = 10; i > 0; i--){
			if(findElement == arr[i]){
				System.out.println(1+i);
				isFound = true;
			}
		}
		if(!isFound){
			System.out.println(0);
		}

	}

	public static void heapSort(int[] arr) {
		heapify(arr);
		for (int i = N; i > 0; i--) {
			swap(arr, 0, i);
			N = N - 1;
			if (asc)
				maxHeap(arr, 0);
			else
				minHeap(arr, 0);
		}
	}

	private static void heapify(int[] arr) {
		N = arr.length - 1;
		for (int i = N / 2; i >= 0; i--) {
			if (asc)
				maxHeap(arr, i);
			else
				minHeap(arr, i);
		}
	}

	private static void maxHeap(int[] arr, int i) {
		int max = i;
		int left = i * 2;
		int right = i * 2 + 1;
		if (left <= N && arr[left] > arr[max]) {
			max = left;
		}
		if (right <= N && arr[right] > arr[max]) {
			max = right;
		}
		if (max != i) {
			swap(arr, max, i);
			maxHeap(arr, max);
		}
	}

	private static void minHeap(int[] arr, int i) {
		int min = i;
		int left = i * 2;
		int right = i * 2 + 1;
		if (left <= N && arr[left] < arr[min]) {
			min = left;
		}
		if (right <= N && arr[right] < arr[min]) {
			min = right;
		}
		if (min != i) {
			swap(arr, min, i);
			minHeap(arr, min);
		}
	}

	public static void swap(int[] arr, int pos1, int pos2) {
		int temp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = temp;
	}

}
