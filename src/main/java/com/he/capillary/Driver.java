package com.he.capillary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Driver {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(
					new FileReader(new File("/home/raghunandangupta/mygit/tally/data.txt")));
			List<Integer> list = new ArrayList<Integer>();
			String line = br.readLine();
			while (line != null) {
				list.add(Integer.parseInt(line));
				line = br.readLine();
			}

			System.out.println("Unsorted Array : ");
			displayElements(list);
			List<Integer> sorted = new ArrayList<Integer>(list);
			Collections.sort(sorted);
			System.out.println("Sorted Array : ");
			displayElements(sorted);

			execute(list);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void execute(List<Integer> list) {
		List<SortingAlgo> algoList = new ArrayList<Driver.SortingAlgo>();

		bubbleSort(new ArrayList<Integer>(list), algoList);
		insertionSort(new ArrayList<Integer>(list), algoList);
		selectionSort(new ArrayList<Integer>(list), algoList);
		
		System.out.println(algoList );
	}

	private static void bubbleSort(List<Integer> list, List<SortingAlgo> algoList) {
		SortingAlgo s1 = new SortingAlgo();
		s1.setName("Bubble Sort");
		long start = System.nanoTime();
		for (int c = 0; c < (list.size() - 1); c++) {
			for (int d = 0; d < list.size() - c - 1; d++) {
				if (list.get(d) > list.get(d + 1)) {
					s1.setCopies(s1.getCopies() + 1);
					s1.setCopies(s1.getCopies() + 1);
					int swap = list.get(d);
					list.set(d, list.get(d + 1));
					list.set(d + 1, swap);
				}
				s1.setComparisons(s1.getComparisons() + 1);
			}
		}
		s1.setElapsedTime(System.nanoTime() - start);
		algoList.add(s1);
	}

	private static void insertionSort(List<Integer> list, List<SortingAlgo> algoList) {
		SortingAlgo s1 = new SortingAlgo();
		s1.setName("Insertion Sort");
		long start = System.nanoTime();
		for (int i = 1; i < list.size(); i++) {
			int next = list.get(i);
			int j = i;
			while (j > 0 && list.get(j - 1) > next) {
				s1.setComparisons(s1.getComparisons() + 1);
				list.set(j, list.get(j - 1));
				s1.setCopies(s1.getCopies() + 1);
				j--;
			}
			list.set(j, next);
			s1.setCopies(s1.getCopies() + 1);
		}
		s1.setElapsedTime(System.nanoTime() - start);
		algoList.add(s1);
	}

	private static void selectionSort(List<Integer> list, List<SortingAlgo> algoList) {
		SortingAlgo s1 = new SortingAlgo();
		s1.setName("Selection Sort");
		long start = System.nanoTime();
		for (int i = 0; i < list.size() - 1; i++) {
			int minPos = i;
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(j) < list.get(minPos)) {
					minPos = j;
					s1.setComparisons(s1.getComparisons() + 1);
				}
			}
			int swap = list.get(i);
			list.set(i, list.get(minPos));
			list.set(minPos, swap);
			s1.setCopies(s1.getCopies() + 1);
			s1.setCopies(s1.getCopies() + 1);
		}
		s1.setElapsedTime(System.nanoTime() - start);
		algoList.add(s1);
	}

	private static void displayElements(List<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			if (i % 10 == 9) {
				System.out.print(list.get(i));
				System.out.println();
			} else {
				if (i == list.size() - 1)
					System.out.print(list.get(i));
				else
					System.out.print(list.get(i) + ", ");
			}
		}
	}

	static class SortingAlgo {
		private String name;
		private Long comparisons = 0l;
		private Long copies = 0l;
		private Long elapsedTime = 0l;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Long getComparisons() {
			return comparisons;
		}

		public void setComparisons(Long comparisons) {
			this.comparisons = comparisons;
		}

		public Long getCopies() {
			return copies;
		}

		public void setCopies(Long copies) {
			this.copies = copies;
		}

		public Long getElapsedTime() {
			return elapsedTime;
		}

		public void setElapsedTime(Long elapsedTime) {
			this.elapsedTime = elapsedTime;
		}

		@Override
		public String toString() {
			return "\nSortingAlgo [name=" + name + ", comparisons=" + comparisons + ", copies=" + copies
					+ ", elapsedTime=" + elapsedTime + "]\n";
		}

	}
}
