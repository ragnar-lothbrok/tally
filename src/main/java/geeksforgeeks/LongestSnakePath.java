package geeksforgeeks;

import java.util.Stack;

//http://www.geeksforgeeks.org/find-maximum-length-snake-sequence/
public class LongestSnakePath {

	public static int maxPath = 0;

	public static void main(String[] args) {

		int mat[][] = { { 9, 6, 5, 2 }, { 8, 7, 6, 5 }, { 7, 3, 1, 6 }, { 1, 1, 1, 7 }, };
		dynamicProgramming(mat);

	}

	private static void dynamicProgramming(int mat[][]) {
		int aux[][] = new int[mat[0].length][mat.length];
		int maxI = -1, maxJ = -1, maxLength = 0;
		for (int i = 0; i < mat[0].length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (i == 0 && i == j) {
					continue;
				}
				if (i - 1 >= 0 && Math.abs(mat[i][j] - mat[i - 1][j]) == 1) {
					aux[i][j] = Math.max(aux[i][j], aux[i - 1][j] + 1);
					if (maxLength < aux[i][j]) {
						maxLength = aux[i][j];
						maxI = i;
						maxJ = j;
					}
				}
				if (j - 1 >= 0 && Math.abs(mat[i][j] - mat[i][j - 1]) == 1) {
					aux[i][j] = Math.max(aux[i][j], aux[i][j - 1] + 1);
					if (maxLength < aux[i][j]) {
						maxLength = aux[i][j];
						maxI = i;
						maxJ = j;
					}
				}
			}
		}

		findPath(aux, mat, maxI, maxJ);
	}

	public static void findPath(int aux[][], int mat[][], int maxI, int maxJ) {
		Stack<Integer> stack = new Stack<Integer>();
		int maxLength = aux[maxI][maxJ];
		stack.push(mat[maxI][maxJ]);
		while (maxLength != 0) {
			if (maxI - 1 >= 0 && aux[maxI - 1][maxJ] == maxLength - 1) {
				stack.push(mat[maxI - 1][maxJ]);
				maxI = maxI - 1;
				maxLength = maxLength - 1;
			} else if (maxJ - 1 >= 0 && aux[maxI][maxJ - 1] == maxLength - 1) {
				stack.push(mat[maxI][maxJ - 1]);
				maxJ = maxJ - 1;
				maxLength = maxLength - 1;
			}
		}
		System.out.println(stack);
	}

	private static void findMaximumPath(int mat[][], int indexI, int indexJ, int count) {
		if (!((indexI + 1 < mat[0].length && Math.abs(mat[indexI + 1][indexJ] - mat[indexI][indexJ]) == 1)
				|| (indexJ + 1 < mat.length && Math.abs(mat[indexI][indexJ + 1] - mat[indexI][indexJ]) == 1))) {
			if (maxPath < count) {
				maxPath = count;
			}
			return;
		} else {
			if (indexI + 1 < mat[0].length) {
				if (Math.abs(mat[indexI + 1][indexJ] - mat[indexI][indexJ]) == 1) {
					count++;
					findMaximumPath(mat, indexI + 1, indexJ, count);
				}
			}
			if (indexJ + 1 < mat.length) {
				if (Math.abs(mat[indexI][indexJ + 1] - mat[indexI][indexJ]) == 1) {
					count++;
					findMaximumPath(mat, indexI, indexJ + 1, count);
				}
			}
		}
	}
}
