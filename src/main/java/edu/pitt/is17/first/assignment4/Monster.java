package edu.pitt.is17.first.assignment4;

public class Monster {

	private String species;

	public Monster(String species) {
		super();
		if ("vampire".equalsIgnoreCase(species) || "werewolf".equalsIgnoreCase(species)) {
			this.species = species;
		} else {
			this.species = "werewolf";
		}
	}

	public String getSpecies() {
		return this.species;
	}

}
