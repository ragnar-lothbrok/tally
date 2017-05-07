package com.home.chegg;

public class GenLLQueue<T> {

	private ListNode<T> head;
	private ListNode<T> tail;
	private Integer currSize = 0;
	private static final Integer DEFAULT_SIZE = 100;

	public GenLLQueue() {

	}

	public void enqueue(T t) {
		if (head == null) {
			head = new ListNode<T>(t);
			tail = head;
			currSize++;
		} else {
			if (currSize != DEFAULT_SIZE) {
				ListNode<T> temp = new ListNode<T>(t);
				tail.setNext(temp);
				tail = temp;
				currSize++;
			}
		}
	}

	public T dequeue() {
		ListNode<T> firstNode = null;
		if (head != null) {
			firstNode = head;
			head = head.getNext();
			if (head == null) {
				tail = null;
			}
		}
		return (firstNode == null ? null : firstNode.getT());
	}

	public T peek() {
		return (head != null ? head.getT() : null);
	}

	public void showQueue() {
		if (head != null) {
			ListNode<T> currNode = head;
			while (currNode != null) {
				System.out.println(currNode.getT());
				currNode = currNode.getNext();
			}
		}
	}

	static class ListNode<T> {
		public ListNode(T t2) {
			this.t = t2;
		}

		private T t;
		private ListNode<T> next;

		public T getT() {
			return t;
		}

		public void setT(T t) {
			this.t = t;
		}

		public ListNode<T> getNext() {
			return next;
		}

		public void setNext(ListNode<T> next) {
			this.next = next;
		}

	}
}
