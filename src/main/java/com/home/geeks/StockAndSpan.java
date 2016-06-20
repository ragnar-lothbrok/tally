package com.home.geeks;

import java.util.Stack;
//http://www.geeksforgeeks.org/the-stock-span-problem/
public class StockAndSpan {

	public static void main(String[] args) {

		int arr[] = {10, 4, 5, 90, 120, 80}/*{ 100, 80, 60, 70, 60, 75, 85 }*/;

		int S[] = new int[arr.length];

		calculateSpan(arr, S);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(S[i]+" ");
		}
	}

	private static void calculateSpan(int arr[], int[] S) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		S[0] = 1;

		for (int i = 1; i < arr.length; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
				stack.pop();
			}
			S[i] = (stack.isEmpty() ? i + 1 : i - stack.peek());
			stack.push(i);
		}

	}
}
