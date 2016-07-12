package com.home.geeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BinarySearch {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int arr[] = new int[num];
		String str[] = br.readLine().split(" ");
		for (int i = 0; i < str.length; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		int searchNum = Integer.parseInt(br.readLine());

		int low = 0, high = arr.length-1, mid = 0;
		while (low <= high) {
			mid = (low + high) / 2;
			if (arr[mid] == searchNum) {
				System.out.println(mid+1);
				return;
			} else if (arr[mid] < searchNum) {
				low = mid;
			} else {
				high = mid;
			}
		}
		System.out.println(-1);
	}
}
