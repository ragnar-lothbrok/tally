package com.home.geeks;

public class GCDArray {

	private static int[] st;

	public static void main(String[] args) {
		int a[] = { 2, 3, 6, 9, 5 };
		createSegmentTree(a);

		for (int i = 0; i < st.length; i++) {
			System.out.print(st[i] + " ");
		}
		System.out.println();
	}

	private static int nodeCountInTree(int length) {
		int nodeCount = 0;
		int height = (int) Math.ceil(Math.log(length) / Math.log(2));
		nodeCount = 2 * (int) (Math.pow(2, height) - 1);
		return nodeCount;
	}

	private static void createSegmentTree(int[] a) {
		int nodeCount = nodeCountInTree(a.length);
		st = new int[nodeCount];
		createSegmentTree(a, 0, a.length - 1, 0);
	}

	private static int createSegmentTree(int[] a, int i, int j, int k) {
		if (i == j) {
			st[k] = a[i];
			return st[k];
		}
		int mid = i + (j - i) / 2;
		st[k] = GCD(createSegmentTree(a, i, mid, 2 * k + 1), createSegmentTree(a, mid + 1, j, 2 * k + 2));
		return st[k];
	}

	public static int GCD(int a, int b) {
		if (a == b || a % b == 0 || b % a == 0) {
			return a;
		} else if (a > b) {
			return GCD(a % b, b);
		} else {
			return GCD(b % a, a);
		}
	}
}
