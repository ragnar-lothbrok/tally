package com.he.capillary;

public class CowWeightProblem {

	public static void main(String[] args) {

		getSmallest(4l, new long[] { 1, 3, 3, 1, 2, 3, 4 });
	}

	public static void getSmallest(long totalWeight, long[] weights) {
		int i = 0;
		int sum = 0;
		long tripCount = 0;
		boolean isValid = true;
		while (i < weights.length) {
			if (weights[i] > totalWeight) {
				isValid = false;
				System.out.println("Invalid Data..");
				break;
			}
			sum += weights[i];
			if (sum > totalWeight) {
				sum -= weights[i];
				tripCount++;
				i--;
				sum = 0;
			} else if (sum == totalWeight) {
				tripCount++;
				sum = 0;
			}
			i++;
		}
		if (isValid && sum != 0 && sum <= totalWeight) {
			tripCount++;
		}
		System.out.println(tripCount);

	}
}
