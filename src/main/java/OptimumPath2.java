import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Qualys Problem
public class OptimumPath2 {

	public static void main(String[] args) {
		// getTollPlan(new String[] { "6#8", "1#2#8", "1#4#7", "1#5#12",
		// "2#3#4", "2#4#2", "3#6#6", "4#6#8", "5#6#10" });
		System.out.println();
		getTollPlan(new String[] { "4#6", "1#2#7", "1#2#8", "1#3#10", "2#4#4", "2#4#3", "3#4#15" });

	}

	static class Edge {
		private int startIndex;
		private int endIndex;
		private int weight;
		private int used;

		public int getStartIndex() {
			return startIndex;
		}

		public void setStartIndex(int startIndex) {
			this.startIndex = startIndex;
		}

		public int getEndIndex() {
			return endIndex;
		}

		public void setEndIndex(int endIndex) {
			this.endIndex = endIndex;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

		public int getUsed() {
			return used;
		}

		public void setUsed(int used) {
			this.used = used;
		}

	}

	static class Distances {
		private List<Integer> distance = new ArrayList<Integer>();

		public List<Integer> getDistance() {
			return distance;
		}

		public void setDistance(List<Integer> distance) {
			this.distance = distance;
		}

	}

	private static String[] getTollPlan(String[] input) {
		String splits[] = input[0].split("\\#");
		int numberOfJunctions = Integer.parseInt(splits[0]);
		int numberOfRoads = Integer.parseInt(splits[1]);

		Distances mat[][] = new Distances[numberOfJunctions + 1][numberOfJunctions + 1];

		for (int i = 1; i < numberOfRoads + 1; i++) {
			splits = input[i].split("\\#");
			if (mat[Integer.parseInt(splits[0])][Integer.parseInt(splits[1])] == null) {
				mat[Integer.parseInt(splits[0])][Integer.parseInt(splits[1])] = new Distances();
			}
			mat[Integer.parseInt(splits[0])][Integer.parseInt(splits[1])].distance.add(Integer.parseInt(splits[2]));
		}

		List<Point> paths = new ArrayList<Point>();
		Queue<Point> queue = new LinkedList<Point>();
		Point point = new Point(1, 0, 0, null);
		queue.add(point);
		while (!queue.isEmpty()) {
			Point popped = queue.remove();
			if (popped.getX() == numberOfJunctions) {
				System.out.println(popped);
				paths.add(popped);
			}

			for (int i = 1; i < numberOfJunctions + 1; i++) {
				if (i != popped.getX() && mat[popped.getX()][i] != null && mat[popped.getX()][i].distance.size() != 0) {
					for (Integer distance : mat[popped.getX()][i].distance) {
						queue.add(new Point(i, distance, popped.getTotal() + distance, popped));
					}
				}
			}
		}

		return null;
	}

	static class Point {
		private int x;
		private int weight;
		private int total;
		private Point point;

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public Point getPoint() {
			return point;
		}

		public void setPoint(Point point) {
			this.point = point;
		}

		public int getTotal() {
			return total;
		}

		public void setTotal(int total) {
			this.total = total;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", weight=" + weight + ", total=" + total + ", point=" + point + "]";
		}

		public Point(int x, int weight, int total, Point point) {
			super();
			this.x = x;
			this.weight = weight;
			this.total = total;
			this.point = point;
		}

	}
}
