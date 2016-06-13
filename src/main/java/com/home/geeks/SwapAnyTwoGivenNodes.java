package com.home.geeks;

public class SwapAnyTwoGivenNodes {

	private static LinkedNode linkedNode;

	public static void main(String[] args) {

		linkedNode = new LinkedNode(1);
		linkedNode.setNext(new LinkedNode(2));
		linkedNode.getNext().setNext(new LinkedNode(3));
		linkedNode.getNext().getNext().setNext(new LinkedNode(4));
		linkedNode.getNext().getNext().getNext().setNext(new LinkedNode(5));
		linkedNode.getNext().getNext().getNext().getNext().setNext(new LinkedNode(6));

		swapAnyTwoNodes(2, 2);
		display();
	}

	private static void swapAnyTwoNodes(int node1, int node2) {
		LinkedNode firstNode1 = null;
		LinkedNode secondNode1 = null;
		LinkedNode thirdNode1 = null;
		LinkedNode firstNode2 = null;
		LinkedNode secondNode2 = null;
		LinkedNode thirdNode2 = null;

		LinkedNode temp = linkedNode;
		boolean startNode = false;
		if (temp.getData() == node1) {
			startNode = true;
		}

		while (temp != null) {
			if (secondNode1 == null && temp.getData() == node1) {
				firstNode1 = null;
				secondNode1 = temp;
				thirdNode1 = temp.getNext();
			} else if (temp.getNext() != null && temp.getNext().getData() == node1) {
				firstNode1 = temp;
				secondNode1 = temp.getNext();
				thirdNode1 = temp.getNext().getNext();

			}

			if (secondNode2 == null && temp.getData() == node2) {
				firstNode2 = null;
				secondNode2 = temp;
				thirdNode2 = temp.getNext();
			} else if (temp.getNext() != null && temp.getNext().getData() == node2) {
				firstNode2 = temp;
				secondNode2 = temp.getNext();
				thirdNode2 = temp.getNext().getNext();
			}

			temp = temp.getNext();
		}
		if (startNode) {
			linkedNode = secondNode2;
		}

		if (secondNode1 != null && secondNode2 != null) {
			secondNode1.setNext(thirdNode2);
			if (secondNode2 != thirdNode1) {
				secondNode2.setNext(thirdNode1);
			} else {
				secondNode2.setNext(secondNode1);
			}
			if (firstNode1 != null) {
				firstNode1.setNext(secondNode2);
			}

			if (firstNode2 != null) {
				if (firstNode2 != secondNode1) {
					firstNode2.setNext(secondNode1);
				}
			}
		}
	}

	public static void display() {
		LinkedNode temp = linkedNode;
		while (temp != null) {
			System.out.print(temp.getData() + " ");
			temp = temp.getNext();
		}
		System.out.println();
	}

	static class LinkedNode {
		private LinkedNode next;
		private Integer data;

		public LinkedNode getNext() {
			return next;
		}

		public void setNext(LinkedNode next) {
			this.next = next;
		}

		public Integer getData() {
			return data;
		}

		public void setData(Integer data) {
			this.data = data;
		}

		public LinkedNode(Integer data) {
			super();
			this.data = data;
		}

		@Override
		public String toString() {
			return "-" + data + "-";
		}

	}
}
