package com.he.capillary;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.csvreader.CsvReader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 
 * [﻿"customer_id", "email", "country", "is_active", "created_at", "firstname",
 * "lastname", "contact", "password_hash", "dob", "gender", "source"]
 * 
 */
public class ReadCSVModified {
	public static final String SEPERATOR = ",";
	public static final String STRING_IDENTIFIER = "'";

	public static void main(String[] args) throws NumberFormatException, SQLException {

//		String csvFile = "/home/raghunandangupta/Menus/overall.csv";
//		String csvFile = "/home/raghunandangupta/Menus/designer.csv";
		String csvFile = "/home/raghunandangupta/Menus/premium.csv";
		List<Level> list = new ArrayList<Level>();
		Level firstLevel = null;
		Level secondLevel = null;
		Level thirdLevel = null;
		Level forthLevel = null;
		try {
			CsvReader products = new CsvReader(csvFile);
			products.readHeaders();
			products.readRecord();
			while (products.readRecord()) {
				if (products.getRawRecord().indexOf(
						",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,") != -1)
					continue;
				System.out.println(products.getRawRecord());
				if(products.get(1).equalsIgnoreCase("Sunglasses")
						||products.get(2).equalsIgnoreCase("Sunglasses"))
					System.out.println();
				String[] level1 = new String[2];
				String[] level2 = new String[2];
				String[] level3 = new String[2];
				String[] level4 = new String[2];
				level1[0] = products.get(0);
				level1[1] = products.get(4);
				level2[0] = products.get(1);
				level2[1] = products.get(5);
				level3[0] = products.get(2);
				level3[1] = products.get(6);
				level4[0] = products.get(3);
				level4[1] = products.get(7);
				firstLevel = new Level();
				firstLevel.setLabel(level1[0]);
				firstLevel.setPageUrl("products/" + level1[1]);
				if (level2[0] != null && level2[0].length() > 0) {
					secondLevel = new Level();
					secondLevel.setLabel(level2[0]);
					secondLevel.setPageUrl("products/" + level2[1]);
					if (level3[0] != null && level3[0].length() > 0) {
						thirdLevel = new Level();
						thirdLevel.setLabel(level3[0]);
						thirdLevel.setPageUrl("products/" + level3[1]);
						if (level4[0] != null && level4[0].length() > 0) {
							forthLevel = new Level();
							forthLevel.setLabel(level4[0]);
							forthLevel.setPageUrl("products/" + level4[1]);
						}
					}
				}
				if (list.indexOf(firstLevel) != -1) {
					Level first_Level = list.get(list.indexOf(firstLevel));
					if (first_Level.getAttributes().indexOf(secondLevel) != -1) {
						Level second_Level = first_Level.getAttributes()
								.get(first_Level.getAttributes().indexOf(secondLevel));
						if (second_Level.getAttributes().indexOf(thirdLevel) != -1) {
							Level third_Level = second_Level.getAttributes()
									.get(second_Level.getAttributes().indexOf(thirdLevel));
							if (third_Level.getAttributes().indexOf(forthLevel) != -1) {
								Level forth_Level = third_Level.getAttributes()
										.get(third_Level.getAttributes().indexOf(forthLevel));
							}else{
								if(forthLevel != null){
									third_Level.getAttributes().add(forthLevel);
								}
							}
						}else{
							second_Level.getAttributes().add(thirdLevel);
							if (forthLevel != null) {
								thirdLevel.getAttributes().add(forthLevel);
							}
						}
					} else {
						first_Level.getAttributes().add(secondLevel);
						if (thirdLevel != null) {
							secondLevel.getAttributes().add(thirdLevel);
							if (forthLevel != null) {
								thirdLevel.getAttributes().add(forthLevel);
							}
						} else {
							if (forthLevel != null) {
								secondLevel.getAttributes().add(forthLevel);
							}
						}
					}
				} else {
					list.add(firstLevel);
					firstLevel.getAttributes().add(secondLevel);
					if (thirdLevel != null) {
						secondLevel.getAttributes().add(thirdLevel);
						if (forthLevel != null) {
							thirdLevel.getAttributes().add(forthLevel);
						}
					} else {
						if (forthLevel != null) {
							secondLevel.getAttributes().add(forthLevel);
						}
					}
				}
				firstLevel = null;
				secondLevel = null;
				thirdLevel = null;
				forthLevel = null;

			}
			new GsonBuilder().disableHtmlEscaping();
			String finalJson = new Gson().toJson(list);
			finalJson = finalJson.replace("\\u0026", "&");
			finalJson = finalJson.replace("|", "&");
					
			System.out.println("###" + finalJson);
			System.out.println("@@@@" + list.size());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
			System.out.println(exception.getMessage());
		}
		System.out.println("Done");
	}
}
