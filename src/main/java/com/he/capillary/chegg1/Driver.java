package com.he.capillary.chegg1;

public class Driver {

	public static void main(String[] args) {
		
		SolarSystem s1 = new SolarSystem("S1", 5);
		s1.setPlanets(0, new Planet("A", 2));
		s1.setPlanets(1, new Planet("B", 3));
		s1.setPlanets(2, new Planet("C", 4));
		s1.setPlanets(3, new Planet("D", 5));
		s1.setPlanets(4, new Planet("E", 6));
		
		SolarSystem s2 = new SolarSystem("S2", 4);
		s2.setPlanets(0, new Planet("P", 2));
		s2.setPlanets(1, new Planet("Q", 3));
		s2.setPlanets(2, new Planet("R", 4));
		s2.setPlanets(3, new Planet("S", 5));
		
		System.out.println(s1.getSolrSystemName()+" "+s1.getSolarSystemPlanetCount()+" "+s1.getSolarSystemMoonCount()+" "+s1.toString());
		
		System.out.println(s2.getSolrSystemName()+" "+s2.getSolarSystemPlanetCount()+" "+s2.getSolarSystemMoonCount()+" "+s2.toString());
	}
}
