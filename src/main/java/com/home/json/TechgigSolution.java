package com.home.json;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TechgigSolution {

	public static void main(String[] args) {
		System.out.println(minimumpossiblecost("-1@10@-1#10@-1@10#-1@10@-1"));
		System.out.println(minimumpossiblecost("-1@10@-1#10@2@10#-1@10@-1"));
		System.out.println(minimumpossiblecost("1@10@1#10@2@10#1@10@1"));
	}

	public static int minimumpossiblecost(String input1) {
		int result = -1;
		String split[] = input1.split("#");
		int row = split.length;
		int col = split[0].split("@").length;
		int matrix[][] = new int[row][col];
		List<Point> walls = new ArrayList<Point>();
		boolean isOnceVisited = false;
		for (int i = 0; i < row; i++) {
			String colSplit[] = split[i].split("@");
			for (int j = 0; j < col; j++) {
				matrix[i][j] = Integer.parseInt(colSplit[j]);
				if (matrix[i][j] != -1) {
					walls.add(new Point(i, j, matrix[i][j]));
				}
				if (matrix[i][j] == -1) {
					isOnceVisited = true;
				}
				// System.out.print(matrix[i][j] + " ");
			}
			// System.out.println();
		}

		if (!isOnceVisited) {
			return 0;
		}

		Collections.sort(walls);
		boolean[][] visited = new boolean[row][col];
		isOnceVisited = false;
		outer: for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (!visited[i][j] && matrix[i][j] == -1) {
					if (isOnceVisited) {
						isOnceVisited = false;
						break outer;
					}
					isAllVisited(matrix, visited, new Point(i, j));
					isOnceVisited = true;
				}
			}
		}
		List<Point> taken = new ArrayList<Point>();
		if (isOnceVisited) {
			result = 0;
		} else {
			while (walls.size() > 0) {
				resetVisited(visited);
				taken.add(walls.remove(0));
				for (int k = 0; k < taken.size(); k++) {
					matrix[taken.get(k).getX()][taken.get(k).getY()] = -1;
				}
				outer: for (int i = 0; i < matrix.length; i++) {
					for (int j = 0; j < matrix[0].length; j++) {
						if (!visited[i][j] && matrix[i][j] == -1) {
							if (isOnceVisited) {
								isOnceVisited = false;
								break outer;
							}
							isAllVisited(matrix, visited, new Point(i, j));
							isOnceVisited = true;
						}
					}
				}
				if (isOnceVisited) {
					break;
				}
			}

		}
		if (isOnceVisited) {
			int cost = 0;
			for (int k = 0; k < taken.size(); k++) {
				cost += taken.get(k).getCost();
			}
			result = cost;
		}
		return result;
	}

	private static void resetVisited(boolean[][] visited) {
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[0].length; j++) {
				visited[i][j] = false;
			}
		}
	}

	static int X[] = { 0, 0, -1, -1, -1, 1, 1, 1 };
	static int Y[] = { 1, -1, 0, -1, 1, 1, 0, -1 };

	private static void isAllVisited(int matrix[][], boolean[][] visited, Point point) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(point);
		visited[point.getX()][point.getY()] = true;
		while (!queue.isEmpty()) {
			Point temp = queue.remove();
			for (int i = 0; i < X.length; i++) {
				int tempX = temp.getX() + X[i];
				int tempY = temp.getY() + Y[i];

				if ((tempX >= 0 && tempX < matrix.length) && (tempY >= 0 && tempY < matrix[0].length)) {
					if (matrix[tempX][tempY] == -1 && !visited[tempX][tempY]) {
						visited[tempX][tempY] = true;
						queue.add(new Point(tempX, tempY));
					}
				}
			}
		}
	}

	private static class Point implements Comparable<Point> {
		private int x;
		private int y;
		private Integer cost;

		public Integer getCost() {
			return cost;
		}

		public Point(int x, int y, int cost) {
			super();
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		@Override
		public int compareTo(Point o) {
			return -o.getCost().compareTo(this.getCost());
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", cost=" + cost + "]";
		}

	}

}
