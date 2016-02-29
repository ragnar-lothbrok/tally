package com.he.capillary.chegg1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ClientClass {

	public static void main(String[] args) {
		List<TelDirectory> list = new ArrayList<TelDirectory>();
		list.add(new TelDirectory("A", "111111"));
		list.add(new TelDirectory("B", "111111"));
		list.add(new TelDirectory("C", "111111"));
		list.add(new TelDirectory("D", "111111"));
		list.add(new TelDirectory("E", "111111"));
		list.add(new TelDirectory("F", "111111"));
		list.add(new TelDirectory("G", "111111"));
		list.add(new TelDirectory("H", "111111"));
		list.add(new TelDirectory("I", "111111"));
		list.add(new TelDirectory("A", "3333"));
		list.add(new TelDirectory(null, null));

		System.out.println(list);

		Collections.sort(list, (TelDirectory t1, TelDirectory t2) -> {
			if (t1.getName() != null) {
				return t1.getName().compareTo(t2.getName());
			}
			return 1;
		});

		System.out.println(list);
	}
}
