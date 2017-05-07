package com.he.capillary;

import java.util.ArrayList;
import java.util.List;

public class ClassSort {

	List<Integer> sets = new ArrayList<Integer>(100);

	public void set(String line) {
		String str[] = line.split(";");
		for (int i = 0; i < str.length; i++) {
			this.sets.set(Integer.parseInt(str[i].split(",")[1]), Integer.parseInt(str[i].split(",")[0]));
		}
	}
	
	public void sort(){
		List<Integer> list = new ArrayList<Integer>(sets);
		System.out.println(list);
	}
	
	public static void main(String[] args) {
			ClassSort cs = new ClassSort();
			cs.set("0,1;1,3;2,2");
			cs.sort();
			System.out.println(cs.sets);
	}
}


