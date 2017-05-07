package com.home.json;

import java.util.Stack;

//http://www.programcreek.com/2014/06/leetcode-longest-valid-parentheses-java/
public class LongestValidParenthesis {

	public static void main(String[] args) {
		String str = ")()())";
		str = ")(()()))";
		findMaxLength(str);
	}

	private static void findMaxLength(String str) {
		Stack<ValidParenthesis> stack = new Stack<ValidParenthesis>();
		int maxLength = 0;
		for (int i = 0; i < str.length(); i++) {
			if (leftParenthesis(str.charAt(i))) {
				ValidParenthesis validParenthesis = new ValidParenthesis(i, true);
				stack.push(validParenthesis);
			} else if (rightParenthesis(str.charAt(i))) {
				if (stack.isEmpty()) {
					ValidParenthesis validParenthesis = new ValidParenthesis(i, false);
					stack.push(validParenthesis);
				}
				if (!stack.isEmpty() && !stack.peek().isLeft()) {
					ValidParenthesis validParenthesis = new ValidParenthesis(i, false);
					stack.push(validParenthesis);
				} else {
					if (!stack.isEmpty()) {
						stack.pop();
						maxLength = Math.max(maxLength, i - stack.peek().getMin());
					} else {
						maxLength = Math.max(maxLength, i + 1);
					}
				}
			}
		}
		System.out.println(maxLength);
	}

	private static class ValidParenthesis {

		public ValidParenthesis(int min, boolean isLeft) {
			super();
			this.min = min;
			this.isLeft = isLeft;
		}

		private int min;
		private boolean isLeft;

		public int getMin() {
			return min;
		}

		public boolean isLeft() {
			return isLeft;
		}

	}

	private static boolean leftParenthesis(char ch) {
		if (ch == '(') {
			return true;
		}
		return false;
	}

	private static boolean rightParenthesis(char ch) {
		if (ch == ')') {
			return true;
		}
		return false;
	}
}
