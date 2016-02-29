package edu.pitt.is17.first.assignment4;

public enum DiceThrowEnum {

	TRAINEE(2), BEGINEER(3), MASTER(4);

	private String value;
	private Integer count;

	public String getValue() {
		return value;
	}

	public Integer getCount() {
		return count;
	}

	private DiceThrowEnum(Integer count) {
		this.count = count;
	}

}
