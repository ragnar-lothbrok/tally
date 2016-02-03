package com.he.capillary;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Sales {

	private static String space = "\t\t";
	private static DecimalFormat df2 = new DecimalFormat("00.00");
	private static double baseSalary = 200d;

	public static void main(String[] args) {
		try {
			Sales st = new Sales();
			st.calculateSales("/home/coder/mygit/tally/src/main/java/com/he/capillary/sale.txt");
		} catch (Exception exception) {
			System.out.println("File Not found.");
		}
	}

	/**
	 * This will accept file and calculate data
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private void calculateSales(String fileName) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(
				new FileReader(fileName));
		String line = br.readLine();
		String str[] = new String[2];
		List<Sale> saleList = new ArrayList<Sale>();
		while (line != null) {
			str = line.split(" ");
			Sale sale = new Sale();
			sale.setSalePerson(str[0].trim());
			sale.setGrossPerWeak(Double.parseDouble(str[1]));
			int percentage = getPercentage(sale.getGrossPerWeak());
			sale.setNetPerWeek(baseSalary + sale.getGrossPerWeak() * percentage / 100.0);
			sale.setTier(getTier(sale.getNetPerWeek()));
			saleList.add(sale);
			line = br.readLine();
		}
		printTabular(saleList);
	}

	public void printTabular(List<Sale> saleList) {
		StringBuilder sb = new StringBuilder();
		sb.append("SalesPerson" + space + "GrossPerWeek" + space + "NetPerWeek" + space + "Tier\n");
		if (saleList != null && saleList.size() > 0) {
			for (Sale sale : saleList) {
				sb.append(sale.getSalePerson() + space + df2.format(sale.getGrossPerWeak()) + space
						+ df2.format(sale.getNetPerWeek()) + space + sale.getTier() + "\n");
			}
		}
		System.out.println(sb.toString());
	}

	private int getPercentage(double amount) {
		if (amount > 5000) {
			return 9;
		} else if (amount <= 5000 && amount > 3000) {
			return 6;
		} else if (amount <= 3000 && amount > 2000) {
			return 4;
		}
		return 0;
	}

	private int getTier(double amount) {
		if (amount > 1000) {
			return 1;
		} else if (amount <= 1000 && amount > 500) {
			return 2;
		} else if (amount <= 500) {
			return 3;
		}
		return 0;
	}

	static class Sale {
		private String salePerson;
		private double grossPerWeak;
		private double netPerWeek;
		private int tier;

		public String getSalePerson() {
			return salePerson;
		}

		public void setSalePerson(String salePerson) {
			this.salePerson = salePerson;
		}

		public double getGrossPerWeak() {
			return grossPerWeak;
		}

		public void setGrossPerWeak(double grossPerWeak) {
			this.grossPerWeak = grossPerWeak;
		}

		public double getNetPerWeek() {
			return netPerWeek;
		}

		public void setNetPerWeek(double netPerWeek) {
			this.netPerWeek = netPerWeek;
		}

		public int getTier() {
			return tier;
		}

		public void setTier(int tier) {
			this.tier = tier;
		}

		@Override
		public String toString() {
			return "Sale [salePerson=" + salePerson + ", grossPerWeak=" + grossPerWeak + ", netPerWeek=" + netPerWeek
					+ ", tier=" + tier + "]\n";
		}

	}
}
