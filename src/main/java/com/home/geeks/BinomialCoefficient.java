package com.home.geeks;

//http://www.geeksforgeeks.org/dynamic-programming-set-9-binomial-coefficient/
public class BinomialCoefficient {

	public static void main(String[] args) {

		System.out.println(calculateBinomialC(5, 2));
		usingDynamicProgramming(5, 2);
	}

	private static int calculateBinomialC(int n, int k) {
		if (k == 0 || k == n) {
			return 1;
		}
		return calculateBinomialC(n - 1, k - 1) + calculateBinomialC(n - 1, k);
	}

	private static void usingDynamicProgramming(int n, int k) {
		int mat[][] = new int[n + 1][k + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= Math.min(i, k); j++) {
				if (j == 0 || j == i) {
					mat[i][j] = 1;
				} else {
					mat[i][j] = mat[i - 1][j - 1] + mat[i - 1][j];
				}
			}
		}

		System.out.println(mat[n][k]);
	}

}
