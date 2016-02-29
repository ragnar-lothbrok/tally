package edu.pitt.is17.first.assignment4;

public class RolePlayer {

	private Integer score;
	private String name;
	private Dice dice = new Dice();

	public RolePlayer(String name) {
		super();
		this.name = name;
		this.score = 0;
	}

	public String getName() {
		return this.name;
	}

	boolean fight(Monster monster) {
		int count = DiceThrowEnum.valueOf(level().toUpperCase()).getCount();
		int diceTotal = 0;
		while(count > 0){
			diceTotal += dice.roll();
			count--;
		}
		int killPoint = DefeatPoint.valueOf(monster.getSpecies()).getMinKillPoint();
		if(killPoint <= diceTotal){
			this.score += DefeatPoint.valueOf(monster.getSpecies()).getEarnedPoint();
			return true;
		}
		return false;
	}

	String level() {
		if(this.score >= PlayerConstants.MASTER_LOWER_BOUND){
			return "master";
		}else if(this.score < PlayerConstants.BEGINNER_UPPER_BOUND && this.score >= PlayerConstants.BEGINNER_LOWER_BOUND){
			return "begineer";
		}else{
			return "trainee";
		}
	}

	Integer getScore() {
		return this.score;
	}

}
