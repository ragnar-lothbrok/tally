package com.home.geeks;
//http://www.geeksforgeeks.org/pangram-checking/
public class PanagramChecking {

	public static void main(String[] args) {
		System.out.println(checkPanagram("The quick brown fox jumps over the lazy dog"));
		System.out.println(checkPanagram("The quick brown fox jumps over the dog"));
	}

	private static boolean checkPanagram(String str) {
		boolean ch[] = new boolean[26];
		for (int i = 0; i < str.length(); i++) {
			if ((str.charAt(i) >= 'a' && str.charAt(i) <= 'z') || (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')) {
				if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
					ch[str.charAt(i) - 'A'] = true;
				} else {
					ch[str.charAt(i) - 'a'] = true;
				}
			}
		}

		boolean isPanagram = true;
		for (int i = 0; i < ch.length; i++) {
			if (!ch[i]) {
				isPanagram = false;
				break;
			}
		}
		return isPanagram;
	}
}
