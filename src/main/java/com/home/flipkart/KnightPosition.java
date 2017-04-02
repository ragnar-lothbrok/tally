package com.home.flipkart;

import java.util.LinkedList;
import java.util.Queue;

//http://www.geeksforgeeks.org/minimum-steps-reach-target-knight/
public class KnightPosition {

	public static void main(String[] args) {
		int N = 8;
		int knightPos[] = { 0, 0 };
		int targetPos[] = { 4, 5 };

		findMinimumPath(knightPos[0], knightPos[1], targetPos[0], targetPos[1], N);
	}

	static int X[] = { 2, 2, 1, 1, -1, -1, -2, -2 };

	static int Y[] = { -1, 1, 2, -2, 2, -2, 1, -1 };

	private static void findMinimumPath(int x, int y, int destX, int destY, int N) {
		Point p1 = new Point(x, y);
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(p1);
		boolean visited[][] = new boolean[N][N];
		Point path[][] = new Point[N][N];
		while (!queue.isEmpty()) {
			Point temp = queue.remove();
			if (temp.getX() == destX && temp.getY() == destY) {
				while (p1.getX() != temp.getX() && p1.getY() != temp.getY()) {
					System.out.println(temp);
					temp = path[temp.getX()][temp.getY()];
				}
				System.out.println(temp);
				System.out.println("Exists");
				break;
			}
			visited[temp.getX()][temp.getY()] = true;
			for (int i = 0; i < X.length; i++) {
				int x1 = temp.getX() + X[i];
				int y1 = temp.getY() + Y[i];
				if ((x1 >= 0 && x1 < N) && (y1 >= 0 && y1 < N) && !visited[x1][y1]) {
					path[x1][y1] = temp;
					queue.add(new Point(x1, y1));
				}
			}
		}
	}

	private static class Point {
		private int x;
		private int y;

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

	}
}
