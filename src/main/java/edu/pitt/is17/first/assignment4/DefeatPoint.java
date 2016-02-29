package edu.pitt.is17.first.assignment4;

public enum DefeatPoint {

	vampire(11, 300), werewolf(7, 150);

	private String value;
	private Integer minKillPoint;
	private Integer earnedPoint;

	public String getValue() {
		return value;
	}

	public Integer getEarnedPoint() {
		return earnedPoint;
	}

	public Integer getMinKillPoint() {
		return minKillPoint;
	}

	private DefeatPoint(Integer count, Integer earnedPoint) {
		this.minKillPoint = count;
		this.earnedPoint = earnedPoint;
	}

}
