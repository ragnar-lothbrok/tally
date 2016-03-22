package com.home.chegg1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sorts {

	public static void sort(ArrayList<Project> objects, Comparator<Project> comparator) {
		Collections.sort(objects, comparator);
	}
}
