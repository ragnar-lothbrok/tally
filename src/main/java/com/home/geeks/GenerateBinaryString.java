package com.home.geeks;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryString {

	public static void main(String[] args) {
		String str = "1??0?101";
		StringBuilder sb = new StringBuilder(str);
		usingQueue(sb);
	}

	private static void genrateAll(StringBuilder str) {
		if (str.indexOf("?") == -1) {
			System.out.println(str);
			return;
		}
		if (str.indexOf("?") != -1) {
			StringBuilder tempS = new StringBuilder(str);
			tempS.setCharAt(tempS.indexOf("?"), '0');
			genrateAll(tempS);
			tempS = new StringBuilder(str);
			tempS.setCharAt(tempS.indexOf("?"), '1');
			genrateAll(tempS);
		}
	}

	private static void usingQueue(StringBuilder sb) {
		Queue<StringBuilder> queue = new LinkedList<StringBuilder>();
		queue.add(sb);
		while (!queue.isEmpty()) {
			StringBuilder temp = queue.remove();
			if (temp.indexOf("?") == -1) {
				System.out.println(temp);
			} else {
				StringBuilder tempS = new StringBuilder(temp);
				tempS.setCharAt(tempS.indexOf("?"), '0');
				queue.add(tempS);
				tempS = new StringBuilder(temp);
				tempS.setCharAt(tempS.indexOf("?"), '1');
				queue.add(tempS);
			}
		}
	}
}
