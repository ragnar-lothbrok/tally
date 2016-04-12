package com.home.techgig.wipro;

import java.util.HashMap;
import java.util.Map;

public class CandidateCode {

	public static void main(String[] args) {
		System.out.println(
				collegecomparison(new int[] { 12, 11, 5, 2, 7, 5, -11 }, new int[] { 5, 12, 5, 7, 11, 2, 11 }));
	}

	public static final String INVALID = "Invalid";
	public static final String EQUAL = "Equal";
	public static final String UNEQUAL = "Unequal";

	public static String collegecomparison(int[] input1, int[] input2) {
		String result = null;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		if (input1 != null && input1.length > 0) {
			for (int value : input1) {
				if (value < 0) {
					result = INVALID;
					break;
				} else if (map.get(value) == null) {
					map.put(value, 1);
				} else {
					map.put(value, map.get(value) + 1);
				}
			}

			if (result == null) {
				if (input2 != null && input2.length > 0) {
					for (int value : input2) {
						if (value < 0) {
							result = INVALID;
							break;
						} else if (map.get(value) == null) {
							result = UNEQUAL;
							break;
						} else {
							if (map.get(value).intValue() == 1) {
								map.remove(value);
							} else {
								map.put(value, map.get(value) - 1);
							}
						}
					}
				} else {
					result = UNEQUAL;
				}
			}
		} else if (input2 != null && input2.length > 0) {
			result = UNEQUAL;
		}
		if (result == null)
			result = EQUAL;
		return result;
	}
}
