package com.home.geeks;

public class RemoveDuplicates {

	public static void main(String[] args) {
		removeDuplicates("abccbcc");
		removeDuplicates("abbabba");
		removeDuplicates("abcdeedcbfgf");
		removeDuplicates("aa");
		removeDuplicates("baa");
		removeDuplicates("aabcccdee");
		removeDuplicates("aab");
		removeDuplicates("acaaabbbacdddd");

	}

	private static void removeDuplicates(String str) {
		StringBuilder sb = new StringBuilder();
		int j = 0;
		boolean foundDuplicate = false;
		for (int i = 0; i < str.length(); i++) {
			if (j <= 0) {
				sb.append(str.charAt(i) + "");
				j++;
			} else if (sb.charAt(j - 1) != str.charAt(i)) {
				if (foundDuplicate) {
					sb.deleteCharAt(j - 1);
					j--;
					foundDuplicate = false;
					if (j == 0 || sb.charAt(j - 1) != str.charAt(i)) {
						sb.append(str.charAt(i) + "");
						j++;
					} else {
						foundDuplicate = true;
						continue;
					}
				} else {
					sb.append(str.charAt(i) + "");
					j++;
				}
			} else if (sb.charAt(j - 1) == str.charAt(i)) {
				foundDuplicate = true;
				continue;
			}
		}
		if (foundDuplicate) {
			sb.deleteCharAt(sb.length() - 1);
		}
		System.out.println(sb.toString());
	}

}
