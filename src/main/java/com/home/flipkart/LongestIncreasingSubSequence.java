package com.home.flipkart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
public class LongestIncreasingSubSequence {

	public static void main(String[] args) {

		// int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
//		int arr[] = { 2, 5, 3, 7, 11, 8, 10, 13, 6 };
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String line = br.readLine();
			Integer count = Integer.parseInt(line);
			int arr[] = new int[count];
			for (int i = 0; i < count; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			findLIS(arr);
		} catch (Exception exception) {
		}
	}

	private static void findLIS(int arr[]) {
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < arr.length; i++) {
			map.put(i, new ArrayList<Integer>());
		}

		map.get(0).add(arr[0]);

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && map.get(j).size() > map.get(i).size()) {
					map.get(i).clear();
					map.get(i).addAll(map.get(j));
				}
			}
			map.get(i).add(arr[i]);
		}

		int length = 0, index = 0;
		for (int i = 0; i < arr.length; i++) {
			if (map.get(i).size() > length) {
				length = map.get(i).size();
				index = i;
			}
		}
		System.out.println(length);
	}

}
