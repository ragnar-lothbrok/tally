package com.home.geeks;

import java.util.LinkedList;
import java.util.Queue;

//http://www.geeksforgeeks.org/find-shortest-distance-guard-bank/
public class ShortestDistanceGuard {

	public static void main(String[] args) {

		char inputMat[][] = { { 'O', 'O', 'O', 'O', 'G' }, { 'O', 'W', 'W', 'O', 'O' }, { 'O', 'O', 'O', 'W', 'O' }, { 'G', 'W', 'W', 'W', 'O' },
				{ 'O', 'O', 'O', 'O', 'G' } };

		int distance[][] = new int[inputMat.length][inputMat.length];
		for (int i = 0; i < inputMat.length; i++) {
			for (int j = 0; j < distance.length; j++) {
				if (inputMat[i][j] == 'W') {
					distance[i][j] = -1;
				} else if (inputMat[i][j] == 'G') {
					distance[i][j] = 0;
				} else {
					distance[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		boolean visited[][] = new boolean[inputMat.length][inputMat.length];

		for (int i = 0; i < inputMat.length; i++) {
			for (int j = 0; j < distance.length; j++) {
				if (inputMat[i][j] == 'G') {
					fillShortestDistance(inputMat, distance, i, j, visited);
				}
			}
		}

		for (int i = 0; i < inputMat.length; i++) {
			for (int j = 0; j < distance.length; j++) {
				System.out.print(distance[i][j] + " ");
			}
			System.out.println();
		}

	}

	static int XCo[] = { -1, 1, 0, 0 };
	static int YCo[] = { 0, 0, 1, -1 };

	private static void fillShortestDistance(char inputMat[][], int distance[][], int i, int j, boolean visited[][]) {
		Queue<Location> queue = new LinkedList<Location>();
		queue.add(new Location(i, j));
		distance[i][j] = 0;
		while (!queue.isEmpty()) {
			Location location = queue.poll();
			for (int k = 0; k < XCo.length; k++) {
				int uxCo = location.x + XCo[k];
				int uyCo = location.y + YCo[k];

				if ((uxCo >= 0 && uxCo < inputMat.length) && (uyCo >= 0 && uyCo < inputMat.length) && !visited[uxCo][uyCo]) {

					if (inputMat[uxCo][uyCo] == 'O') {
						int dis = distance[location.x][location.y];
						if (distance[uxCo][uyCo] > dis + 1) {
							distance[uxCo][uyCo] = dis + 1;
						}
						queue.add(new Location(uxCo, uyCo));
						visited[uxCo][uyCo] = true;
					}
				}
			}
		}

		for (int l = 0; l < inputMat.length; l++) {
			for (int m = 0; m < distance.length; m++) {
				visited[l][m] = false;

			}
		}
	}

	static class Location {
		private Integer x;
		private Integer y;

		public Location(Integer x, Integer y) {
			super();
			this.x = x;
			this.y = y;
		}

		public Integer getX() {
			return x;
		}

		public void setX(Integer x) {
			this.x = x;
		}

		public Integer getY() {
			return y;
		}

		public void setY(Integer y) {
			this.y = y;
		}

		@Override
		public String toString() {
			return "Locations [x=" + x + ", y=" + y + "]";
		}

	}

}
