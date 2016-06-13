package com.home.geeks;

public class SwapTwoNodes {

	private static LinkedNode linkedNode;

	public static void main(String[] args) {

		linkedNode = new LinkedNode(1);
		linkedNode.setNext(new LinkedNode(2));
		linkedNode.getNext().setNext(new LinkedNode(3));
		linkedNode.getNext().getNext().setNext(new LinkedNode(4));
		linkedNode.getNext().getNext().getNext().setNext(new LinkedNode(5));
		linkedNode.getNext().getNext().getNext().getNext().setNext(new LinkedNode(6));
		display();

		swapNodes();

		display();
	}

	private static void swapNodes() {
		LinkedNode temp = linkedNode;
		LinkedNode first = (temp != null ? temp.getNext() : null);
		LinkedNode second = (first != null ? first.getNext() : null);
		if (first != null) {
			linkedNode = first;
		}
		while (first != null) {
			first.setNext(temp);
			if (second != null && second.getNext() != null) {
				temp.setNext(second.getNext());
			} else {
				temp.setNext(second);
			}
			temp = second;
			if (temp == null) {
				first = null;
			} else if (second != null) {
				first = second.getNext();
			}
			if (first != null) {
				second = first.getNext();
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
