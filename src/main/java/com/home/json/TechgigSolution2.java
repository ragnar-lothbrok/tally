package com.home.json;

public class TechgigSolution2 {

	public static void main(String[] args) {
		System.out.println(maxTreeDestroyed(6, 7, 14, "((2,1),(6,6),(4,2),(2,5),(2,6),(2,7),(3,4),(6,1),(6,2),(2,3),(6,3),(6,4),(6,5),(6,7))"));
		System.out.println(maxTreeDestroyed(6, 7, 14, "((2,1),(6,6),(4,2),(2,5),(3,4),(6,1),(6,2),(2,3))"));
	}

	public static int maxTreeDestroyed(int input1, int input2, int input3, String input4) {
		int result = 0;
		int matrix[][] = new int[input1][input2];
		input4 = input4.replace("((", "");
		input4 = input4.replace("(", "");
		input4 = input4.replace("))", "");
		input4 = input4.replace("),", "#");
		String split[] = input4.split("#");
		for (int i = 0; i < split.length; i++) {
			String subSplit[] = split[i].split(",");
			matrix[Integer.parseInt(subSplit[0]) - 1][Integer.parseInt(subSplit[1]) - 1] = 1;
		}
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < input1; i++) {
			for (int j = 0; j < input2; j++) {
				if (matrix[i][j] == 1) {
					int hz = countHz(input1, input2, matrix, i, j);
					int vt = countVt(input1, input2, matrix, i, j);
					int maxLeftD = Integer.MIN_VALUE;
					for (int k = 1; k < input2; k++) {
						maxLeftD = Math.max(maxLeftD, 1 + countLeftDia(input1, input2, matrix, i, j, k));
					}

					int maxRightD = Integer.MIN_VALUE;
					for (int k = 1; k < input2; k++) {
						maxRightD = Math.max(maxRightD, 1 + countRightDia(input1, input2, matrix, i, j, k));
					}

					int temp = Math.max(Math.max(vt, hz), Math.max(maxRightD, maxLeftD));
					if (max < temp) {
						max = temp;
					}
				}
			}
		}
		result = max;
		return result;
	}

	private static int countHz(int input1, int input2, int matrix[][], int x, int y) {
		int count = 0;
		for (int i = 0; i < input2; i++) {
			if (matrix[x][i] == 1) {
				count++;
			}
		}
		return count;
	}

	private static int countVt(int input1, int input2, int matrix[][], int x, int y) {
		int count = 0;
		for (int i = 0; i < input1; i++) {
			if (matrix[i][y] == 1) {
				count++;
			}
		}
		return count;
	}

	private static int countLeftDia(int input1, int input2, int matrix[][], int x, int y, int jump) {
		int start = x, end = y;
		int count = 0;
		do {
			start--;
			end = end - jump;
			if((start > 0 && end > 0) && (start < input1 && end < input2)){
				if (matrix[start][end] == 1) {
					count++;
				}
			}
		} while ((start > 0 && end > 0) && (start < input1 && end < input2));
		
		do {
			x++;
			y = y + jump;
			if((x > 0 && y > 0) && (x < input1 && y < input2)){
				if (matrix[x][y] == 1) {
					count++;
				}
			}
		} while ((x > 0 && y > 0) && (x < input1 && y < input2));
		return count;
	}

	private static int countRightDia(int input1, int input2, int matrix[][], int x, int y, int jump) {
		int start = x, end = y;
		int count = 0;
		do {
			start--;
			end = end + jump;
			if((start > 0 && end > 0) && (start < input1 && end < input2)){
				if (matrix[start][end] == 1) {
					count++;
				}
			}
		} while ((start > 0 && end > 0) && (start < input1 && end < input2));
		
		do {
			x++;
			y = y - jump;
			if((x > 0 && y > 0) && (x < input1 && y < input2)){
				if (matrix[x][y] == 1) {
					count++;
				}
			}
		} while ((x > 0 && y > 0) && (x < input1 && y < input2));
		return count;
	}
}
