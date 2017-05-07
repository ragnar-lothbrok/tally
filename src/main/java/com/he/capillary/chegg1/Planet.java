package com.he.capillary.chegg1;

public class Planet {
	private String planetName;
	private Integer numOfMoons;

	public String getPlanetName() {
		return planetName;
	}

	public void setPlanetName(String planetName) {
		this.planetName = planetName;
	}

	public Integer getNumOfMoons() {
		return numOfMoons;
	}

	public void setNumOfMoons(Integer numOfMoons) {
		this.numOfMoons = numOfMoons;
	}

	@Override
	public String toString() {
		return "Planet [planetName=" + planetName + ", numOfMoons=" + numOfMoons + "]";
	}

	public Planet(String planetName, Integer numOfMoons) {
		super();
		this.planetName = planetName;
		this.numOfMoons = numOfMoons;
	}

}
