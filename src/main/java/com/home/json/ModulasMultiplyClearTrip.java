package com.home.json;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

//https://www.hackerearth.com/challenge/hiring/cleartrip-developer-challenge/problems/dc2c8d1b87414bd2be3df78e7110d54c/
public class ModulasMultiplyClearTrip {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String split[] = line.split(" ");
		BigInteger count = new BigInteger(split[0]);
		BigInteger K = new BigInteger(split[1]);
		BigInteger X = new BigInteger(split[2]);
		BigInteger Y = new BigInteger(split[3]);
		split = br.readLine().split(" ");
		Map<BigInteger, Integer> hashMap = new HashMap<BigInteger, Integer>();
		for (int i = 0; i < count.intValue(); i++) {
			BigInteger bi = new BigInteger(split[i]);
			if (hashMap.get(bi) == null) {
				hashMap.put(bi, 1);
			} else {
				hashMap.put(bi, 1 + hashMap.get(bi));
			}
		}
		BigInteger[] array = hashMap.keySet().toArray(new BigInteger[hashMap.keySet().size()]);
		int numCount = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (i != j) {
					if (array[i].add(array[j]).mod(K).equals(X) && array[i].multiply(array[j]).mod(K).equals(Y)) {
						numCount = numCount + (hashMap.get(array[i]) * hashMap.get(array[j]));
					}
				}
			}
		}
		System.out.println(numCount);
	}

}
