package com.home.chegg1;

import java.util.Comparator;

public class ProjNumberComparator implements Comparator<Project> {

	@Override
	public int compare(Project o1, Project o2) {
		return ((Integer) o1.getNumber()).compareTo(o2.getNumber());
	}

}
