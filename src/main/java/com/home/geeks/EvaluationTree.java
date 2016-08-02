package com.home.geeks;

//http://www.geeksforgeeks.org/evaluation-of-expression-tree/
public class EvaluationTree {

	public static void main(String[] args) {

		Node<String> root = new Node<String>();
		root.setData("+");
		root.setLeft(new Node<String>("*"));
		root.getLeft().setLeft(new Node<String>("5"));
		root.getLeft().setRight(new Node<String>("4"));
		root.setRight(new Node<String>("-"));
		root.getRight().setLeft(new Node<String>("100"));
		root.getRight().setRight(new Node<String>("20"));

		System.out.println(evaluateExpression(root));
	}

	private static Integer evaluateExpression(Node<String> root) {
		if (root == null) {
			return 0;
		}
		if (root.getLeft() == null && root.getRight() == null) {
			return Integer.parseInt(root.getData());
		}

		int left = evaluateExpression(root.getLeft());
		int right = evaluateExpression(root.getRight());

		if (root.getData() == "*") {
			return left * right;
		} else if (root.getData() == "-") {
			return left - right;
		} else if (root.getData() == "+") {
			return left + right;
		} else {
			return left / right;
		}
	}

	static class Node<T> {
		private T data;
		private Node<T> left;
		private Node<T> right;

		public Node() {

		}

		public Node(T data) {
			super();
			this.data = data;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public Node<T> getLeft() {
			return left;
		}

		public void setLeft(Node<T> left) {
			this.left = left;
		}

		public Node<T> getRight() {
			return right;
		}

		public void setRight(Node<T> right) {
			this.right = right;
		}

	}
}
