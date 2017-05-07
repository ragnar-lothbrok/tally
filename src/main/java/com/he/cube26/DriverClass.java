package com.he.cube26;

public class DriverClass {

	public static void main(String[] args) {
		Street street = new Street("Maple Street");
		street.getBuildings().add(new Asylum(123.12, true," Ghost Palace"));
		street.getBuildings().add(new House(123.12, false," House1 Palace"));
		street.getBuildings().add(new House(123.12, false," House2 Palace"));
		street.getBuildings().add(new House(123.12, false," House3 Palace"));
		street.getBuildings().add(new House(123.12, false," House4 Palace"));
		
		street.stroll();
	}
}
