package com.home.geeks;

public class ArrayRotation {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int k = 4;

		int length = arr.length;
		int temp = arr[0];
		int index = 0;

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		while (length > 0 && k < arr.length) {
			int pos = (index + (arr.length - k)) % arr.length;
			int temp1 = arr[pos];
			arr[pos] = temp;
			temp = temp1;
			index = pos;
			length--;
			
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println(); 
			
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
