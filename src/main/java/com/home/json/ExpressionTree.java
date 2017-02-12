package com.home.json;

import java.util.Stack;

public class ExpressionTree {

	public static void main(String[] args) {

		String expression = "ab+ef*g*-";
		Stack<Character> operand = new Stack<Character>();
		createTree(expression, operand);
	}

	public static void createTree(String expression, Stack<Character> operand) {
		Stack<ExNode> exTree = new Stack<ExNode>();
		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			if (expression.length() == 1) {
				break;
			}
			if (!isOperator(ch)) {
				exTree.push(new ExNode(ch, null, null));
			} else {
				ExNode right = exTree.pop();
				ExNode left = exTree.pop();
				exTree.push(new ExNode(ch, left, right));
			}
		}
		inOrder(exTree.pop());
	}

	private static void inOrder(ExNode exNode) {
		if (exNode != null) {
			inOrder(exNode.getLeft());
			System.out.print(exNode.getRoot() + "\t");
			inOrder(exNode.getRight());
		}
	}

	static boolean isOperator(char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
			return true;
		}
		return false;
	}

	static class ExNode {
		private char root;
		private ExNode left;
		private ExNode right;

		public ExNode(char root, ExNode left, ExNode right) {
			super();
			this.root = root;
			this.left = left;
			this.right = right;
		}

		public char getRoot() {
			return root;
		}

		public void setRoot(char root) {
			this.root = root;
		}

		public ExNode getLeft() {
			return left;
		}

		public void setLeft(ExNode left) {
			this.left = left;
		}

		public ExNode getRight() {
			return right;
		}

		public void setRight(ExNode right) {
			this.right = right;
		}

		@Override
		public String toString() {
			return "ExNode [root=" + root + ", left=" + left + ", right=" + right + "]";
		}

	}
}
