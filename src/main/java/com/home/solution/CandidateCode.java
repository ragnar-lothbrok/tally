package com.home.solution;

import java.text.DecimalFormat;
import java.util.Arrays;

public class CandidateCode {

	public static final String TRUE = "True";
	public static final String FALSE = "False";

	public static String triplet_sum(int[] input1, int input2, int input3) {
		if (input1 == null || (input2 != input1.length) || input2 < 3) {
			return FALSE;
		} else {
			Arrays.sort(input1);
			int left, right;
			for (int current = 0; current < input2 - 2; current++) {
				left = current + 1;
				right = input2 - 1;
				while (left < right) {
					if (input1[current] + input1[left] + input1[right] == input3) {
						return TRUE;
					} else if (input1[current] + input1[left] + input1[right] < input3)
						left++;
					else
						right--;
				}
			}
		}
		return FALSE;
	}

	public static final int[] bottleLimit = new int[] { 10, 7, 5, 1 };
	public static final int[] staticBottleCount = new int[] { 1, 2, 3, 4, 1, 2, 1, 2, 3, 1, 2, 2, 3, 2, 2, 3, 2, 3, 3, 2 };

	public static int minimumBottles(int input1) {

		int noOfBottlesRequired = 0;
		if (input1 <= 0) {
			return 0;
		} else if (input1 <= staticBottleCount.length) {
			return staticBottleCount[input1 - 1];
		} else {
			noOfBottlesRequired = (input1 / 10) - 1;
			int remainingQuantity = input1 - (((input1 / 10) - 1) * 10);
			noOfBottlesRequired += staticBottleCount[remainingQuantity - 1];
		}

		return noOfBottlesRequired;
	}

	public static int ThirstyCrowProblem(int[] input1, int input2, int input3) {
		int numOfPots = 0;
		Arrays.sort(input1);
		if (input1 == null || input3 > input2 || input1.length != input2 || input2 == 0 || input1[0] < 0) {
			numOfPots = -1;
		} else {
			int i = 0;
			while (input3 > i) {
				numOfPots += (input1[i]) * (input2 - i);
				for(int j=i+1;j<input2;j++){
					input1[j] = input1[j] - input1[i];
				}
				i++;
			}
		}
		return numOfPots;
	}

	public static int cadbury(int input1, int input2, int input3, int input4) {
		int numberOfChildren = 0;
		if (input2 <= 0 || input4 <= 0 || input1 < 0 || input3 < 0) {
			return numberOfChildren;
		} else {
			for (int i = input1; i <= input2; i++) {
				for (int j = input3; j <= input4; j++) {
					numberOfChildren += getChildrenCount(i, j);
				}
			}
		}
		return numberOfChildren;
	}

	public static int getChildrenCount(int width, int height) {
		int noOfChildren = 0;

		while (width != 0 && height != 0) {
			if (width > height) {
				noOfChildren += 1;
				width = width - height;
			} else if (width < height) {
				noOfChildren += 1;
				height = height - width;
			} else {
				noOfChildren += 1;
				width = 0;
				height = 0;
			}
		}

		return noOfChildren;
	}

	public static void main(String[] args) {
		
		
		System.out.println(ThirstyCrowProblem(new int[]{-5,0,10,15,20}, 5, 1));

		/*
		 * System.out.println(triplet_sum(new int[] { 12, 3, 4, 1, 6, 9 }, 6,
		 * 24)); System.out.println(triplet_sum(new int[] { 1, 1, 1 }, 3, 3));
		 * System.out .println(triplet_sum(new int[] { 1, 4, 45, 6, 10, 8 }, 6,
		 * 24)); System.out .println(triplet_sum(new int[] { 2, 3, 4, 5, 6, 7, 8
		 * }, 7, 12));
		 * 
		 * for (int i = 0; i <= 100; i++) { System.out.println(i + " " +
		 * minimumBottles(i)); }
		 */

		/* System.out.println(cadbury(5, 6, 3, 4)); */

//		System.out.println(get_total_profit(new String("50,200,30,5,3,2,2,15,10")));
//		System.out.println(get_total_profit(new String("10,10,5,2,2,3,1,14,25")));
//
//		System.out.println(get_total_profit(new String("10,10,5,0,2,3,1,14,25")));
//
//		double d = 0d;
//		System.out.println((String.valueOf(d)));
//		System.out.println(d == 0 ? "0.00" : ((d + "").substring(0, (d + "").indexOf(".") + 3)));

	}

	public static String get_total_profit(String input1) {
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		String result = null;
		double landArea = 0.0;
		double totalFertilizer = 0.0;
		double totalInsectiside = 0.0;
		double wheatFertilizer = 0.0;
		double wheatInsectiside = 0.0;
		double riceFertilizer = 0.0;
		double riceInsectiside = 0.0;
		double wheatPrice = 0.0;
		double ricePrice = 0.0;

		if (input1 == null || input1.trim().length() < 0) {
			return -1 + "";
		} else {
			String[] values = input1.trim().split(",");
			if (values.length < 9)
				return -1 + "";
			landArea = Double.parseDouble(values[0]);
			totalFertilizer = Double.parseDouble(values[1]);
			totalInsectiside = Double.parseDouble(values[2]);
			wheatFertilizer = Double.parseDouble(values[3]);
			wheatInsectiside = Double.parseDouble(values[4]);
			riceFertilizer = Double.parseDouble(values[5]);
			riceInsectiside = Double.parseDouble(values[6]);
			wheatPrice = Double.parseDouble(values[7]);
			ricePrice = Double.parseDouble(values[8]);
			double[] resultForWheat = getResultForWheat(landArea, totalFertilizer, totalInsectiside, wheatFertilizer, wheatInsectiside,
					riceFertilizer, riceInsectiside, wheatPrice, ricePrice);
			double[] resultForRice = getResultForRice(landArea, totalFertilizer, totalInsectiside, wheatFertilizer, wheatInsectiside, riceFertilizer,
					riceInsectiside, wheatPrice, ricePrice);
			if (resultForWheat[0] == resultForRice[0]) {
				return "-1";
			} else if (resultForWheat[0] > resultForRice[0]) {
				result = decimalFormat.format(resultForWheat[0]) + "," + decimalFormat.format(resultForWheat[1]) + ","
						+ decimalFormat.format(resultForWheat[2]);
			} else {
				result = decimalFormat.format(resultForRice[0]) + "," + decimalFormat.format(resultForRice[1]) + ","
						+ decimalFormat.format(resultForRice[2]);
			}
		}
		return result;
	}

