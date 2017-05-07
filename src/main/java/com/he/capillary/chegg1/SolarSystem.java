package com.he.capillary.chegg1;

import java.util.Arrays;

public class SolarSystem {
	private String solrSystemName;
	private Planet[] planets;

	public String getSolrSystemName() {
		return solrSystemName;
	}

	public void setSolrSystemName(String solrSystemName) {
		this.solrSystemName = solrSystemName;
	}

	public Planet getPlanets(int index) {
		return planets[index];
	}

	public void setPlanets(int index, Planet planet) {
		this.planets[index] = planet;
	}

	public SolarSystem(String solrSystemName, int planets) {
		super();
		this.solrSystemName = solrSystemName;
		this.planets = new Planet[planets];
	}

	public int getSolarSystemPlanetCount() {
		return this.planets.length;
	}

	public int getSolarSystemMoonCount() {
		int count = 0;
		for (Planet planet : this.planets) {
			count += planet.getNumOfMoons();
		}
		return count;
	}

	@Override
	public String toString() {
		return "SolarSystem [solrSystemName=" + solrSystemName + ", planets=" + Arrays.toString(planets) + "]";
	}

}
