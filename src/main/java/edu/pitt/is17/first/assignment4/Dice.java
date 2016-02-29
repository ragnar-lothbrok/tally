package edu.pitt.is17.first.assignment4;

public class Dice {

	private int sides;

	public Dice() {
		sides = 6;
	}

	public int roll() {
		return (int) (sides * Math.random() + 1);
	}
}
