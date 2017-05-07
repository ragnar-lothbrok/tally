package com.he.cube26;

//http://www.geeksforgeeks.org/find-size-of-the-largest-formed-by-all-ones-in-a-binary-matrix/
public class LargestCross {

	public static void main(String[] args) {
		int mat[][] = { { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 }, { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
				{ 0, 0, 0, 0, 1, 0, 0, 1, 0, 0 }, { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
				{ 1, 0, 0, 0, 1, 0, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1, 1, 0, 0, 1, 1 }, { 1, 1, 0, 0, 1, 0, 1, 0, 0, 1 },
				{ 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 } };

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				findLargestCross(mat, null, null, null, null, new Co(i, j), 0);
			}
		}

		System.out.println(max * 4 - 3);

	}

	private static int max = 0;

	private static void findLargestCross(int mat[][], Co left, Co right, Co top, Co botton, Co center, int count) {
		if (count == 0) {
			findLargestCross(mat, new Co(center.getX() - 1, center.getY()), new Co(center.getX() + 1, center.getY()),
					new Co(center.getX(), center.getY() - 1), new Co(center.getX(), center.getY() + 1), null, ++count);
		} else if (valid(mat, left) && valid(mat, right) && valid(mat, top) && valid(mat, botton)) {
			findLargestCross(mat, new Co(left.getX() - 1, left.getY()), new Co(right.getX() + 1, right.getY()), new Co(top.getX(), top.getY() - 1),
					new Co(botton.getX(), left.getY() + 1), null, ++count);
		} else {
			if (max < count) {
				max = count;
				return;
			}
		}
	}

	private static boolean valid(int mat[][], Co left) {
		if ((left.getX() >= 0 && left.getX() < mat.length) && (left.getY() >= 0 && left.getY() < mat.length) && mat[left.getX()][left.getY()] == 1) {
			return true;
		}
		return false;
	}

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
