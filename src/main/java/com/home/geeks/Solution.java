package com.home.geeks;

public class Solution {
	public static void main(String args[]) throws Exception {
		int arr[] = new int[14];

		Solution s1 = new Solution();

		QueuePointer qp = new QueuePointer();

		for (int i = 0; i < 20; i++) {
			s1.addElement(qp, arr, i);
		}

		for (int i = 0; i < 25; i++) {
			s1.removeElement(qp, arr);
			if (i >= 11) {
				System.out.println(qp.getFront() + " " + qp.getRear());
			}
		}

	}

	public boolean isFull(QueuePointer queuePointer, int[] arr) {
		return (queuePointer.getFront() == queuePointer.getRear() + 1 || (queuePointer.getFront() == 0 && queuePointer.getRear() == arr.length - 1));
	}

	public boolean isEmpty(QueuePointer queuePointer) {
		return (queuePointer.getFront() == -1);
	}

	private Boolean removeElement(QueuePointer queuePointer, int arr[]) {
		if (isEmpty(queuePointer)) {
			System.out.println("Element can not be deleted. Queue size is Empty.");
			return false;
		} else {
			Integer element = arr[queuePointer.getFront()];
			System.out.println("Element " + element + " deleted successfully");
			if (queuePointer.getFront() == queuePointer.getRear()) {
				queuePointer.setFront(-1);
				queuePointer.setRear(-1);
			} else {
				queuePointer.setFront((queuePointer.getFront() + 1) % arr.length);
			}
			return true;
		}
	}

	private Boolean addElement(QueuePointer queuePointer, int arr[], int element) {
		if (isFull(queuePointer, arr)) {
			System.out.println("Queue is FUll.");
			return false;
		} else {
			if (queuePointer.getFront() == -1) {
				queuePointer.setFront(0);
			}
			queuePointer.setRear((queuePointer.getRear() + 1) % arr.length);
			arr[queuePointer.getRear()] = element;
			System.out.println("Element " + element + " added successfully");
			return true;
		}
	}

	static class QueuePointer {

		private int front = -1;
		private int rear = -1;

		private int getFront() {
			return this.front;
		}

		private int getRear() {
			return this.rear;
		}

		private void setFront(int front) {
			this.front = front;
		}

		private void setRear(int rear) {
			this.rear = rear;
		}
	}

}