package com.home.geeks;

import java.util.Stack;

//http://www.geeksforgeeks.org/find-expression-duplicate-parenthesis-not/
public class DuplicateParenthesis {

	public static void main(String[] args) {
		duplicateParenthesis("((a+b)+((c+d)))");
		duplicateParenthesis("(((a+(b)))+(c+d))");
		duplicateParenthesis("(((a+(b))+c+d))");
		duplicateParenthesis("((a+b)+(c+d))");
		duplicateParenthesis("((a+(b))+(c+d))");
		duplicateParenthesis("((a+(b)*c)+(c+d)*c)");

	}

	private static void duplicateParenthesis(String expression) {
		Stack<Character> stack = new Stack<Character>();
		boolean isConsecutiveParenthesis = false;
		int lentgh = expression.length();
		int count = 0;
		while (count < lentgh) {
			char temp = expression.charAt(count);
			if (isBracket(temp)) {
				if (stack.isEmpty()) {
					stack.push(temp);
				} else {
					if (stack.isEmpty()) {
						stack.push(temp);
					} else {
						char ch = stack.pop();
						if (!isMatching(ch, temp)) {
							stack.push(ch);
							stack.push(temp);
						} else {
							if (isConsecutiveParenthesis) {
								System.out.println(expression + " == Duplicate Found");
								break;
							}
							isConsecutiveParenthesis = true;
						}
					}
				}
			} else {
				isConsecutiveParenthesis = false;
			}
			count++;
		}
	}

	public static boolean isMatching(char ch1, char ch2) {
		if (ch1 == '{' && ch2 == '}') {
			return true;
		} else if (ch1 == '(' && ch2 == ')') {
			return true;
		} else if (ch1 == '[' && ch2 == ']') {
			return true;
		}
		return false;
	}

	public static boolean isBracket(char ch1) {
		if (ch1 == '{' || ch1 == '}' || ch1 == '(' || ch1 == ')' || ch1 == '[' || ch1 == ']') {
			return true;
		}
		return false;
	}
}
