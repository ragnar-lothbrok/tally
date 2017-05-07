package com.home.json;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MatrixEvaluatior {
	
	private static final String separator = ",";

	public static void main(String[] args) throws Exception {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			String firstLine = br.readLine();
			List<String> expressions = new ArrayList<String>();
			Boolean isFirstLine = true;
			while (firstLine != null && firstLine.trim().length() > 0) {
				firstLine = firstLine.replaceAll(" ", "");
				if (isFirstLine) {
					int countUnderScroe = 0;
					String split[] = firstLine.split(",");
					for(String value : split){
						if(value.trim().length() > 0 && value.trim().charAt(0) == '_'){
							countUnderScroe++;
						}
					}
					if(countUnderScroe %3 != 0){
						System.out.println("INVALID EXPRESSION");
						return;
					}
					firstLine = firstLine.replaceAll("_,_,_,", "_,");
					firstLine = firstLine.replaceAll(",,", ",");
					expressions.add(evaluateExpression(firstLine) + "");
					isFirstLine = false;
				} else {
					int countUnderScroe = 0;
					String split[] = firstLine.split(",");
					for(String value : split){
						if(value.trim().charAt(0) == '_'){
							countUnderScroe++;
						}
					}
					if(countUnderScroe != 3){
						System.out.println("INVALID EXPRESSION");
						return;
					}
					expressions.add(firstLine.split(",")[0]);
					isFirstLine = true;
				}
				firstLine = br.readLine();
			}
			
			if (expressions.size() % 2 == 0) {
				System.out.println("INVALID EXPRESSION");
			} else {
				String exp = "";
				for (String line : expressions) {
					if (exp.length() == 0) {
						exp = line;
					} else {
						exp += "," + line;
					}
				}
				Long result = evaluateExpressionTopDown(exp);
				System.out.println(result);
			}
		} catch (Exception e) {
			System.out.println("INVALID EXPRESSION");
		}finally {
			if(br != null){
				br.close();
			}
		}
	}
	
	
//	public static void main(String[] args) {
//		System.out.println(evaluateExpressionTopDown("10 _ 5 + 2"));
//	}
	
	private static Long evaluateExpressionTopDown(String exp) {
		String split[] = exp.split(separator);
		Stack<String> operatorStack = new Stack<String>();
		Stack<Long> operandStack = new Stack<Long>();
		for (int i = 0; i < split.length; i++) {
			if (split[i].trim().charAt(0) >= '0' && split[i].trim().charAt(0) <= '9'){
				if(!operandStack.isEmpty()){
					operandStack.push(evaluateExp(Long.parseLong(split[i].trim()),operandStack.pop(),operatorStack.pop()));
				}else{
					operandStack.push( Long.parseLong(split[i]));
				}
			}else if (isOperator(split[i])) {
				operatorStack.push(split[i]);
			}
		}
		while (!operatorStack.empty())
			operandStack.push(evaluateExp(operandStack.pop(), operandStack.pop(),operatorStack.pop()));
		return operandStack.pop();
	}
	
	private static Long evaluateExpression(String exp) {
		String split[] = exp.split(separator);
		Stack<String> operatorStack = new Stack<String>();
		Stack<Long> operandStack = new Stack<Long>();
		for (int i = 0; i < split.length; i++) {
			if (split[i].trim().charAt(0) >= '0' && split[i].trim().charAt(0) <= '9'){
				operandStack.push( Long.parseLong(split[i]));
			}else if (split[i].trim().charAt(0) == '(')
				operatorStack.push(split[i].trim());
			else if (split[i].trim().charAt(0) == ')'){
				while (operatorStack.peek().charAt(0) != '(')
					operandStack.push(evaluateExp(operandStack.pop(), operandStack.pop(),operatorStack.pop()));
				operatorStack.pop();
			}else if (isOperator(split[i])) {
				 while (!operatorStack.empty() && hasPrecedence(split[i].charAt(0), operatorStack.peek().charAt(0))){
					 operandStack.push(evaluateExp(operandStack.pop(), operandStack.pop(),operatorStack.pop()));
				 }
				operatorStack.push(split[i]);
			}
		}
		while (!operatorStack.empty())
			operandStack.push(evaluateExp(operandStack.pop(), operandStack.pop(),operatorStack.pop()));
		return operandStack.pop();
	}

	private static Long evaluateExp(Long oper2, Long oper1, final String operator) {
		Long result = 0l;
		switch (operator) {
		case "+":
			result = oper1 + oper2;
			break;
		case "_":
			result = oper1 / oper2;
			break;
		case "*":
			result = oper1 * oper2;
			break;
		case "-":
			result = oper1 - oper2;
			break;
		}
		return result;
	}

	private static Boolean isOperator(String oper) {
		if (oper.charAt(0) == '+' || oper.charAt(0) == '_' || oper.charAt(0) == '-' || oper.charAt(0) == '*') {
			return true;
		}
		return false;
	}

	public static boolean hasPrecedence(char op2, char op1) {
		if (op1 == '(' || op1 == ')')
			return false;
		if ((op1 == '*' || op1 == '_') && (op2 == '+' || op2 == '-'))
			return false;
		else
			return true;
	}
}
