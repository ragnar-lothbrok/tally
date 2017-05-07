package com.he.capillary;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SO2 {

	public static void main(String[] args) {

		List<String> employeeIds = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			employeeIds.add(i + "");
		}

		final List<String> employeeIdImages = new ArrayList<String>();
		for (int i = 0; i < 10; i += 2) {
			employeeIdImages.add(i + ".jpg");
		}
		
		List<String> notemployeeIds = employeeIds.stream().filter(new Predicate<String>() {
			@Override
			public boolean test(String t) {
				Boolean present = false;
				for(String str : employeeIdImages){
					String split[] = str.split("/.");
					present = t.equals(split[0]);
					if(present){
						break;
					}
				}
				return !present;
			}
		}).collect(Collectors.toList());
		
		System.out.println(notemployeeIds);

	}
}
