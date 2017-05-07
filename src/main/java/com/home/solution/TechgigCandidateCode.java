package com.home.solution;

import java.util.HashMap;
import java.util.Map;

public class TechgigCandidateCode {

	public static void main(String[] args) {
		System.out.println(passCount(5, 3, 2));
	}

	public static int passCount(int input1, int input2, int input3) {
		int N = input1;
		int M = input2;
		int L = input3;
		Map<Integer, Integer> playerPlayMap = new HashMap<Integer, Integer>();
		for (int i = 1; i <= input1; i++) {
			playerPlayMap.put(i, 0);
		}

		int maxPass = 0;
		int currentPlayer = 1;
		int ballPlayCount = 0;
		int remainder = (L + 1) % N;
		while (M > maxPass) {
			playerPlayMap.put(currentPlayer, playerPlayMap.get(currentPlayer) + 1);
			int temp = playerPlayMap.get(currentPlayer);
			if (maxPass < playerPlayMap.get(currentPlayer)) {
				maxPass = playerPlayMap.get(currentPlayer);
				if (M == maxPass) {
					break;
				}
			}
			ballPlayCount++;
			if (remainder == 0) {
				continue;
			} else {
				if (temp != 0 && temp % 2 == 0) {
					if (currentPlayer > remainder) {
						currentPlayer = currentPlayer - remainder;
					} else {
						currentPlayer = (currentPlayer + N - remainder);
					}
				} else {
					if ((currentPlayer + remainder) != N) {
						currentPlayer = (currentPlayer + remainder) % N;
					} else {
						currentPlayer = (currentPlayer + remainder);
					}
				}
			}
		}
		return (ballPlayCount == 0 ? -1 : ballPlayCount);
	}
}
