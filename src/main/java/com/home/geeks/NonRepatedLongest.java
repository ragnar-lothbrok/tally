package com.home.geeks;

import java.util.HashMap;
import java.util.Map;

//http://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
public class NonRepatedLongest {

	public static void main(String[] args) {
		String str = "ABDEFGABEF";
		findLongestNonRepeating(str);
	}

	private static void findLongestNonRepeating(String str) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int maxLength = 0;
		int currLength = 1;
		map.put(str.charAt(0), 0);
		Integer temp = 0;

		for (int i = 1; i < str.length(); i++) {
			temp = map.get(str.charAt(i));

			if (temp == null || i - currLength > temp) {
				currLength++;
			} else {
				if (currLength > maxLength) {
					maxLength = currLength;
					currLength = i - temp;
				}
			}
		}

		System.out.println("Maximum Length  : " + maxLength);
	}
}
