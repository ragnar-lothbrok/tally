package com.home.geeks;

import java.util.ArrayList;
import java.util.List;

public class PathToMiddleCell {

	static int row[] = { 0, 0, 8, 8 };
	static int col[] = { 0, 8, 0, 8 };
	static int moveRow[] = { 1, -1, 0, 0 };
	static int moveCol[] = { 0, 0, -1, 1 };

	public static void main(String[] args)

	{

		int arr[][] = { { 3, 5, 4, 4, 7, 3, 4, 6, 3 }, { 6, 7, 5, 6, 6, 2, 6, 6, 2 }, { 3, 3, 4, 3, 2, 5, 4, 7, 2 }, { 6, 5, 5, 1, 2, 3, 6, 5, 6 },
				{ 3, 3, 4, 3, 0, 1, 4, 3, 4 }, { 3, 5, 4, 3, 2, 2, 3, 3, 5 }, { 3, 5, 4, 3, 2, 6, 4, 4, 3 }, { 3, 5, 1, 3, 7, 5, 3, 6, 4 },
				{ 6, 2, 4, 3, 4, 5, 4, 5, 1 } };

		List<Point> visitedList = new ArrayList<Point>();
		List<Point> pathList = new ArrayList<Point>();

		Point point = null;
		for (int i = 0; i < col.length; i++) {
			point = new Point(row[i], col[i]);
			visitedList.add(point);
			pathList.add(point);
			findPossiblePath(arr, row[i], col[i], visitedList, pathList);
			visitedList.clear();
			pathList.clear();
		}
	}

	private static void findPossiblePath(int arr[][], int i, int j, List<Point> visitedList, List<Point> pathList) {
		if (i == 4 && j == 4) {
			System.out.println("FOUND :>> "+pathList);
		}
		for (int k = 0; k < moveCol.length; k++) {
			int n = arr[i][j];
			int x = i + moveRow[k]*n;
			int y = j + moveCol[k]*n;
			Point point = new Point(x, y);
			if (x >= 0 && x < arr.length && y >= 0 && y < arr.length) {
				if (!visitedList.contains(point)) {
					visitedList.add(point);
					pathList.add(point);
					findPossiblePath(arr, x, y, visitedList, pathList);
					pathList.remove(point);
				}
			}
		}
	}

	static class Point {
		int x;
		int y;

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "[" + x + "," + y + "]";
		}

	}
}
