import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

//Qualys Problem
public class OptimumPath {

	public static void main(String[] args) {
		String output[] = null;
		String arr[] = new String[] { "6#8", "1#2#8", "1#4#7", "1#5#12", "2#3#4", "2#4#2", "3#6#6", "4#6#8", "5#6#10" };
		output = getTollPlan(arr);
		if (output != null)
			System.out.println(Arrays.asList(output));
		arr = new String[] { "4#6", "1#2#7", "1#2#8", "1#3#10", "2#4#4", "2#4#3", "3#4#15" };
		output = getTollPlan(arr);
		if (output != null)
			System.out.println(Arrays.asList(output));

		arr = new String[] { "4#4", "1#2#7", "1#3#10", "2#4#4", "3#4#15" };
		output = getTollPlan(arr);
		if (output != null)
			System.out.println(Arrays.asList(output));
		arr = new String[] { "5#5", "1#2#5", "1#4#2", "2#5#10", "1#3#10", "3#5#15" };
		output = getTollPlan(arr);
		if (output != null)
			System.out.println(Arrays.asList(output));

		arr = new String[] { "2#1", "1#2#5" };
		output = getTollPlan(arr);
		if (output != null)
			System.out.println(Arrays.asList(output));

		arr = new String[] { "2#2", "1#2#5", "1#2#6" };
		output = getTollPlan(arr);
		if (output != null)
			System.out.println(Arrays.asList(output));

		arr = new String[] { "4#4", "2#4#10", "1#2#5", "3#4#5", "1#3#5" };
		output = getTollPlan(arr);
		if (output != null)
			System.out.println(Arrays.asList(output));

		arr = new String[] { "7#8", "1#2#7", "2#3#4", "1#3#5", "3#7#5", "1#5#3", "5#7#20", "1#6#10", "6#7#10" };
		output = getTollPlan(arr);
		if (output != null)
			System.out.println(Arrays.asList(output));
		
		arr = new String[] { "7#9", "1#2#7", "2#3#4", "1#3#5","1#3#5", "3#5#5", "1#5#3", "5#7#20", "1#6#10", "6#7#10" };
		output = getTollPlan(arr);
		if (output != null)
			System.out.println(Arrays.asList(output));
		
		arr = new String[] { "7#8", "1#2#2", "2#3#3", "1#3#5", "3#7#5", "1#5#3", "5#7#20", "1#6#10", "6#7#10" };
		output = getTollPlan(arr);
		if (output != null)
			System.out.println(Arrays.asList(output));
	}

	static class Edge {
		private int startIndex;
		private int endIndex;
		private int weight;
		private int used = 0;
		private int tollWeight = 0;
		private int roadCount;

		public int getTollWeight() {
			return tollWeight;
		}

		public int getRoadCount() {
			return roadCount;
		}

		public void setTollWeight(int tollWeight) {
			this.tollWeight = tollWeight;
		}

		public int getStartIndex() {
			return startIndex;
		}

		public int getEndIndex() {
			return endIndex;
		}

		public int getWeight() {
			return weight;
		}

		public int getUsed() {
			return used;
		}

		public Edge(int startIndex, int endIndex, int weight, int used, int roadCount) {
			super();
			this.startIndex = startIndex;
			this.endIndex = endIndex;
			this.weight = weight;
			this.used = used;
			this.roadCount = roadCount;
		}

