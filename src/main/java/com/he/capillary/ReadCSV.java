package com.he.capillary;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.codehaus.jackson.map.ObjectMapper;

import com.csvreader.CsvReader;

/**
 * 
 * [﻿"customer_id", "email", "country", "is_active", "created_at", "firstname",
 * "lastname", "contact", "password_hash", "dob", "gender", "source"]
 * 
 */
public class ReadCSV {
	public static final String SEPERATOR = ",";
	public static final String STRING_IDENTIFIER = "'";

	public static void main(String[] args) throws NumberFormatException, SQLException {

		String csvFile = "/home/raghunandangupta/Downloads/Product_hierarchy.csv";
		List<Level> list = new ArrayList<Level>();
		Set<LevelDetail> LevelDetailList = new LinkedHashSet<LevelDetail>();
		try {
			CsvReader products = new CsvReader(csvFile);
			products.readHeaders();
			while (products.readRecord()) {
				if (products.getRawRecord().indexOf(
						",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,") != -1)
					continue;
				System.out.println(products.getRawRecord() + "\n\n");
				String superCat = products.get("SuperCat");
				String partCat = products.get("Part Cat");
				String cat = products.get("Cat");
				String subCat = products.get("Sub Cat");
				String label = products.get("Label");
				if (partCat.equals(cat)) {
					LevelDetailList.add(new LevelDetail(superCat, partCat, subCat, null, label));
				} else {
					LevelDetailList.add(new LevelDetail(superCat, partCat, cat, subCat, label));
				}
			}

			Iterator<LevelDetail> iterator = LevelDetailList.iterator();
			while (iterator.hasNext()) {
				LevelDetail ld = iterator.next();
				Level superCatLevel = new Level();
				superCatLevel.setLabel(ld.getSuperCat());

				Level partCatLevel = new Level();
				partCatLevel.setLabel(ld.getPartCat());

				Level catLevel = new Level();
				catLevel.setLabel(ld.getCat());

				Level subCatLevel = null;
				if (ld.getSubCat() == null) {
					catLevel.setPageUrl(ld.getLabel());
				} else {
					subCatLevel = new Level();
					subCatLevel.setLabel(ld.getSubCat());
					subCatLevel.setPageUrl(ld.getLabel());
				}

				if (list.indexOf(superCatLevel) == -1) {
					list.add(superCatLevel);
					if (subCatLevel == null) {
						partCatLevel.getAttributes().add(catLevel);
						superCatLevel.getAttributes().add(partCatLevel);
					} else {
						catLevel.getAttributes().add(subCatLevel);
						partCatLevel.getAttributes().add(catLevel);
						superCatLevel.getAttributes().add(partCatLevel);
					}
				} else {
					List<Level> secondLevelAttributes = list.get(list.indexOf(superCatLevel)).getAttributes();
					if (secondLevelAttributes.indexOf(partCatLevel) != -1) {
						List<Level> thirdLevelAttributes = secondLevelAttributes
								.get(secondLevelAttributes.indexOf(partCatLevel)).getAttributes();
						if (thirdLevelAttributes.indexOf(catLevel) != -1) {
							List<Level> forthLevelAttributes = thirdLevelAttributes
									.get(thirdLevelAttributes.indexOf(catLevel)).getAttributes();
							if (subCatLevel != null && forthLevelAttributes.contains(subCatLevel)) {

							} else {
								if (subCatLevel != null)
									forthLevelAttributes.add(subCatLevel);
							}
						} else {
							thirdLevelAttributes.add(catLevel);
							if (subCatLevel != null)
								catLevel.getAttributes().add(subCatLevel);
						}
					} else {
						secondLevelAttributes.add(partCatLevel);
						if (subCatLevel == null) {
							partCatLevel.getAttributes().add(catLevel);
						} else {
							catLevel.getAttributes().add(subCatLevel);
							partCatLevel.getAttributes().add(catLevel);
						}
					}
				}
			}
//			System.out.println("###" + new ObjectMapper().writeValueAsString(list));
			System.out.println("@@@@" + LevelDetailList.size());
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
