import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

//Codility
public class Toptal_On {

	public static void main(String[] args) {

		// System.out.println(new Toptal_On().solution("(())"));
		System.out.println(new Toptal_On().solution("(())))("));
		// System.out.println(new Toptal_On().solution("(("));
		System.out.println(new Toptal_On().solution("(()))"));

		System.out.println(solution(4, 5));

		System.out.println(solution(4, 5));

	}

	static int[] solution(int n[]) {
		int value = 0;
		for (int i = 0; i < n.length; i++) {
			value += (n[i] * Math.pow(-2, i));
		}
		value = -1 * value;
		List<Integer> list = new ArrayList<Integer>();
		while (value != 0) {
			int remainder = (int) (value % -2);
			value = (int) (value / -2);

			if (remainder < 0) {
				remainder += 2;
				value += 1;
			}
			list.add(remainder);
		}
		int[] result = new int[list.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = list.get(i);
		}
		return result;
	}

	static int solution(int x, int y) {
		int delta = x - y;
		if (x == 1 && y == 0) {
			return 3;
		}
		if (x == 2 && y == 2) {
			return 4;
		}
		if (y > delta)
			return 2 * ((y - delta) / 3) + delta;
		else
			return delta - 2 * ((delta - y) / 4);
	}

	public int solution(String S) {
		int split = 0;
		int arr1[] = new int[S.length()];
		int arr2[] = new int[S.length()];
		int leftCount = 0;
		int rightCount = 0;
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == '(') {
				leftCount++;
			}
			arr1[i] = leftCount;
		}

		for (int i = S.length() - 1; i >= 0; i--) {
			if (S.charAt(i) == ')') {
				rightCount++;
			}
			arr2[i] = rightCount;
		}

		int index = -1;
		for (int i = 0; i < S.length(); i++) {
			if (arr1[i] == arr2[i]) {
				index = i;
				break;
			}
		}

		if (index == -1) {
			return S.length();
		} else {
			if (index == 0) {
				split = 1;
			} else if (arr1[index] != arr1[index - 1]) {
				split = index + 1;
			} else if (arr2[index] != arr2[index + 1]) {
				split = index;
			}
		}
		return split;
	}

	static int X[] = { 2, 2, 1, 1, -1, -1, -2, -2 };

	static int Y[] = { -1, 1, 2, -2, 2, -2, 1, -1 };

	public static int solution1(int destX, int destY) {
		Point p1 = new Point(0, 0, 0);
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(p1);

		Set<Point> visited = new HashSet<Point>();
		visited.add(p1);
		while (!queue.isEmpty()) {
			Point temp = queue.remove();
			if (temp.getStepCount() == 100000000) {
				continue;
			}
			if (temp.getX() == destX && temp.getY() == destY) {
				return temp.getStepCount();
			}
			for (int i = 0; i < X.length; i++) {
				int x1 = temp.getX() + X[i];
				int y1 = temp.getY() + Y[i];
				if ((x1 >= 0) && (y1 >= 0)) {
					Point p2 = new Point(x1, y1, temp.getStepCount() + 1);
					if (!visited.contains(p2)) {
						queue.add(p2);
						visited.add(p2);
					}
				}
			}
		}
		return -2;
	}

	private static class Point {
		private int x;
		private int y;
		private int stepCount = 0;

		public int getStepCount() {
			return stepCount;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public Point(int x, int y, int stepCount) {
			super();
			this.x = x;
			this.y = y;
			this.stepCount = stepCount;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
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

	}

}
