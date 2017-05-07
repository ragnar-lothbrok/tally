package com.he.capillary.chegg1;

public class GraphT {
	protected int n;
	protected GNode AdjList[];
	protected int mark[];

	public GraphT(int size) {
		n = size;
		AdjList = new GNode[n];
		mark = new int[n];
		for (int i = 0; i < n; i++) {
			AdjList[i] = null;
			mark[i] = 0;
		}
	}

	public void reset(int unmarked) {
		for (int i = 0; i < n; i++) {
			mark[i] = unmarked;
		}
	}

	public void addEdge(int x, int y) {

		GNode entry, trail, forward, backward;

		forward = new GNode(y);
		backward = new GNode(x);
		forward.partner = backward;
		backward.partner = forward;

		trail = null;
		for (entry = AdjList[x]; entry != null; entry = entry.next) {
			trail = entry;
		}
		if (trail != null) {
			trail.next = forward;
		} else {
			AdjList[x] = forward;
		}
		trail = null;
		for (entry = AdjList[y]; entry != null; entry = entry.next) {
			trail = entry;
		}
		if (trail != null) {
			trail.next = backward;
		} else {
			AdjList[y] = backward;
		}

	}

	public String toString() {
		Integer iobj;
		String result = "";
		for (int i = 0; i < n; i++) {
			result += i + " (" + mark[i] + ") : ";
			for (GNode list = AdjList[i]; list != null; list = list.next) {
				result += "\t" + list.nbr;
			}
			result += "\n";
		}
		return result;
	}

	protected class GNode {
		int nbr;
		int mark;
		GNode partner;
		GNode next;

		protected GNode(int index) {
			nbr = index;
			mark = 0;
			partner = null;
			next = null;
		}

		public String toString() {
			Integer iobj = new Integer(nbr);
			return iobj.toString();
		}
	}
}
