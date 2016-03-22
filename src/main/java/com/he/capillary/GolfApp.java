package com.he.capillary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Golfer implements Serializable,Comparable<Golfer> {

	private static final long serialVersionUID = -8123276401636304060L;

	private String name;
	private int score;

	public Golfer(String name2, int score2) {
		this.name = name2;
		this.score = score2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Golfer [name=" + name + ", score=" + score + "]";
	}

	@Override
	public int compareTo(Golfer o) {
		return ((Integer)o.getScore()).compareTo(this.getScore());
	}

}

public class GolfApp {
	public static void main(String[] args) {
		Scanner conIn = new Scanner(System.in);

		String name; // golfer's name
		int score; // golfer's score

		List<Golfer> golfers = new ArrayList<Golfer>(20);
		Golfer golfer;
		String skip; // Used to skip rest of input line after reading integer
		System.out.print("Golfer name (press Enter to end): ");
		name = conIn.nextLine();
		while (!name.equals("")) {
			System.out.print("Score: ");
			score = conIn.nextInt();
			skip = conIn.nextLine();

			golfer = new Golfer(name, score);
			golfers.add(golfer);

			System.out.print("Golfer name (press Enter to end): ");
			name = conIn.nextLine();
		}
		System.out.println();
		System.out.println("The final results are");
		Collections.sort(golfers);
		System.out.println(golfers);
	}
}
