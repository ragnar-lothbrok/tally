package com.he.capillary;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Armies {

	public static void main(String[] args) {
		
		System.out.println(new BigDecimal(2*(Math.pow(2, 100)-1)).toString());

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String line = br.readLine();
			int noOfCases = Integer.parseInt(line.trim());
			for (int i = 0; i < noOfCases; i++) {
				int num = Integer.parseInt(br.readLine());
				List<Integer> attacker = new ArrayList<Integer>();
				for (int j = 0; j < num; j++) {
					attacker.add(Integer.parseInt(br.readLine().trim()));
				}
				List<Integer> defender = new ArrayList<Integer>();
				for (int j = 0; j < num; j++) {
					defender.add(Integer.parseInt(br.readLine().trim()));
				}

				attacker.sort((i1, i2) -> i1.compareTo(i2));
				defender.sort((i1, i2) -> i1.compareTo(i2));
				int count = 0, k = defender.size() - 1, l = attacker.size() - 1;
				while (k >= 0 && l >= 0) {
					if (defender.get(k) > attacker.get(l)) {
						count++;
						k--;
						l--;
					} else if (defender.get(k) <= attacker.get(l)) {
						l--;
					}
				}
				System.out.println(count);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
