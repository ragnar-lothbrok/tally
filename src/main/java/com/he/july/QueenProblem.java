package com.he.july;

public class QueenProblem {

	private static int SQUARE_SIDE = 4;
	private static int[] queenPlace = null;

	public static void main(String[] args) {
		queenPlace = new int[SQUARE_SIDE];
		placeQueens(0, SQUARE_SIDE);
	}

	public static void placeQueens(int low, int high) {
		for (int i = 0; i < high; i++) {
			if (isCorrectPostion(low, i)) {
				queenPlace[low] = i;
				if (low == SQUARE_SIDE - 1)
					showPositions();
				else
					placeQueens(low + 1, high);
			}
		}
	}

	/*
	 * Method will return boolean value if the queen to be placed is at correct
	 * position.
	 */
	private static boolean isCorrectPostion(int x, int y) {
		for (int i = 0; i < x; i++) {
			if (queenPlace[i] == y || (Math.abs(queenPlace[i] - y) == Math.abs(i - x))) {
				return false;
			}
		}
		return true;
	}

	/*
	 * Will print final positions of all Queens.
	 */
	private static void showPositions() {
		for (int pos = 0; pos < SQUARE_SIDE; pos++) {
			System.out.println("X : " + pos + " Y : " + queenPlace[pos]);
		}
	}
}
