package com.he.capillary;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

	private int[] bestScores;

	private int randomNumber;

	public NumberGuessingGame() {
		bestScores = new int[20];
		for (int i = 0; i < 20; i++) {
			bestScores[i] = -1;
		}
	}

	public int[] getBestScores() {
		return bestScores;
	}

	public void setBestScores(int[] bestScores) {
		this.bestScores = bestScores;
	}

	public static void main(String[] args) {

		NumberGuessingGame ngg = new NumberGuessingGame();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1.Play a new game.\n2.Show my best score.\n3.Show overall best score.");
			int option = sc.nextInt();
			switch (option) {
			case 1:
				System.out.println("\nPlease enter your player Id (1-20).");
				ngg.randomNumber = new Random().nextInt((100 - 1) + 1) + 1;
				int playerId = sc.nextInt();
				while (playerId < 1 || playerId > 20) {
					System.out.println("\nPlease enter valid player Id.");
					playerId = sc.nextInt();
					continue;
				}
				int count = 0;
				while (true) {
					System.out.println("\nPlease enter a number to guess between 1 to 100. -1 to quit. ");
					int score = sc.nextInt();
					if (score == -1) {
						break;
					}
					count++;
					if (score == ngg.randomNumber) {
						System.out.println("Right");
						if (ngg.getBestScores()[playerId - 1] == -1) {
							ngg.getBestScores()[playerId - 1] = count;
						} else if (ngg.getBestScores()[playerId - 1] > count) {
							ngg.getBestScores()[playerId - 1] = count;
						}
						break;
					} else if (score < ngg.randomNumber) {
						System.out.println("Too Low");
					} else if (score > ngg.randomNumber) {
						System.out.println("Too High");
					}
				}
				break;
			case 2:
				System.out.println("\nPlease enter your player Id (1-20).");
				playerId = sc.nextInt();
				while (playerId < 1 && playerId > 20) {
					System.out.println("\nPlease enter valid player Id.");
				}
				System.out.println("Best Score : " + ngg.getBestScores()[playerId - 1]);
				break;
			case 3:
				int min = Integer.MAX_VALUE;
				int winPlayerId = -1;
				for (int i = 0; i < 20; i++) {
					if(ngg.getBestScores()[i] != -1){
						if(min > ngg.getBestScores()[i]){
							min = ngg.getBestScores()[i];
							winPlayerId = i+1;
						}
					}
				}
				if(min == Integer.MAX_VALUE){
					System.out.println("No games are played");
				}else{
					System.out.println("Player Id : "+winPlayerId+" Best Score : "+min);
				}
				break;
			default:
				break;
			}
		}
	}

}
