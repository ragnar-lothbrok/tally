package com.home.json;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Joiner;
import com.google.gson.Gson;

public class ParseFile {

	public static Map<String, String> test1() throws Exception {
		Map<String, String> filters = new LinkedHashMap<String, String>();
		BufferedReader br = new BufferedReader(new FileReader(new File("/home/raghunandangupta/Downloads/part-000001")));
		String line = br.readLine();
		line = br.readLine();
		while (line != null) {
			String str[] = line.split(",");
			filters.put(str[0].trim(), str[0].trim());
			line = br.readLine();
		}
		System.out.println(filters);
		return filters;
	}

	public static Map<String, String> test() throws Exception {
		Map<String, String> filters = new LinkedHashMap<String, String>();
		BufferedReader br = new BufferedReader(new FileReader(new File("/home/raghunandangupta/Downloads/part-000001")));
		String line = br.readLine();
		line = br.readLine();
		while (line != null) {
			String str[] = line.split(",");
			filters.put(str[1].trim(), str[1].trim());
			line = br.readLine();
		}
		System.out.println(filters);
		return filters;
	}

	public static void main(String[] args) throws Exception {
		Map<String, String> filters = test();
		Map<String, String> buckets = test1();
		BufferedReader br = new BufferedReader(new FileReader(new File("/home/raghunandangupta/Downloads/part-00000")));
		String line = br.readLine();
		line = br.readLine();
		Map<String, Map<String, Long>> filterCount = new LinkedHashMap<String, Map<String, Long>>();
		for (String bucket : buckets.keySet()) {
			filterCount.put(bucket, new LinkedHashMap<String, Long>());
			for (String filter : filters.keySet()) {
				filterCount.get(bucket).put(filter, 0l);
			}
		}
		while (line != null) {
			int index = line.indexOf(",");
			String bucket = line.substring(0, index);
			List<String> presentFilters = new ArrayList<String>();
			for (String filter : filters.keySet()) {
				if (line.toLowerCase().indexOf(filter.toLowerCase()) != -1) {
					filterCount.get(bucket).put(filter, 1 + filterCount.get(bucket).get(filter));
					presentFilters.add(filter);
				}
			}
			Collections.sort(presentFilters);
			String filterString = Joiner.on('|').join(presentFilters);
			if (filterCount.get(bucket).get(filterString) == null) {
				LinkedHashMap<String, Long> map = new LinkedHashMap<String, Long>();
				map.put(filterString, 0l);
				filterCount.get(bucket).putAll(map);
			}
			filterCount.get(bucket).put(filterString, 1 + filterCount.get(bucket).get(filterString));
			line = br.readLine();
		}
		System.out.println(new Gson().toJson(filterCount));
	}
}