		@Override
		public String toString() {
			return "Edge [startIndex=" + startIndex + ", endIndex=" + endIndex + ", weight=" + weight + ", used=" + used
					+ ", tollWeight=" + tollWeight + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + endIndex;
			result = prime * result + startIndex;
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
			Edge other = (Edge) obj;
			if (endIndex != other.endIndex)
				return false;
			if (startIndex != other.startIndex)
				return false;
			return true;
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
		try {
			String splits[] = input[0].split("\\#");
			int numberOfJunctions = Integer.parseInt(splits[0]);
			int numberOfRoads = Integer.parseInt(splits[1]);

			Map<Integer, List<Edge>> hashMap = new HashMap<Integer, List<Edge>>();

			int roadCount = 1;
			for (int i = 1; i < numberOfRoads + 1; i++) {
				splits = input[i].split("\\#");
				int start = Integer.parseInt(splits[0]);
				int end = Integer.parseInt(splits[1]);
				if (hashMap.get(start) == null) {
					List<Edge> edges = new ArrayList<Edge>();
					edges.add(new Edge(start, end, Integer.parseInt(splits[2]), 0, roadCount++));
					hashMap.put(start, edges);
				} else {
					hashMap.get(start).add(new Edge(start, end, Integer.parseInt(splits[2]), 0, roadCount++));
				}
			}

			List<Point> tollToBeAdded = new ArrayList<Point>();
			Queue<Point> queue = new LinkedList<Point>();
			Point point = new Point(1);
			queue.add(point);
			while (!queue.isEmpty()) {
				Point popped = queue.remove();
				if (popped.getX() == numberOfJunctions) {
					tollToBeAdded.add(popped);
					continue;
				}

				if (hashMap.get(popped.getX()) != null) {
					for (Edge edge : hashMap.get(popped.getX())) {
						edge.used++;
						Point newP = new Point(edge.endIndex);
						newP.edge.addAll(popped.edge);
						newP.edge.add(edge);
						queue.add(newP);
					}
				}
			}
			Collections.sort(tollToBeAdded);
			List<Point> maxWeightedPath = new ArrayList<Point>();
			int maxWeight = Integer.MIN_VALUE;
			for (Point pt : tollToBeAdded) {
				if (maxWeight <= pt.getTotalWeight()) {
					maxWeight = pt.getTotalWeight();
					maxWeightedPath.clear();
					maxWeightedPath.add(pt);
				}
			}
			tollToBeAdded.removeAll(maxWeightedPath);

//			System.out.println("After removing max weighted paths : " + tollToBeAdded);
//			System.out.println("Max weighted paths : " + maxWeightedPath);

			Map<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
			Boolean result = settled(tollToBeAdded, maxWeight, maxWeightedPath, 0, treeMap, hashMap);
			if (result) {
				if (treeMap.size() > 0) {
					String output[] = new String[treeMap.size() + 1];
					output[0] = treeMap.size() + "#" + maxWeight;
					int count = 1;
					for (Entry<Integer, Integer> entry : treeMap.entrySet()) {
						output[count] = entry.getKey() + "#" + entry.getValue();
						count++;
					}
					return output;
				} else {
					System.out.println("No Solution");
				}
			} else {
				System.out.println("No Solution");
			}
		} catch (Exception e) {
			System.out.println("Exception occured : " + e.getMessage());
		}
		return null;
	}

	private static Boolean isBalanced(List<Point> finalPaths, int maxPathSum, Edge edge) {
		for (Point finalPoint : finalPaths) {
			if (finalPoint.edge.contains(edge) && finalPoint.getTotalWeight() != maxPathSum) {
				return false;
			}
		}
		return true;
	}

	// 3#22,2#7,5#4,6#4
	private static Boolean settled(List<Point> finalPaths, int maxPathSum, List<Point> finalPath, int index,
			Map<Integer, Integer> treeMap, Map<Integer, List<Edge>> hashMap) {
		if (index >= finalPaths.size() || finalPaths.size() == 0) {
			return true;
		}
		Point point = finalPaths.get(index);
		if (point.getTotalWeight() != maxPathSum) {
			for (int i = point.edge.size() - 1; i >= 0; i--) {
				Edge edge = point.edge.get(i);
				Boolean maxWeightContainsEdge = false;
				for (Point finalPoint : finalPath) {
					if (finalPoint.edge.contains(edge)) {
						maxWeightContainsEdge = true;
						break;
					}
				}
				if (!maxWeightContainsEdge && edge.getTollWeight() == 0) {
					edge.setTollWeight(maxPathSum - point.getTotalWeight());
					if (!isBalanced(finalPaths, maxPathSum, edge)) {
						edge.setTollWeight(0);
					} else {
						Boolean result = settled(finalPaths, maxPathSum, finalPath, index + 1, treeMap, hashMap);
						if (!result) {
							edge.setTollWeight(0);
						} else {
							treeMap.put(edge.getRoadCount(), edge.getTollWeight());
							return result;
						}
					}
				}
			}
		} else {
			return settled(finalPaths, maxPathSum, finalPath, index + 1, treeMap, hashMap);
		}
		return false;
	}

	static class Point implements Comparable<Point> {
		private int x;
		private List<Edge> edge = new ArrayList<Edge>();

		public int getTotalWeight() {
			int total = 0;
			for (Edge ed : edge) {
				total += (ed.weight + ed.getTollWeight());
			}
			return total;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public List<Edge> getEdge() {
			return edge;
		}

		public void setEdge(List<Edge> edge) {
			this.edge = edge;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", edge=" + edge + " Total= " + getTotalWeight() + "]\n";
		}

		public Point(int x) {
			super();
			this.x = x;
		}

		@Override
		public int compareTo(Point o) {
			Integer firstMin = Integer.MAX_VALUE;
			for (Edge ed : this.edge) {
				if (firstMin > ed.getUsed()) {
					firstMin = ed.getUsed();
				}
			}
			Integer secondMin = Integer.MAX_VALUE;
			for (Edge ed : o.edge) {
				if (secondMin > ed.getUsed()) {
					secondMin = ed.getUsed();
				}
			}
			return firstMin.compareTo(secondMin);
		}

	}
}
