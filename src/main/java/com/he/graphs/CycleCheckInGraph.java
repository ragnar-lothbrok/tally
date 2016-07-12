package com.he.graphs;

//http://www.geeksforgeeks.org/union-find/
public class CycleCheckInGraph {

	public static void main(String[] args) {

		int mat[][] = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 0, 0 } };
		findCycle(mat);
	}

	private static void findCycle(int mat[][]) {
		int parent[] = new int[mat.length];
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if (mat[i][j] != 0) {
					int x = find(parent, i);
					int y = find(parent, j);
					if (x == y) {
						union(parent, i, j);
						System.out.println("Contains Cycle.");
						return;
					}
					union(parent, i, j);
				}
			}
		}
		System.out.println("Not Contains Cycle.");
	}

	public static int find(int[] parent, int x) {
		while (parent[x] != 0) {
			x = parent[x];
		}
		return x;
	}

	public static void union(int[] parent, int i, int j) {
		int x = find(parent, i);
		int y = find(parent, j);
		parent[x] = y;
	}
}