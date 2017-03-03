package com.he.cube26;

import java.util.ArrayList;
import java.util.List;

abstract class Building {

	private double size;
	private boolean haunted;

	public Building(double size, boolean haunted) {
		super();
		this.size = size;
		this.haunted = haunted;
	}

	public double getSize() {
		return size;
	}

	public boolean isHaunted() {
		return haunted;
	}

	abstract void explore();

}

class Asylum extends Building {

	public Asylum(double size, boolean haunted, String name) {
		super(size, haunted);
		this.name = name;
	}

	private String name;

	@Override
	void explore() {
		System.out.println("Watch out! A ghost!");
		System.out.println("You pass a " + getSize() + " sq. meter asylum called " + getName());
	}

	public String getName() {
		return name;
	}
}

class House extends Building {

	private String name;

	public House(double size, boolean haunted, String name) {
		super(size, haunted);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	void explore() {
		System.out.println("You pass a " + getSize() + " sq. meter house with a(n) " + getName());
	}

}

public class Street {

	List<Building> buildings = new ArrayList<Building>();

	private String streetName;

	public Street(String string) {
		this.streetName = string;
	}

	private Integer getNumHaunted() {
		int haunted = 0;
		for (Building building : buildings) {
			if(building.isHaunted()){
				haunted++;
			}
		}
		return haunted;
	}

	public List<Building> getBuildings() {
		return buildings;
	}

	public String getStreetName() {
		return streetName;
	}

	public void stroll() {
		System.out.println("Let's go for a stroll on " + streetName);
		for (Building building : buildings) {
			building.explore();
		}
		System.out.println(getNumHaunted()+" of the buildings on Maple street are haunted");
	}

}
