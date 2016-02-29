package com.he.chegg.member;

public class LinkedList {

	private Node head;

	public Node add(char ch) {

		if (head == null) {
			head = new Node(ch, null);
			return head;
		} else {
			Node temp = head;
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(new Node(ch, null));
		}
		return head;
	}

	public Node createSecondList(Node head) {

		// Copying a linked list
		if (head != null) {
			
			//Copying a List
			Node temp = head;
			Node secondHead = new Node(head);
			Node temp1 = secondHead;
			while (temp.getNext() != null) {
				temp = temp.getNext();
				temp1.setNext(new Node(temp));
				temp1 = temp1.getNext();
			}

			//Revering new list
			Node firstNode = secondHead;
			Node secondNode = secondHead;
			Node result = null;
			while (firstNode != null) {
				secondNode = firstNode.getNext();
				firstNode.setNext(result);
				result = firstNode;
				firstNode = secondNode;
			}
			secondHead = result;
			return secondHead;
		}
		return null;

	}

	public void traverse(Node head) {
		if (head != null) {
			Node temp = head;
			while (temp != null) {
				System.out.print(temp.getCh() + " ");
				temp = temp.getNext();
			}
			System.out.println();
		}
	}

	static class Node {
		private char ch;
		private Node next;

		public char getCh() {
			return ch;
		}

		public void setCh(char ch) {
			this.ch = ch;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Node() {
		}

		public Node(char ch, Node next) {
			super();
			this.ch = ch;
			this.next = next;
		}

		public Node(Node node) {
			super();
			this.ch = node.getCh();
			this.next = node.getNext();
		}

		@Override
		public String toString() {
			return "Node [ch=" + ch + ", next=" + next + "]";
		}

	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		Node firstList = null;
		for (int i = 'a'; i < 'k'; i++) {
			firstList = ll.add((char) i);
		}
		ll.traverse(firstList);
		Node secondList = ll.createSecondList(firstList);
		ll.traverse(secondList);

	}
}
