package com.home.geeks;

//http://www.geeksforgeeks.org/subtract-two-numbers-represented-as-linked-lists/
public class SubstractLinkedList {

	public static void main(String[] args) {

		LinkedNode first = new LinkedNode(1);
		first.setNext(new LinkedNode(0));
		first.getNext().setNext(new LinkedNode(0));

		LinkedNode second = new LinkedNode(1);

		int l1 = length(first);
		int l2 = length(second);

		System.out.println(l1 + " " + l2);
		int g1 = (l1 > l2) ? l1 - l2 : l2 - l1;

		LinkedNode secondMod = null;
		LinkedNode temp = secondMod;
		while (g1 > 0) {
			if (secondMod == null) {
				secondMod = new LinkedNode(0);
				temp = secondMod;
			} else {
				secondMod.setNext(new LinkedNode(0));
				secondMod = secondMod.getNext();
			}
			g1--;
		}

		if (temp == null) {
			temp = second;
		} else {
			secondMod.setNext(second);
		}

		System.out.println("Length : " + length(temp));

		LinkedNode subNode = substract(first, temp);
		if (subNode.getCarry() == 0) {
			System.out.println("Positive");
		} else {
			System.out.println("Neagtive");
		}

		display(subNode);
	}

	private static void display(LinkedNode node) {
		while (node != null) {
			System.out.print(node.getData() + " ");
			node = node.getNext();
		}
		System.out.println();
	}

	private static LinkedNode substract(LinkedNode first, LinkedNode second) {
		int result = 0;
		if (!(first.getNext() == null && second.getNext() == null)) {
			LinkedNode node = substract(first.getNext(), second.getNext());
			if (node != null) {
				LinkedNode temp = null;
				if (node.getCarry() == 0) {
					if (first.getData() >= second.getData()) {
						result = first.getData() - second.getData();
						temp = new LinkedNode(result);
					} else {
						result = (10 + first.getData()) - second.getData();
						temp = new LinkedNode(result, 1);
					}
				} else {
					if (first.getData() == 0) {
						temp = new LinkedNode(9 - second.getData(), 1);
					} else {
						if (first.getData() - 1 >= second.getData()) {
							result = first.getData() - 1 - second.getData();
							temp = new LinkedNode(result, 1);
						} else {
							result = (10 + first.getData() - 1) - second.getData();
							temp = new LinkedNode(result, 1);
						}
					}
				}
				temp.setNext(node);
				return temp;
			} else {
				if (first.getData() >= second.getData()) {
					result = first.getData() - second.getData();
					return new LinkedNode(result);
				} else {
					result = 10 - second.getData();
					return new LinkedNode(result, 1);
				}
			}
		} else {
			if (first.getData() >= second.getData()) {
				result = first.getData() - second.getData();
				return new LinkedNode(result);
			} else {
				result = 10 - second.getData();
				return new LinkedNode(result, 1);
			}
		}
	}

	private static int length(LinkedNode node) {
		int length = 0;
		while (node != null) {
			length++;
			node = node.getNext();
		}
		return length;
	}

	static class LinkedNode {
		private Integer data = 0;
		private LinkedNode next;
		private Integer carry = 0;

		public LinkedNode(Integer data, Integer carry) {
			super();
			this.data = data;
			this.carry = carry;
		}

		public Integer getCarry() {
			return carry;
		}

		public void setCarry(Integer carry) {
			this.carry = carry;
		}

		public Integer getData() {
			return data;
		}

		public void setData(Integer data) {
			this.data = data;
		}

		public LinkedNode getNext() {
			return next;
		}

		public void setNext(LinkedNode next) {
			this.next = next;
		}

		public LinkedNode(Integer data) {
			super();
			this.data = data;
		}

	}

}
