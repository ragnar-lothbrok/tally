package com.home.geeks;

//http://www.geeksforgeeks.org/find-the-smallest-positive-number-missing-from-an-unsorted-array/
public class SmallestPositiveInteger {

	public static void main(String[] args) {
		
		System.out.println((3 + 1) / (3 / 6) );
		int arr[] = { 2, 3, 7, 6, 8, 1, -10, 15 };
		findSmallestPositiveInteger(arr);
	}

	private static void findSmallestPositiveInteger(int arr[]) {
		shuffle(arr);
		int start = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				start = i;
				break;
			}
		}

		for (int i = start; i < arr.length; i++) {
			if (Math.abs(arr[i]) <= arr.length - start && arr[start + Math.abs(arr[i]) - 1] > 0) {
				arr[start + Math.abs(arr[i]) - 1] = -1 * arr[start + Math.abs(arr[i]) - 1];
			}
		}

		int result = 1;
		for (int i = start; i < arr.length; i++) {
			if (arr[i] > 0) {
				result = i - start + 1;
				break;
			}
		}
		System.out.println(result);
	}

	private static void shuffle(int arr[]) {
		int i = 0, j = arr.length - 1;
		while (j > i) {
			while (arr[i] <= 0) {
				i++;
			}

			while (arr[j] > 0) {
				j--;
			}

			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
