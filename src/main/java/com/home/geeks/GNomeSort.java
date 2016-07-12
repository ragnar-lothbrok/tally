package com.home.geeks;

//http://www.geeksforgeeks.org/gnome-sort-a-stupid-one/
public class GNomeSort {

	public static void main(String[] args) {
		int arr[] = { 88, 30, 87, 72, 5, 48, 15, 80, 45, 59, 86 };
		gnomeSort(arr);
	}

	private static void gnomeSort(int arr[]) {
		int index = 0;
		while (index < arr.length) {
			if (index != 0 && arr[index] < arr[index - 1]) {
				int temp = arr[index - 1];
				arr[index - 1] = arr[index];
				arr[index] = temp;
				index--;
			} else {
				index++;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
