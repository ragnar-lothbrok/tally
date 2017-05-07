package com.interview.tree;

/**
 * Date 07/07/2014
 * 
 * @author tusroy
 * 
 *         Youtube link - https://youtu.be/bmaeYtlO2OE Youtube link -
 *         https://youtu.be/_SiwrPXG9-g Youtube link -
 *         https://youtu.be/NA8B84DZYSA
 *
 */
class NodeRef {
	Node node;
}

enum Color {
	RED, BLACK
}

class Node {
	Node left;
	Node right;
	Node next;
	int data;
	int lis;
	int height;
	int size;
	Color color;

	public static Node newNode(int data) {
		Node n = new Node();
		n.left = null;
		n.right = null;
		n.data = data;
		n.lis = -1;
		n.height = 1;
		n.size = 1;
		n.color = Color.RED;
		return n;
	}
}

public class BinaryTree {
	public Node addNode(int data, Node head) {
		Node tempHead = head;
		Node n = Node.newNode(data);
		if (head == null) {
			head = n;
			return head;
		}
		Node prev = null;
		while (head != null) {
			prev = head;
			if (head.data < data) {
				head = head.right;
			} else {
				head = head.left;
			}
		}
		if (prev.data < data) {
			prev.right = n;
		} else {
			prev.left = n;
		}
		return tempHead;
	}

	class IntegerRef {
		int height;
	}

	public int height(Node root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		return Math.max(leftHeight, rightHeight) + 1;
	}

	public static void main(String args[]) {
		BinaryTree bt = new BinaryTree();
		Node head = null;
		head = bt.addNode(10, head);
		head = bt.addNode(15, head);
		head = bt.addNode(5, head);
		head = bt.addNode(7, head);
		head = bt.addNode(19, head);
		head = bt.addNode(20, head);
		head = bt.addNode(-1, head);
		head = bt.addNode(21, head);
		System.out.println(bt.height(head));

		constructTree();
	}

	private static void constructTree() {
		Node head = Node.newNode(26);
		head.left = Node.newNode(10);
		head.left.right = Node.newNode(6);
		head.left.left = Node.newNode(4);
		head.right = Node.newNode(3);
		head.right.right = Node.newNode(3);

		System.out.println(isSumTree(head));
	}

	private static Integer sum(Node root) {
		if (root == null) {
			return 0;
		} else if (root.left == null && root.right == null) {
			return root.data;
		}
		return sum(root.left) + sum(root.right) + root.data;
	}

	private static Boolean isSumTree(Node root) {
		if (root == null) {
			return true;
		} else {
			int leftSum = sum(root.left);
			int rightSum = sum(root.right);
			if (leftSum + rightSum == root.data) {
				return true;
			} else {
				return false;
			}
		}
	}
}
