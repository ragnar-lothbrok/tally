package com.he.capillary.chegg1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class GraphTclass extends GraphT {

	public GraphTclass(int size) {
		super(size);
	}

	public int components() {
		List<Integer> visitedVertexList = new ArrayList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		int componentCount = 0;
		for (int i = 0; i < this.n; i++) {
			if (!visitedVertexList.contains(i)) {
				componentCount++;
				stack.push(i);
				while (!stack.isEmpty()) {
					Integer poppedElement = stack.pop();
					visitedVertexList.add(poppedElement);

					GNode gNode = this.AdjList[poppedElement];
					if (gNode != null) {
						GNode temp = gNode;
						while (temp != null) {
							if (temp.nbr != poppedElement && !visitedVertexList.contains(temp.nbr)
									&& !stack.contains(temp.nbr)) {
								stack.add(temp.nbr);
							}
							temp = temp.next;
						}
					}
				}
			}
		}
		return componentCount;
	}

	public int diameter() {
		List<Integer> visitedVertexList = new ArrayList<Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		int maxDistance = 0;
		int distance[] = new int[this.n];

		for (int i = 0; i < this.n; i++) {
			queue.clear();
			visitedVertexList.clear();

			for (int j = 0; j < this.n; j++) {
				distance[j] = -1;
			}
			distance[i] = 0;

			queue.add(i);
			while (!queue.isEmpty()) {
				Integer poppedElement = queue.poll();
				visitedVertexList.add(poppedElement);

				GNode gNode = this.AdjList[poppedElement];
				if (gNode != null) {
					GNode temp = gNode;
					while (temp != null) {
						if (temp.nbr != poppedElement && !visitedVertexList.contains(temp.nbr)
								&& !queue.contains(temp.nbr)) {
							queue.add(temp.nbr);
							distance[temp.nbr] = distance[poppedElement] + 1;
						}
						temp = temp.next;
					}
				}
			}

			for (int j = 0; j < this.n; j++) {
				if (maxDistance < distance[j]) {
					maxDistance = distance[j];
				}
			}
		}
		return maxDistance;
	}

}
