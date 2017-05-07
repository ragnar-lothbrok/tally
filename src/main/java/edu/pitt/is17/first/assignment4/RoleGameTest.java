package edu.pitt.is17.first.assignment4;

public class RoleGameTest {

	public static void main(String[] args) {
		
		RolePlayer player = new RolePlayer("John Snow");

		battle(player,new Monster("vampire"));

		battle(player, new Monster("werewolf"));

		battle(player, new Monster("werewolf"));

		battle(player, new Monster("werewolf"));

		battle(player, new Monster("vampire"));

		battle(player, new Monster("werewolf"));

		battle(player, new Monster("vampire"));

		battle(player, new Monster("vampire"));

		battle(player, new Monster("vampire"));

		battle(player, new Monster("werewolf"));
		
		battle(player, new Monster("werewolf"));

		battle(player, new Monster("vampire"));

		battle(player, new Monster("werewolf"));

		battle(player, new Monster("vampire"));

		battle(player, new Monster("vampire"));

		battle(player, new Monster("vampire"));

		battle(player, new Monster("werewolf"));
		battle(player, new Monster("werewolf"));

		battle(player, new Monster("vampire"));

		battle(player, new Monster("werewolf"));

		battle(player, new Monster("vampire"));

		battle(player, new Monster("vampire"));

		battle(player, new Monster("vampire"));

		battle(player, new Monster("werewolf"));
		battle(player, new Monster("werewolf"));

		battle(player, new Monster("vampire"));

		battle(player, new Monster("werewolf"));

		battle(player, new Monster("vampire"));

		battle(player, new Monster("vampire"));

		battle(player, new Monster("vampire"));

		battle(player, new Monster("werewolf"));
		battle(player, new Monster("werewolf"));

		battle(player, new Monster("vampire"));

		battle(player, new Monster("werewolf"));

		battle(player, new Monster("vampire"));

		battle(player, new Monster("vampire"));

		battle(player, new Monster("vampire"));

		battle(player, new Monster("werewolf"));
		
		
	}

	public static void battle(RolePlayer p, Monster opponent) {

		if (p.fight(opponent)) {

			System.out.println(p.getName() + " fought a " + opponent.getSpecies() + " and win (level: " + p.level()
					+ ", score: " + p.getScore() + ")");

		} else {
			System.out.println(p.getName() + " fought a " + opponent.getSpecies() + " and lost (level: " + p.level()
					+ ", score: " + p.getScore() + ")");

		}

	}
}
