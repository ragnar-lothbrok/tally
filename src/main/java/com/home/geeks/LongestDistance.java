package com.home.geeks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//http://www.geeksforgeeks.org/longest-path-directed-acyclic-graph-set-2/
public class LongestDistance {

	public static void main(String[] args) {

		List<Edge> edgesList = new ArrayList<Edge>();
		edgesList.add(new Edge(0, 1, 5));
		edgesList.add(new Edge(0, 2, 3));
		edgesList.add(new Edge(1, 3, 6));
		edgesList.add(new Edge(1, 2, 2));
		edgesList.add(new Edge(2, 4, 4));
		edgesList.add(new Edge(2, 5, 2));
		edgesList.add(new Edge(2, 3, 7));
		edgesList.add(new Edge(3, 5, 1));
		edgesList.add(new Edge(3, 4, -1));
		edgesList.add(new Edge(4, 5, -2));

		longestDistance(edgesList, 1);
	}

	private static void longestDistance(List<Edge> edgesList, int source) {
		int distance[] = new int[6];

		for (int i = 0; i < distance.length; i++) {
			distance[i] = Integer.MIN_VALUE;
		}
		distance[source] = 0;

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(source);
		while (!queue.isEmpty()) {
			Integer popped = queue.poll();
			for (Edge edge : edgesList) {
				if (edge.getStart() == popped) {
					if (distance[edge.getEnd()] < distance[popped] + edge.getCost()) {
						distance[edge.getEnd()] = distance[popped] + edge.getCost();
						queue.add(edge.getEnd());
					}
				}
			}
		}

		for (int i = 0; i < distance.length; i++) {
			System.out.print(distance[i] + " ");
		}
	}

	static class Edge {
		private int start;
		private int end;
		private int cost;

		public int getStart() {
			return start;
		}

		public void setStart(int start) {
			this.start = start;
		}

		public int getEnd() {
			return end;
		}

		public void setEnd(int end) {
			this.end = end;
		}

		public int getCost() {
			return cost;
		}

		public void setCost(int cost) {
			this.cost = cost;
		}

		public Edge(int start, int end, int cost) {
			super();
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

	}
}
