package com.home.geeks;

import java.io.BufferedReader;
import java.io.FileReader;

//https://www.hackerrank.com/challenges/the-love-letter-mystery
public class PalindromReduction {

	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("/home/raghunandangupta/gitPro/h2o-world-2014-training/tutorials/streaming/storm/abc.txt"));
			String line = br.readLine();
			while (line != null) {
				System.out.println(calculateOperations(line));
				line = br.readLine();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static int calculateOperations(String str) {
		int size = str.length();
		int count = 0;
		for (int i = 0, j = size - 1; i < j; ++i, --j) {
			if (str.charAt(i) != str.charAt(j)) {
				count += Math.abs(str.charAt(i) - str.charAt(j));
			}
		}
		return count;
	}

}
