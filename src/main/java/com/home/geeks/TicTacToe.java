package com.home.geeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class TicTacToe {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer testCases = Integer.parseInt(br.readLine());
		String line = null;
		for (int i = 0; i < testCases; i++) {
			Integer N = Integer.parseInt(br.readLine());
			int mat[][] = new int[N][N];
			for (int j = 0; j < N; j++) {
				line = br.readLine();
				String str[] = line.split(" ");
				for (int k = 0; k < str.length; k++) {
					if (str[k].charAt(0) == 'o') {
						mat[j][k] = 0;
					} else {
						mat[j][k] = 1;
					}
				}
			}
			display(mat);

			getScore(mat);

		}
	}

	private static void display(int arr[][]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	static int X[] = { 1, 1, -1, 0 };
	static int Y[] = { 1, 0, 1, 1 };
	static Direction direction[] = { Direction.DIAGONAL, Direction.HZ, Direction.DIAGONAL, Direction.VT };

	private static void getScore(int mat[][]) {
		Queue<Score> scoreQueue = new LinkedList<Score>();
		Score score = new Score(1, 0, Direction.HZ, 0, 0);
		int arr[] = new int[2];
		scoreQueue.add(score);
		while (!scoreQueue.isEmpty()) {
			Score tempScore = scoreQueue.poll();
			for (int i = 0; i < X.length; i++) {
				int xCo = tempScore.getxCo() + X[i];
				int yCo = tempScore.getyCo() + Y[i];
				if ((xCo >= 0 && xCo < mat.length) && (yCo >= 0 && yCo < mat.length)) {
					if (mat[xCo][yCo] == mat[tempScore.getxCo()][tempScore.getyCo()]) {
						if (tempScore.getCount() == 1 || !tempScore.getDirection().equals(direction[i])) {
							scoreQueue.add(new Score(2, 0, direction[i], xCo, yCo));
						} else {
							int count = tempScore.getCount() + 1;
							scoreQueue.add(new Score(count, tempScore.getScore() + (count >= 3 ? (count - 2) : 0), direction[i], xCo, yCo));
							arr[mat[xCo][yCo]] += tempScore.getScore() + (count >= 3 ? (count - 2) : 0);
							scoreQueue.add(new Score(0, 1, direction[i], xCo, yCo));
						}
					} else {
						scoreQueue.add(new Score(0, 1, Direction.HZ, xCo, yCo));
					}
				}
			}
		}
		System.out.println(arr[0] + " " + arr[1]);
	}

	enum Direction {
		HZ, VT, DIAGONAL
	}

	static class Score {
		private int score;
		private int count;
		private Direction direction;
		private int xCo;
		private int yCo;

		public int getxCo() {
			return xCo;
		}

		public void setxCo(int xCo) {
			this.xCo = xCo;
		}

		public int getyCo() {
			return yCo;
		}

		public void setyCo(int yCo) {
			this.yCo = yCo;
		}

		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

		public Direction getDirection() {
			return direction;
		}

		public void setDirection(Direction direction) {
			this.direction = direction;
		}

		public Score(int count, int score, Direction direction, int xCo, int yCo) {
			super();
			this.score = score;
			this.count = count;
			this.direction = direction;
			this.xCo = xCo;
			this.yCo = yCo;
		}

	}
}
