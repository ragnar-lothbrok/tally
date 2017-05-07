package com.home.geeks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

//http://www.geeksforgeeks.org/stepping-numbers/
public class SteppingNumbers {

	public static void main(String[] args) {

		for (int i = 0; i < 9; i++) {
			findSteppingNumbers(0, 21, i);
		}
		System.out.println(sortedNumbers);
	}
	
	private static Set<Integer> sortedNumbers = new TreeSet<Integer>();

	private static void findSteppingNumbers(int start, int end, int step) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(step);

		while (!queue.isEmpty()) {
			Integer poppedNum = queue.poll();

			if (poppedNum <= end && poppedNum >= start) {
				sortedNumbers.add(poppedNum);
			}

			if (poppedNum == 0 || poppedNum > end)
				continue;

			int lastDigit = poppedNum % 10;

			int num1 = poppedNum * 10 + (lastDigit - 1);
			int num2 = poppedNum * 10 + (lastDigit + 1);

			if (lastDigit == 0) {
				queue.add(num2);
			} else if (lastDigit == 9) {
				queue.add(num1);
			} else {
				queue.add(num2);
				queue.add(num1);
			}
		}
	}
}
