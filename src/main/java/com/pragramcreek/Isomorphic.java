package com.pragramcreek;

import java.util.HashMap;
import java.util.Map;

//http://www.programcreek.com/2014/05/leetcode-isomorphic-strings-java/
public class Isomorphic {

	public static void main(String[] args) {

		String str1 = "abc";
		String str2 = "def";

		System.out.println(isIsomorphic(str1, str2));
	}

	private static Boolean isIsomorphic(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		} else {
			Map<Character, Character> mapping = new HashMap<Character, Character>();
			for (int i = 0, j = 0; i < str1.length(); i++, j++) {
				if (str1.charAt(i) != str2.charAt(j)) {
					if (mapping.get(str1.charAt(i)) != null) {
						if (mapping.get(str1.charAt(i)) != str2.charAt(j)) {
							return false;
						}
					} else {
						mapping.put(str1.charAt(i), str2.charAt(j));
					}
				}
			}
		}
		return true;
	}
}
