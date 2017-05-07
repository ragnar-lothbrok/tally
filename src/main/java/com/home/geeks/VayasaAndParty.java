package com.home.geeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

//https://www.hackerearth.com/amazon-hiring-challenge-1/problems/7cc56886f32441e78e21648a30f45b67/
public class VayasaAndParty {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String split[] = br.readLine().split(" ");
		int numOfPlayer = Integer.parseInt(split[0]);
		int numOfRelations = Integer.parseInt(split[1]);
		int arr[] = new int[numOfPlayer + 1];
		int rank[] = new int[numOfPlayer + 1];
		for (int i = 1; i < arr.length; i++) {
			arr[i] = i;
		}

		int knowledge[] = new int[numOfPlayer + 1];
		split = br.readLine().split(" ");
		for (int i = 0; i < split.length; i++) {
			knowledge[i + 1] = Integer.parseInt(split[i]);
		}
		for (int i = 0; i < numOfRelations; i++) {
			split = br.readLine().split(" ");
			int x = Integer.parseInt(split[0]);
			int y = Integer.parseInt(split[1]);
			union(arr, rank, x, y);
		}

		Map<Integer, List<Integer>> countMap = new HashMap<Integer, List<Integer>>();
		for (int i = 1; i < arr.length; i++) {
			if (countMap.get(arr[i]) == null) {
				countMap.put(arr[i], new ArrayList<Integer>());
				countMap.get(arr[i]).add(knowledge[i]);
			} else {
				countMap.get(arr[i]).add(knowledge[i]);
			}
		}

		List<Integer> leaderList = new ArrayList<Integer>();
		Set<Entry<Integer, List<Integer>>> entrySet = countMap.entrySet();
		Iterator<Entry<Integer, List<Integer>>> iterator = entrySet.iterator();
		while (iterator.hasNext()) {
			Entry<Integer, List<Integer>> entry = iterator.next();
			List<Integer> list = entry.getValue();
			int max = 0;
			int count = 0;
			for (int i = 0; i < list.size(); i++) {
				if (max < list.get(i)) {
					max = list.get(i);
				}
			}

			for (int i = 0; i < list.size(); i++) {
				if (max == list.get(i)) {
					count++;
				}
			}
			leaderList.add(count);
		}

		long mul = 1;
		long divider = 1000000007;
		for (int i = 0; i < leaderList.size(); i++) {
			mul *= leaderList.get(i);
			mul = mul % divider;
		}

		System.out.println(mul);
	}

	public static void union(int array[], int rank[], int root1, int root2) {
		int set1 = find(array, root1);
		int set2 = find(array, root2);
		if (rank[set1] > rank[set2]) {
			array[set2] = set1;
		} else {
			array[set1] = set2;
		}
		if (rank[set1] == rank[set2]) {
			rank[set2] = rank[set2] + 1;
		}
	}

	public static int find(int array[], int x) {
		if (array[x] != x)
			array[x] = find(array, array[x]);
		return array[x];
	}
}
