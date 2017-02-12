package com.home.json;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.csvreader.CsvWriter;
import com.google.gson.Gson;

public class SimilarityMatrix {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File("/home/raghunandangupta/Downloads/footwear_pog_dat.csv")));
		String line = br.readLine();
		line = br.readLine();
		Map<String, List<POGDetails>> uniqueStrings = new LinkedHashMap<String, List<POGDetails>>();
		while (line != null) {
			String str[] = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
			String brand = str[2].trim();

			POGDetails pOGDetails = new POGDetails(Long.parseLong(str[0]), str[1].trim(), Double.parseDouble(str[3]));
			if (uniqueStrings.get(brand) == null) {
				List<POGDetails> names = new ArrayList<POGDetails>();
				names.add(pOGDetails);
				uniqueStrings.put(brand, names);
			} else {
				uniqueStrings.get(brand).add(pOGDetails);
			}

//			if (uniqueStrings.size() == 100) {
//				break;
//			}
			line = br.readLine();
		}

		Map<String, Map<POGDetails, Map<POGDetails, Distance>>> brandDistacneMap = new LinkedHashMap<String, Map<POGDetails, Map<POGDetails, Distance>>>();

		for (Entry<String, List<POGDetails>> entry : uniqueStrings.entrySet()) {
			Map<POGDetails, Map<POGDetails, Distance>> distanceMap = new LinkedHashMap<POGDetails, Map<POGDetails, Distance>>();
			for (int i = 0; i < entry.getValue().size(); i++) {
				for (int j = 0; j < entry.getValue().size(); j++) {
					if (i != j) {
						double d = calculateDistance(entry.getValue().get(i).getName(), entry.getValue().get(j).getName());
						if (d < 8) {
							if (distanceMap.get(entry.getValue().get(i)) == null) {
								LinkedHashMap<POGDetails, Distance> distace = new LinkedHashMap<POGDetails, Distance>();
								distace.put(entry.getValue().get(j),
										new Distance(d, entry.getValue().get(j).getPrice() - entry.getValue().get(i).getPrice()));
								distanceMap.put(entry.getValue().get(i), distace);
							} else {
								distanceMap.get(entry.getValue().get(i)).put(entry.getValue().get(j),
										new Distance(d, entry.getValue().get(j).getPrice() - entry.getValue().get(i).getPrice()));
							}
						}
					}
				}
			}
			brandDistacneMap.put(entry.getKey(), distanceMap);
		}

		File file = new File("/home/raghunandangupta/Downloads/footwear_pog_agg.csv");
		if (!file.exists())
			file.createNewFile();
		CsvWriter csvOutput = new CsvWriter(new FileWriter(file, true), ',');
		csvOutput.write("Brand");
		csvOutput.write("PogId");
		csvOutput.write("Name");
		csvOutput.write("Price");
		csvOutput.write("SimilarPog");
		csvOutput.write("SimilarName");
		csvOutput.write("SimilarPrice");
		csvOutput.write("DistanceDiff");
		csvOutput.write("PriceDiff");
		csvOutput.endRecord();
		for (Entry<String, Map<POGDetails, Map<POGDetails, Distance>>> entry : brandDistacneMap.entrySet()) {
			for (Entry<POGDetails, Map<POGDetails, Distance>> subEntry : entry.getValue().entrySet()) {
				for (Entry<POGDetails, Distance> lowestEntry : subEntry.getValue().entrySet()) {
					csvOutput.write(entry.getKey());
					csvOutput.write(subEntry.getKey().getPogId() + "");
					csvOutput.write(subEntry.getKey().getName());
					csvOutput.write(subEntry.getKey().getPrice() + "");
					csvOutput.write(lowestEntry.getKey().getPogId() + "");
					csvOutput.write(lowestEntry.getKey().getName() + "");
					csvOutput.write(lowestEntry.getKey().getPrice() + "");
					csvOutput.write(lowestEntry.getValue().getDistance() + "");
					csvOutput.write(lowestEntry.getValue().getPriceDiff() + "");
					csvOutput.endRecord();
				}
			}
		}
		csvOutput.flush();
		csvOutput.close();
	}

	public static final double calculateDistance(final String s1, final String s2) {
		if (s1 == null) {
			throw new NullPointerException("s1 must not be null");
		}

		if (s2 == null) {
			throw new NullPointerException("s2 must not be null");
		}

		if (s1.equals(s2)) {
			return 0;
		}

		if (s1.length() == 0) {
			return s2.length();
		}

		if (s2.length() == 0) {
			return s1.length();
		}

		// create two work vectors of integer distances
		int[] v0 = new int[s2.length() + 1];
		int[] v1 = new int[s2.length() + 1];
		int[] vtemp;

		// initialize v0 (the previous row of distances)
		// this row is A[0][i]: edit distance for an empty s
		// the distance is just the number of characters to delete from t
		for (int i = 0; i < v0.length; i++) {
			v0[i] = i;
		}

		for (int i = 0; i < s1.length(); i++) {
			// calculate v1 (current row distances) from the previous row v0
			// first element of v1 is A[i+1][0]
			// edit distance is delete (i+1) chars from s to match empty t
			v1[0] = i + 1;

			// use formula to fill in the rest of the row
			for (int j = 0; j < s2.length(); j++) {
				int cost = 1;
				if (s1.charAt(i) == s2.charAt(j)) {
					cost = 0;
				}
				v1[j + 1] = Math.min(v1[j] + 1, // Cost of insertion
						Math.min(v0[j + 1] + 1, // Cost of remove
								v0[j] + cost)); // Cost of substitution
			}

			// copy v1 (current row) to v0 (previous row) for next iteration
			// System.arraycopy(v1, 0, v0, 0, v0.length);

			// Flip references to current and previous row
			vtemp = v0;
			v0 = v1;
			v1 = vtemp;

		}

		return v0[s2.length()];
	}

	static class POGDetails implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Long pogId;
		private String name;
		private double price;

		public POGDetails(Long pogId, String name, double price) {
			super();
			this.pogId = pogId;
			this.name = name;
			this.price = price;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((pogId == null) ? 0 : pogId.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			POGDetails other = (POGDetails) obj;
			if (pogId == null) {
				if (other.pogId != null)
					return false;
			} else if (!pogId.equals(other.pogId))
				return false;
			return true;
		}

		public Long getPogId() {
			return pogId;
		}

		public void setPogId(Long pogId) {
			this.pogId = pogId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		@Override
		public String toString() {
			return pogId + "," + name + "," + price;
		}
	}

	static class Distance {
		private Double distance;
		private Double priceDiff;

		public Double getDistance() {
			return distance;
		}

		public void setDistance(Double distance) {
			this.distance = distance;
		}

		public Double getPriceDiff() {
			return priceDiff;
		}

		public void setPriceDiff(Double priceDiff) {
			this.priceDiff = priceDiff;
		}

		public Distance(Double distance, Double priceDiff) {
			super();
			this.distance = distance;
			this.priceDiff = Math.abs(priceDiff);
		}

		@Override
		public String toString() {
			return distance + "," + priceDiff;
		}

	}
}
