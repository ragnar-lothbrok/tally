import java.util.LinkedList;
import java.util.Queue;

public class TT_Techgig {

	public static void main(String[] args) {
		System.out.println(encoded_msg(new int[] { 2, 2 }, new String[] { "1#0", "0#0" }));
		System.out.println(encoded_msg(new int[] { 1, 1 }, new String[] { "1" }));
	}

	static int X[] = { 1, 0 };
	static int Y[] = { 0, 1 };

	public static int encoded_msg(int[] input1, String[] input2) {
		int[][] matrix = new int[input1[0]][input1[1]];

		for (int i = 0; i < input2.length; i++) {
			String elements[] = input2[i].split("#");
			for (int j = 0; j < elements.length; j++) {
				matrix[i][j] = Integer.parseInt(elements[j]);
			}
		}
		boolean visited[][] = new boolean[input1[0]][input1[1]];
		int maxArea = 0;
		for (int i = 0; i < input1[0]; i++) {
			for (int j = 0; j < input1[1]; j++) {
				if (!visited[i][j] && matrix[i][j] == 0) {
					Queue<Point> queue = new LinkedList<TT_Techgig.Point>();
					queue.add(new Point(i, j, 1));
					visited[i][j] = true;
					while (!queue.isEmpty()) {
						Point popped = queue.remove();
						Boolean isFirstAdded = null;
						for (int k = 0; k < X.length; k++) {
							int x = popped.getX() + X[k];
							int y = popped.getY() + Y[k];

							if (maxArea < popped.getCount()) {
								maxArea = popped.getCount();
							}

							if (x < input1[0] && y < input1[1]) {
								if (!visited[x][y]) {
									visited[x][y] = true;
									if (matrix[x][y] == 0) {
										if (isFirstAdded == null) {
											isFirstAdded = true;
											queue.add(new Point(x, y, 1 + popped.getCount()));
										} else if (isFirstAdded) {
											queue.add(new Point(x, y, 2 + popped.getCount()));
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return maxArea;
	}

	static class Point {
		private int x;
		private int y;
		private int count;

		public Point(int x, int y, int count) {
			super();
			this.x = x;
			this.y = y;
			this.count = count;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
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
