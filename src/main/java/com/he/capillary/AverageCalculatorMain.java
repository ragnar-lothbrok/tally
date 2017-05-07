package com.he.capillary;

public class AverageCalculatorMain {

	public static void main(String[] args) {
		
		AverageCalculator ac = new AverageCalculator();
		ac.add(100);
		ac.add(25);
		ac.add(25);
		ac.add(25);
		
		System.out.println(ac.getAverage()+" "+ac.getCount()+" "+ac.getSum());
	}
}
