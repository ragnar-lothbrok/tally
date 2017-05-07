package com.pragramcreek;

//http://www.programcreek.com/2015/03/rotate-array-in-java/
public class RotateArray {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		int limit = 8;
		limit = limit % arr.length;
		rotateArray(0, limit -1, arr);
		rotateArray(limit, arr.length - 1, arr);
		rotateArray(0, arr.length - 1, arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void rotateArray(int left, int right, int arr[]) {
		while (left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}
}
