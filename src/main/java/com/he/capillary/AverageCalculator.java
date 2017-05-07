package com.he.capillary;

public class AverageCalculator {

	private int count;
	private int sum;

	AverageCalculator() {

	}

	double getAverage() {
		return sum*1.0 / count * 1.0;
	}

	void add(int newNum) {
		this.sum += newNum;
		this.count += 1;
	}

	int getSum() {
		return this.sum;
	}

	int getCount() {
		return this.count;
	}
}
