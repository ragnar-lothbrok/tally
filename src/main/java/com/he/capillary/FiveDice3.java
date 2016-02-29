package com.he.capillary;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

public class FiveDice3 {

	public static void main(String[] args) {
		System.out.println("Starting game : ");
		Map<Integer, Integer> player = new HashMap<Integer, Integer>();
		Map<Integer, Integer> computer = new HashMap<Integer, Integer>();
		for (int i = 0; i < 6; i++) {
			int dice = new Random().nextInt((6 - 1) + 1) + 1;
			if (player.get(dice) != null) {
				player.put(dice, player.get(dice) + 1);
			} else {
				player.put(dice, 1);
			}
		}

		for (int i = 0; i < 6; i++) {
			int dice = new Random().nextInt((6 - 1) + 1) + 1;
			if (computer.get(dice) != null) {
				computer.put(dice, computer.get(dice) + 1);
			} else {
				computer.put(dice, 1);
			}
		}

		int playerHeighestCount = -1;
		int playerHeighestValue = -1;
		for (Entry<Integer, Integer> entry : player.entrySet()) {
			if (playerHeighestCount < entry.getValue()) {
				playerHeighestCount = entry.getValue();
				playerHeighestValue = entry.getKey();
			}else if(playerHeighestCount == entry.getValue()){
				if(playerHeighestValue < entry.getKey()){
					playerHeighestCount = entry.getValue();
					playerHeighestValue = entry.getKey();
				}
			}
		}

		int computerHeighestCount = -1;
		int computerHeighestValue = -1;
		for (Entry<Integer, Integer> entry : computer.entrySet()) {
			if (computerHeighestCount < entry.getValue()) {
				computerHeighestCount = entry.getValue();
				computerHeighestValue = entry.getKey();
			}else if(computerHeighestCount == entry.getValue()){
				if(computerHeighestValue < entry.getKey()){
					computerHeighestCount = entry.getValue();
					computerHeighestValue = entry.getKey();
				}
			}
		}

		System.out.println(player + " " + computer);

		if (computerHeighestCount > playerHeighestCount) {
			System.out.println("Computer Won");
		} else if (computerHeighestCount < playerHeighestCount) {
			System.out.println("Player Won");
		} else {
			if (playerHeighestValue > computerHeighestValue) {
				System.out.println("Player Won");
			} else if (playerHeighestValue < computerHeighestValue) {
				System.out.println("Computer Won");
			} else {
				System.out.println("Tie");
			}
		}
	}
}
