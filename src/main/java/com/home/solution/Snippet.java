package com.home.solution;

public class Snippet {

	public static void main(String[] args) {
		 uniqueValue(4, new int[] { 2, 1, 1, 0 });
		 uniqueValue(6, new int[] { 3, 1, 1, 0, 0, 0 });
		 uniqueValue(6, new int[] { 0, 0, 0, 0, 0, 0 });
		 uniqueValue(6, new int[] { 0, 0, 0, 2,1,0 });
		uniqueValue(7, new int[] { 2, 5, 2, 2, 1, 0, 0 });
	}

	public static int[] uniqueValue(int input1, int[] input2) {
		int act[] = new int[input1];
		for (int i = 0; i < input1; i++) {
			if (input2[i] == 0) {
				int index = 0;
				while (act[index] != 0) {
					index++;
				}
				if (index < input1) {
					act[index] = i + 1;
				} else {
					break;
				}
			} else {
				int index = 0;
				int count = 0;
				while (index < input2[i] && index < input1) {
					if (act[count] == 0) {
						index++;
					}
					count++;
				}
				while (act[count] != 0) {
					count++;
				}
				if (count < input1) {
					act[count] = i + 1;
				} else {
					break;
				}
			}
		}
		for (int i = 0; i < input1; i++) {
			System.out.print(act[i] + " ");
		}
		System.out.println();
		return act;
	}
}
