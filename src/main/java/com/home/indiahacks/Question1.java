package com.home.indiahacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.hackerearth.com/algorithms-qualifiers-round-1/algorithm/string-division/
public class Question1 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			boolean isFound = false;
			String line = br.readLine();
			for (int l = 1; l < line.length(); l++) {
				for (int j = l + 1; j < line.length(); j++) {
					for (int k = j + 1; k < line.length(); k++) {
						String first = line.substring(0, l);
						String second = line.substring(l, j);
						String third = line.substring(j, k);
						String rest = line.substring(k, line.length());
						if (!first.equals(second) && !second.equals(third) && !third.equals(rest)
								&& !first.equals(third) &&!first.equals(rest)
								&& !second.equals(rest)) {
							System.out.println("YES");
							isFound = true;
							break;
						}
					}
					if (isFound) {
						break;
					}
				}
				if (isFound) {
					break;
				}
			}
			if (!isFound) {
				System.out.println("NO");
			}
		}
	}

}
