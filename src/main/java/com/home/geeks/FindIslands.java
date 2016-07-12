package com.home.geeks;

import java.util.Stack;

//http://www.geeksforgeeks.org/find-the-number-of-islands-set-2-using-disjoint-set/
public class FindIslands {

	public static void main(String[] args) {
		int arr[][] = { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 }, { 1, 0, 1, 0, 1 } };

		boolean visited[][] = new boolean[5][5];
		int count = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (!visited[i][j]) {
					countIslands(i, j, arr, visited);
				}
			}
			count++;
		}
		System.out.println("Number of islands : " + count);
	}

	public static void countIslands(int i, int j, int arr[][], boolean visited[][]) {
		visited[i][j] = true;
		Stack<Co> stack = new Stack<Co>();
		stack.add(new Co(i, j));
		while (!stack.isEmpty()) {
			Co co = stack.pop();
			for (int k = 0; k < x.length; k++) {
				int xCo = co.getX() + x[k];
				int yCo = co.getY() + y[k];
				if ((xCo < arr.length && xCo >= 0) && (yCo < arr.length && yCo >= 0)) {
					if(!visited[xCo][yCo]){
						visited[xCo][yCo] = true;
						stack.push(new Co(xCo, yCo));
					}
				}
			}
		}
	}

	private static int x[] = { 1, 0, -1 };
	private static int y[] = { 0, 1, 0 };

	static class Co {
		private int x;
		private int y;

		public Co(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

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

	}

}
