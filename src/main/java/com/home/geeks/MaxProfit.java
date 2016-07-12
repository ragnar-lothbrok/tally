package com.home.geeks;

public class MaxProfit {

	public static void main(String[] args) {
		int arr[] = { 100, 180, 260, 310, 40, 535, 695 };
		maximizeProfit(arr);
	}

	private static void maximizeProfit(int[] arr) {
		int firstMin = arr[0], firstMax = 0, stock = 0;
		for (int i = 1; i < arr.length; i++) {
			if (firstMin > arr[i] && firstMax == 0) {
				firstMin = arr[i];
			}

			if (firstMin < arr[i] && firstMax == 0) {
				firstMax = arr[i];
			} else if (firstMax < arr[i]) {
				firstMax = arr[i];
			}

			if (firstMax > arr[i] || arr.length - 1 == i) {
				if (firstMax - firstMin > 0) {
					stock += firstMax - firstMin;
					firstMax = 0;
					firstMin = arr[i];
				}
			}
		}

		System.out.println(stock);
	}
}
