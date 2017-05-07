package com.he.sapient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//https://www.hackerearth.com/sapient-global-markets-java-hiring-challenge/problems/9ded6dd62e78457492a499d9ddfb465c/
//https://www.hackerearth.com/sapient-global-markets-java-hiring-challenge/problems/bdeaa407f6c748eb83799b09b782617f/
public class MaxSumInArray extends Thread {

	protected MaxSumInArray() {
		
	}

	public synchronized void run() {
		for (int i = 0; i <= 10; i++) {
			System.out.println("i::" + i);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String split[] = line.split(" ");
		Integer queries = Integer.parseInt(split[1]);
		List<Integer> list = new ArrayList<Integer>();
		split = br.readLine().split(" ");
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < split.length; i++) {
			list.add(Integer.parseInt(split[i]));
		}

		List<Line> lineList = new ArrayList<Line>();
		for (int i = 0; i < queries; i++) {
			line = br.readLine();
			split = line.split(" ");
			int start = Integer.parseInt(split[0]);
			int end = Integer.parseInt(split[1]);
			lineList.add(new Line(start, end));
			for (int j = start; j <= end; j++) {
				if (map.get(j) == null) {
					map.put(j, 1);
				} else {
					map.put(j, map.get(j) + 1);
				}
			}
		}

		Map<Integer, Integer> result = new LinkedHashMap<Integer, Integer>();
		map.entrySet().stream().sorted(Map.Entry.<Integer, Integer> comparingByValue().reversed())
				.forEachOrdered(x -> result.put(x.getKey(), x.getValue()));

		Collections.sort(list);

		int[] rearrangedArr = new int[list.size()];

		int i = list.size() - 1;
		for (Integer key : result.keySet()) {
			rearrangedArr[key - 1] = list.get(i--);
		}

		int sum = 0;
		for (Line tempLine : lineList) {
			for (i = tempLine.getStart(); i <= tempLine.getEnd(); i++) {
				sum += rearrangedArr[i - 1];
			}
		}

		System.out.println(sum);
	}

	static class Line {
		private Integer start;
		private Integer end;

		public Integer getStart() {
			return start;
		}

		public void setStart(Integer start) {
			this.start = start;
		}

		public Integer getEnd() {
			return end;
		}

		public void setEnd(Integer end) {
			this.end = end;
		}

		public Line(Integer start, Integer end) {
			super();
			this.start = start;
			this.end = end;
		}

	}
}
