package com.home.geeks;

import java.util.HashMap;
import java.util.Map;

public class GarbageCollectionCheck {
	public static void main(String[] args) {

		while (true) {
//			for (int i = 0; i < First.hashMap1.length; i++) {
//				First.hashMap1[i] = new HashMap<Integer, Integer>();
//				for (int j = 0; j < 1000; j++) {
//					First.hashMap1[i].put(j, j);
//				}
//			}

			for (int i = 0; i < Second.hashMap2.length; i++) {
				Second.hashMap2[i] = new HashMap<Integer, Integer>();
				for (int j = 0; j < 1000; j++) {
					Second.hashMap2[i].put(j, j);
				}
			}

			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("cleaning started===");

//			for (int i = 0; i < First.hashMap1.length; i++) {
//				First.hashMap1[i].clear();
//				First.hashMap1[i] = new HashMap<Integer, Integer>();
//			}

			for (int i = 0; i < Second.hashMap2.length; i++) {
				Second.hashMap2[i] = null;
				Second.hashMap2[i] = new HashMap<Integer, Integer>();
			}

			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	static class First {
		static final Map<Integer, Integer> hashMap1[] = new HashMap[100];

	}

	static class Second {
		static final Map<Integer, Integer> hashMap2[] = new HashMap[100];
	}
}
