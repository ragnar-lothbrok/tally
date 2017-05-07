package com.he.graphs;

//http://www.geeksforgeeks.org/union-find-algorithm-set-2-union-by-rank/
public class CycleCheckInGraphWithRank {

	public static void main(String[] args) {

		int mat[][] = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 0, 0 } };
		findCycle(mat);
	}

	private static void findCycle(int mat[][]) {
		int parent[] = new int[mat.length];
		int rank[] = new int[mat.length];
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if (mat[i][j] != 0) {
					int x = find(parent, i);
					int y = find(parent, j);
					if (x == y) {
						union(parent, rank, i, j);
						System.out.println("Contains Cycle.");
						return;
					}
					union(parent, rank, i, j);
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

	public static void union(int[] parent, int rank[], int i, int j) {
		int x = find(parent, i);
		int y = find(parent, j);
		if (rank[x] == rank[y]) {
			parent[x] = y;
			rank[y]++;
		} else if (rank[x] > rank[y]) {
			parent[y] = x;
		} else {
			parent[x] = y;
		}
	}
}
