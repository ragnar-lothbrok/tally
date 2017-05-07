package com.he.july;

//http://www.geeksforgeeks.org/backtracking-set-3-n-queen-problem/
public class FourQueenProblem {

	public final static Integer queenCount = 4;

	public static void main(String[] args) {

		int arr[][] = new int[4][4];
		System.out.println(recurssive(arr, 0));
		printSolution(arr);

	}

	static void printSolution(int board[][]) {
		for (int i = 0; i < queenCount; i++) {
			for (int j = 0; j < queenCount; j++)
				System.out.print(" " + board[i][j] + " ");
			System.out.println();
		}
	}

	public static boolean recurssive(int arr[][], int col) {
		if (col >= queenCount) {
			return true;
		}
		for (int i = 0; i < queenCount; i++) {
			if (i == 1 && col == 0) {
				System.out.println();
			}
			if (isSafe(arr, i, col) == true) {
				arr[i][col] = 1;
				if (recurssive(arr, col + 1) == true) {
					return true;
				} else {
					arr[i][col] = 0;
				}
			}
		}
		return false;
	}

	public static Boolean isSafe(int board[][], int row, int col) {
		for (int i = 0; i < col; i++) {
			if (board[row][i] == 1) {
				return false;
			}
		}
		for (int i = 0; i < row; i++) {
			if (board[row][i] == 1) {
				return false;
			}
		}
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
			if (board[i][j] == 1)
				return false;

		/* Check lower diagonal on left side */
		for (int i = row, j = col; j >= 0 && i < queenCount; i++, j--)
			if (board[i][j] == 1)
				return false;

		return true;
	}
}
