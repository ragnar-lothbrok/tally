import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PointCluster {

	public static void main(String[] args) {
		PointCluster pc = new PointCluster();
		List<Point> points = pc.getPoints("/Users/raghunandan.gupta/Documents/gitrepo/tally/input.txt");
		pc.clusterPoints(points);
	}

	/**
	 * Here we are creating map of Tangent (x2-x1/y2-y1) and again furthr constant part y=mx+c and contaning sets of points
	 * @param points
	 */
	public void clusterPoints(List<Point> points) {
		Map<Float, Map<Float, Set<Point>>> hashMap = new HashMap<Float, Map<Float, Set<Point>>>();
		for (int i = 0; i < points.size(); i++) {
			for (int j = i + 1; j < points.size(); j++) {
				Float tangent = getSlope(points.get(i), points.get(j));
				Float constant = (points.get(i).x) - ((points.get(i).y) * tangent);
				if (hashMap.get(tangent) == null) {
					hashMap.put(tangent, new HashMap<Float, Set<Point>>());
				}
				if (hashMap.get(tangent).get(constant) == null) {
					Set<Point> subList = new HashSet<Point>();
					subList.add(points.get(i));
					subList.add(points.get(j));
					hashMap.get(tangent).put(constant, subList);
				} else {
					List<Point> subList = new ArrayList<Point>();
					subList.add(points.get(i));
					subList.add(points.get(j));
					hashMap.get(tangent).get(constant).addAll(subList);
				}
			}
		}

		for (Entry<Float, Map<Float, Set<Point>>> entry : hashMap.entrySet()) {
			for (Entry<Float, Set<Point>> subEntry : entry.getValue().entrySet()) {
				if (subEntry.getValue().size() >= 4) {
					System.out.println("Tangent : " + entry.getKey() + " Points : " + subEntry.getValue());
				}
			}
		}
	}
	

	/***
	 * Reading file and adding points to list.
	 * @param filePath
	 * @return
	 */
	public List<Point> getPoints(String filePath) {
		List<Point> points = new ArrayList<Point>();
		try (BufferedReader bf = new BufferedReader(new FileReader(filePath))) {
			String line = bf.readLine();
			while (line != null) {
				line = line.replace("(", "");
				line = line.replace(") ", "#");
				line = line.replace(")", "");
				String split[] = line.split("#");
				for (String str : split) {
					String subSplit[] = str.split(",");
					Point point = new Point(Integer.parseInt(subSplit[0].trim()), Integer.parseInt(subSplit[1].trim()));
					if (!points.contains(point)) {
						points.add(point);
					}
				}
				line = bf.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return points;

	}

	/**
	 * this will return tangent
	 * @param p1
	 * @param p2
	 * @return
	 */
	public Float getSlope(Point p1, Point p2) {
		int xDiff = p1.x - p2.x;
		int yDiff = p1.y - p2.y;
		if (xDiff == 0) {
			return Float.MAX_VALUE;
		}
		return ((yDiff * 1.0f) / xDiff);
	}

	static class Point {
		private int x;
		private int y;

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

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
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

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

	}
}
