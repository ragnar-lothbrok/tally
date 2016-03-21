package com.he.capillary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RabbitAndCages {

	static char[][] arr = null;
	static int[][] visited = null;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int testCases = Integer.parseInt(line);
		for (int i = 0; i < testCases; i++) {
			line = br.readLine();
			String str[] = line.trim().split(" ");
			int row = Integer.parseInt(str[0]);
			int col = Integer.parseInt(str[1]);
			arr = new char[row][col];
			visited = new int[row][col];
			int[] P = new int[2];
			int[] C = new int[2];
			for (int j = 0; j < row; j++) {
				String values[] = br.readLine().split("");
				for (int k = 0; k < col; k++) {
					arr[j][k] = values[k].charAt(0);
					if (arr[j][k] == 'P') {
						P[0] = j;
						P[1] = k;
					} else if (arr[j][k] == 'C') {
						C[0] = j;
						C[1] = k;
					}
				}
			}

			if (isReachable(P, C, visited, arr, P[0], P[1], row, col)) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}

	private static boolean isReachable(int[] P, int[] C, int visited[][], char arr[][], int i, int j, int row,
			int col) {
		boolean result = false;
		visited[i][j] = 1;
		if (i == C[0] && j == C[1]) {
			result = true;
			return result;
		}
		if (i + 1 < row && visited[i + 1][j] != 1 && arr[i + 1][j] != '#'
				&& isReachable(P, C, visited, arr, i + 1, j, row, col)) {
			return true;
		}
		if (i - 1 > 0 && visited[i - 1][j] != 1 && arr[i - 1][j] != '#'
				&& isReachable(P, C, visited, arr, i - 1, j, row, col)) {
			return true;
		}
		if (j + 1 < col && visited[i][j + 1] != 1 && arr[i][j + 1] != '#'
				&& isReachable(P, C, visited, arr, i, j + 1, row, col)) {
			return true;
		}
		if (j - 1 > 0 && visited[i][j - 1] != 1 && arr[i][j - 1] != '#'
				&& isReachable(P, C, visited, arr, i, j - 1, row, col)) {
			return true;
		}
		return result;
	}

}
