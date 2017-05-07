package com.home.geeks;

import java.util.LinkedHashSet;
import java.util.Set;

//http://www.geeksforgeeks.org/find-distinct-subsets-given-set/
public class DistinctSubsets {

	public static void main(String[] args) {
		int arr[] = { 10, 12, 12 };
		int combinations = (int) Math.pow(2, arr.length);
		Set<String> uniqueSets = new LinkedHashSet<String>();
		for (int i = 0; i < combinations; i++) {
			String str = Integer.toBinaryString(i);
			System.out.println(str);
			StringBuilder sb = new StringBuilder();
			for (int j = arr.length - str.length(),k=0; j < arr.length; j++,k++) {
				if (str.charAt(k) == '1') {
					sb.append(arr[j] + ",");
				}
			}
			
			if(sb.length() == 1 && sb.charAt(0) == ','){
				uniqueSets.add("{}");
			}else{
				uniqueSets.add("{"+sb.toString()+"}");
			}
		}
		System.out.println(uniqueSets);
	}
}
