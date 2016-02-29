package com.he.capillary;

import java.util.Random;

public class Die {

	private int side;

	private int currentNum;

	public Die() {
		this.side = 6;
		roll();
	}

	public Die(int side) {
		this.side = side;
		roll();
	}

	public int get() {
		return this.currentNum;
	}

	public int numSides() {
		return this.side;
	}

	public int __repr__() {
		return this.currentNum;
	}

	public int __str__() {
		return this.currentNum;
	}

	public void roll() {
		int rand = new Random().nextInt() % this.side;
		this.currentNum = Math.abs(rand);
	}

	@Override
	public String toString() {
		return "[" + currentNum + "]";
	}
	
	public static void main(String[] args) {
		
		Die d1 = new Die(6);
		System.out.println(d1.get());
		
		d1.roll();
		System.out.println(d1.get());
		
		System.out.println(d1.numSides());
		
		System.out.println(d1);
		
		
		
	}

}
