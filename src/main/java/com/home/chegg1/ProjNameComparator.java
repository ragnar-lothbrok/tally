package com.home.chegg1;

import java.util.Comparator;

public class ProjNameComparator implements Comparator<Project> {

	@Override
	public int compare(Project o1, Project o2) {
		return o1.getName().compareTo(o2.getName());
	}

}