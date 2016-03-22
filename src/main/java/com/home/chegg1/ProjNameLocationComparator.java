package com.home.chegg1;

import java.util.Comparator;

public class ProjNameLocationComparator implements Comparator<Project> {

	@Override
	public int compare(Project o1, Project o2) {
		int result = o1.getName().compareTo(o2.getName());
		if(result == 0){
			return o1.getLocation().compareTo(o2.getLocation());
		}
		return result;
	}

}
