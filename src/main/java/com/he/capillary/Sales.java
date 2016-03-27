package com.he.capillary;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sales {

	static int reservationNumber = 500;

	public static void processReservation(String name, String typeOfRoom, String hotelName, String numOfNight,
			String numOfGuest, String arrivalDate) {

		boolean result = isValid(name, typeOfRoom, hotelName, numOfNight, numOfGuest, arrivalDate);
		if (result) {
			double cost = calcReservationCosts(typeOfRoom, hotelName, numOfNight, numOfGuest);
			String str[] = name.split(",");
			String reservationId = str[0].charAt(0) + "" + str[1].charAt(0) + " " + reservationNumber;
			reservationNumber++;
		}
	}

	public static double calcReservationCosts(String typeOfRoom, String hotelName, String numOfNight,
			String numOfGuest) {
		double cost = 0.0;
		if (hotelName.equals("Mom and Pop's hotel")) {
			if (typeOfRoom.equals("Two Queen Beds")) {
				cost = Integer.parseInt(numOfNight) * 49 * 1.10f;
			} else if (typeOfRoom.equals("One King Bed")) {
				cost = Integer.parseInt(numOfNight) * 48 * 1.10f;
			} else if (typeOfRoom.equals("Suite")) {
				cost = Integer.parseInt(numOfNight) * 65 * 1.10f;
			}
		} else if (hotelName.equals("Hotel from 'you know where'")) {
			if (typeOfRoom.equals("Two Queen Beds")) {
				cost = Integer.parseInt(numOfNight) * 19.99 * 1.10f;
			} else if (typeOfRoom.equals("One King Bed")) {
				cost = Integer.parseInt(numOfNight) * 16.99 * 1.10f;
			} else if (typeOfRoom.equals("Suite")) {
				cost = Integer.parseInt(numOfNight) * 24.99 * 1.10f;
			}
		} else if (hotelName.equals("Disnay(not disney)")) {
			if (typeOfRoom.equals("Two Queen Beds")) {
				cost = Integer.parseInt(numOfNight) * 99 * 1.10f;
			} else if (typeOfRoom.equals("One King Bed")) {
				cost = Integer.parseInt(numOfNight) * 89 * 1.10f;
			} else if (typeOfRoom.equals("Suite")) {
				cost = Integer.parseInt(numOfNight) * 109 * 1.10f;
			}
		}
		return cost;
	}

	static boolean isValid(String name, String typeOfRoom, String hotelName, String numOfNight, String numOfGuest,
			String arrivalDate) {
		if (name != null && name.trim().length() > 0) {
			System.out.println("Please provide valid Name.");
			return false;
		}
		
		if (hotelName != null && hotelName.trim().length() > 0) {
			System.out.println("Please provide hotel Name.");
			return false;
		}

		if (typeOfRoom != null && typeOfRoom.trim().length() > 0) {
			System.out.println("Please select Room Type.");
			return false;
		}


		try {
			int num = Integer.parseInt(numOfGuest);
			if (num <= 0 || num > 4) {
				System.out.println("Please provide number of guest between 1 and 4.");
				return false;
			}
		} catch (Exception exception) {
			System.out.println("Please provide number of guest between 1 and 4.");
			return false;
		}

		try {
			int num = Integer.parseInt(numOfNight);
			if (num <= 0) {
				System.out.println("Please provide number of nights of stay (> 0).");
				return false;
			}
		} catch (Exception exception) {
			System.out.println("Please provide number of nights of stay (> 0).");
			return false;
		}

		if (arrivalDate != null) {
			try {
				Date date = new SimpleDateFormat("dd/mm/yyyy").parse(arrivalDate);
				Date currentDate = new Date();
				if (!date.after(currentDate)) {
					System.out.println("Please provide valid arrival date.");
					return false;
				}
			} catch (Exception exception) {
				System.out.println("Please provide valid arrival date.");
				return false;
			}
		}
		return true;
	}

	private static String space = "\t\t";
	private static DecimalFormat df2 = new DecimalFormat("00.00");
	private static double baseSalary = 200d;

	public static int Acker(int m, int n) {
		System.out.println("Acker(" + m + ", " + n + ")");
		if (m == 0)
			return n + 1;
		else if (n == 0)
			return Acker(m - 1, 1);
		else
			return Acker(m - 1, Acker(m, n - 1));
	}

	public static void main(String[] args) {

		// System.out.println("Acker(1, 2) : "+ Acker(1, 2));
		System.out.println("Acker(2, 1) : " + Acker(2, 1));

		try {
			Sales st = new Sales();
			// st.calculateSales("sale.txt");
		} catch (Exception exception) {
			System.out.println("File Not found.");
		}
	}

	/**
	 * This will accept file and calculate data
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private void calculateSales(String fileName) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
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