	public static double[] getResultForWheat(double landArea, double totalFertilizer, double totalInsectiside, double wheatFertilizer,
			double wheatInsectiside, double riceFertilizer, double riceInsectiside, double wheatPrice, double ricePrice) {
		double[] result = new double[3];
		double remainingFertilizer = 0.0;
		double remainingInsectiside = 0.0;
		double safeWheatArea = 0.0;
		double leftSafeRiceArea = 0.0;
		if (wheatFertilizer == 0 && wheatInsectiside == 0) {
			safeWheatArea = landArea;
		} else if ((wheatFertilizer == 0 && wheatInsectiside != 0) || ((totalFertilizer / wheatFertilizer) > (totalInsectiside / wheatInsectiside))) {
			safeWheatArea = Math.min((totalInsectiside / wheatInsectiside), landArea);
			if (safeWheatArea != landArea)
				remainingFertilizer = totalFertilizer - (wheatFertilizer == 0 ? 0.0 : -(wheatFertilizer * (totalInsectiside / wheatInsectiside)));
		} else {
			safeWheatArea = Math.min(totalFertilizer / wheatFertilizer, landArea);
			if (safeWheatArea != landArea)
				remainingInsectiside = totalInsectiside - (wheatInsectiside == 0 ? 0.0 : (wheatInsectiside * (totalFertilizer / wheatFertilizer)));
		}
		if (remainingFertilizer != 0 || remainingInsectiside != 0) {
			if (remainingFertilizer != 0 && riceInsectiside == 0) {
				double leftLandArea = landArea - (landArea > safeWheatArea ? safeWheatArea : landArea);
				leftSafeRiceArea = (remainingFertilizer / riceFertilizer);
				if (leftLandArea < leftSafeRiceArea)
					leftSafeRiceArea = leftLandArea;
			} else if (remainingInsectiside != 0 && riceFertilizer == 0) {
				double leftLandArea = landArea - (landArea > safeWheatArea ? safeWheatArea : landArea);
				leftSafeRiceArea = (remainingInsectiside / riceInsectiside);
				if (leftLandArea < leftSafeRiceArea)
					leftSafeRiceArea = leftLandArea;
			}
		}

		result[0] = (safeWheatArea * wheatPrice) + (leftSafeRiceArea * ricePrice);
		result[1] = safeWheatArea;
		result[2] = leftSafeRiceArea;
		return result;
	}

	public static double[] getResultForRice(double landArea, double totalFertilizer, double totalInsectiside, double wheatFertilizer,
			double wheatInsectiside, double riceFertilizer, double riceInsectiside, double wheatPrice, double ricePrice) {
		double[] result = new double[3];
		double remainingFertilizer = 0.0;
		double remainingInsectiside = 0.0;
		double safeRiceArea = 0.0;
		double leftSafeWheatArea = 0.0;
		if (riceFertilizer == 0 && riceInsectiside == 0) {
			safeRiceArea = landArea;
		} else if ((riceFertilizer == 0 && riceInsectiside != 0) || (totalFertilizer / riceFertilizer) > (totalInsectiside / riceInsectiside)) {
			safeRiceArea = Math.min((riceInsectiside == 0 ? 0.0 : (totalInsectiside / riceInsectiside)), landArea);
			if (safeRiceArea != landArea)
				remainingFertilizer = totalFertilizer - (wheatFertilizer == 0 ? 0.0 : (riceFertilizer * (totalInsectiside / riceInsectiside)));
		} else {
			safeRiceArea = Math.min((totalFertilizer / riceFertilizer), landArea);
			if (safeRiceArea != landArea)
				remainingInsectiside = totalInsectiside - (riceInsectiside == 0 ? 0.0 : (riceInsectiside * (totalFertilizer / riceFertilizer)));
		}
		if (remainingFertilizer != 0 || remainingInsectiside != 0) {
			if (remainingFertilizer != 0 && wheatInsectiside == 0) {
				double leftLandArea = landArea - (landArea > safeRiceArea ? safeRiceArea : landArea);
				leftSafeWheatArea = (remainingFertilizer / wheatFertilizer);
				if (leftLandArea < leftSafeWheatArea)
					leftSafeWheatArea = leftLandArea;
			} else if (remainingInsectiside != 0 && wheatFertilizer == 0) {
				double leftLandArea = landArea - (landArea > safeRiceArea ? safeRiceArea : landArea);
				leftSafeWheatArea = (remainingInsectiside / wheatInsectiside);
				if (leftLandArea < leftSafeWheatArea)
					leftSafeWheatArea = leftLandArea;
			}
		}

		result[0] = (safeRiceArea * ricePrice) + (leftSafeWheatArea * wheatPrice);
		result[1] = leftSafeWheatArea;
		result[2] = safeRiceArea;
		return result;
	}
}
