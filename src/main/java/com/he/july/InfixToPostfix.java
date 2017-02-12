package com.he.july;

import java.util.Stack;

public class InfixToPostfix {

	public static void main(String[] args) {
		String expression = "A*B-(C+D)+E";
		expression = expression.replaceAll(" ", "");
		new InfixToPostfix().infixToPostfixWithBraces(expression);
	}

	private void infixToPrefixWithBraces(String expression) {
		Stack<Character> operators = new Stack<Character>();
		Stack<String> operands = new Stack<String>();
		String postfix = "";
		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			if (isOperator(ch)) {
				if (!operators.isEmpty()) {
					if (ch == ')') {
						ch = operators.pop();
						while (ch != '(') {
							String oprand1 = operands.pop();
							String oprand2 = operands.pop();
							postfix = ch + "" + oprand2 + "" + oprand1 + "";
							operands.push(postfix);
							ch = operators.pop();
						}
					} else {
						if (ch == '(') {
							operators.push(ch);
							continue;
						}
						char poppedChar = operators.pop();
						while (precedence(ch, poppedChar)) {
							String oprand1 = operands.pop();
							if (operands.isEmpty()) {
								operands.push(oprand1);
								break;
							}
							String oprand2 = operands.pop();
							postfix = poppedChar + "" + oprand2 + "" + oprand1 + "";
							operands.push(postfix);
							if (!operators.isEmpty()) {
								poppedChar = operators.pop();
							} else {
								break;
							}
						}
						if (!operators.isEmpty()) {
							operators.push(poppedChar);
						}
						operators.push(ch);
					}
				} else {
					operators.push(ch);
				}
			} else {
				operands.push(ch + "");
			}
		}
		if (!operators.isEmpty()) {
			char poppedOptr = operators.pop();
			String popeedOprnd = operands.pop();
			postfix = operands.pop() + "" + poppedOptr + "" + popeedOprnd + "";
		}
		System.out.println(postfix);
	}

	private void infixToPostfixWithBraces(String expression) {
		Stack<Character> operators = new Stack<Character>();
		Stack<String> operands = new Stack<String>();
		String postfix = "";
		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			if (isOperator(ch)) {
				if (!operators.isEmpty()) {
					if (ch == ')') {
						ch = operators.pop();
						while (ch != '(') {
							String oprand1 = operands.pop();
							String oprand2 = operands.pop();
							postfix = oprand2 + "" + oprand1 + "" + ch;
							operands.push(postfix);
							ch = operators.pop();
						}
					} else {
						if (ch == '(') {
							operators.push(ch);
							continue;
						}
						char poppedChar = operators.pop();
						while (precedence(ch, poppedChar)) {
							String oprand1 = operands.pop();
							if (operands.isEmpty()) {
								operands.push(oprand1);
								break;
							}
							String oprand2 = operands.pop();
							postfix = oprand2 + "" + oprand1 + "" + poppedChar;
							operands.push(postfix);
							if (!operators.isEmpty()) {
								poppedChar = operators.pop();
							} else {
								break;
							}
						}
						if (!operators.isEmpty()) {
							operators.push(poppedChar);
						}
						operators.push(ch);
					}
				} else {
					operators.push(ch);
				}
			} else {
				operands.push(ch + "");
			}
		}
		if (!operators.isEmpty()) {
			char poppedOptr = operators.pop();
			String popeedOprnd = operands.pop();
			postfix = operands.pop() + "" + popeedOprnd + "" + "" + poppedOptr;
		}
		System.out.println(postfix);
	}

	private void infixToPostfix(String expression) {
		Stack<Character> operators = new Stack<Character>();
		Stack<Character> operands = new Stack<Character>();
		String postfix = "";
		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			if (isOperator(ch)) {
				if (!operators.isEmpty()) {
					char poppedChar = operators.pop();
					while (precedence(ch, poppedChar)) {
						char oprand1 = operands.pop();
						if (operands.isEmpty()) {
							operands.push(oprand1);
							break;
						}
						char oprand2 = operands.pop();
						postfix += oprand2 + "" + oprand1 + "" + poppedChar;
						if (!operators.isEmpty()) {
							poppedChar = operators.pop();
						} else {
							break;
						}
					}
					if (!operators.isEmpty()) {
						operators.push(poppedChar);
					}
					operators.push(ch);
				} else {
					operators.push(ch);
				}
			} else {
				operands.push(ch);
			}
		}
		if (!operators.isEmpty()) {
			char poppedOptr = operators.pop();
			char popeedOprnd = operands.pop();
			postfix += popeedOprnd + "" + poppedOptr + "";
		}
		System.out.println(postfix);
	}

	public boolean isOperator(char op1) {
		if (op1 == '(' || op1 == ')' || op1 == '*' || op1 == '^' || op1 == '/' || op1 == '+' || op1 == '-')
			return true;
		return false;
	}

	public boolean precedence(char op1, char op2) {
		if (op2 == '(' || op2 == ')')
			return false;
		if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return false;
		else
			return true;
	}
}
