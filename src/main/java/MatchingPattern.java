/*
 * http://www.geeksforgeeks.org/find-a-specific-pair-in-matrix/
 */
public class MatchingPattern {

	static char mat3[][] = { { 'a', 'b', 'c', 'd', 'e' }, { 'f', 'g', 'h', 'i', 'j' }, { 'k', 'l', 'm', 'n', 'o' }, { 'p', 'q', 'r', 's', 't' },
			{ 'u', 'v', 'w', 'x', 'y' } };

	static char mat[][] = { { 'a', 'b', 'c', 'd', 'e' }, { 'f', 'p', 'h', 'i', 'j' }, { 'k', 'q', 'm', 'n', 'o' }, { 'g', 'r', 'r', 's', 't' },
			{ 'u', 's', 'w', 'x', 'y' } };

	static char mat2[][] = { { 'a', 'b', 'c', 'd', 'e' }, { 'f', 's', 'h', 'i', 'j' }, { 'k', 'r', 'm', 'n', 'o' }, { 'g', 'q', 'r', 's', 't' },
			{ 'u', 'p', 'w', 'x', 'y' } };

	static String pattern = "pqrs";

	public static void main(String[] args) {
		complexApproach();
		easyKMPApproach();
	}

	public static int[] createIndexArray(char[][] mat, String type, int index) {
		StringBuilder sb = new StringBuilder();
		if ("row".equalsIgnoreCase(type)) {
			for (int i = 0; i < mat[0].length; i++) {
				sb.append(mat[index][i]);
			}
		} else {
			for (int i = 0; i < mat.length; i++) {
				sb.append(mat[i][index]);
			}
		}
		return createIndexArray(sb.toString());

	}

	public static int[] createIndexArray(String newPattern) {
		int[] indexArr = new int[newPattern.length()];
		int i = 0, j = 1;
		indexArr[0] = 0;
		while (i < indexArr.length && j < indexArr.length) {
			// If Both index have same character then we have to increment i & j
			if (newPattern.charAt(i) == newPattern.charAt(j)) {
				indexArr[j] = i + 1;
				i++;
				j++;
			} else if (i == 0) {
				indexArr[j++] = 0;
			}
			// If Both index have not same character then we have to set index
			// of i to i-1's value
			else {
				i = indexArr[i - 1];
				continue;
			}
		}

		for (i = 0; i < indexArr.length; i++) {
			System.out.print(indexArr[i] + " ");
		}
		System.out.println();
		return indexArr;

	}

	public static void easyKMPApproach() {
		// Row wise pattern matching
		for (int i = 0; i < mat.length; i++) {
			int patternIndexer[] = createIndexArray(mat, "row", i);
			int maxRow = mat[0].length;
			int patternLength = pattern.trim().length();
			int l = 0, k = 0;
			while (l < maxRow && k < patternLength) {
				if (mat[i][l] == pattern.charAt(k)) {
					k++;
					l++;
				} else {
					if (k - 1 >= 0 && patternIndexer[k - 1] != 0) {
						k = patternIndexer[k - 1];
					} else if (k - 1 >= 0 && patternIndexer[k - 1] == 0) {
						k = 0;
					} else {
						l++;
					}
				}
			}
			if (k == patternLength) {
				System.out.println("Horizontal");
				break;
			}
		}

		// Column wise pattern matching

		for (int i = 0; i < mat.length; i++) {
			int patternIndexer[] = createIndexArray(mat, "column", i);
			int maxRow = mat[0].length;
			int patternLength = pattern.trim().length();
			int l = 0, k = 0;
			while (l < maxRow && k < patternLength) {
				if (mat[l][i] == pattern.charAt(k)) {
					k++;
					l++;
				} else {
					if (k - 1 >= 0 && patternIndexer[k - 1] != 0) {
						k = patternIndexer[k - 1];
					} else if (k - 1 >= 0 && patternIndexer[k - 1] == 0) {
						k = 0;
					} else {
						l++;
					}
				}
			}

			if (k == patternLength) {
				System.out.println("Vertical");
				break;
			}
		}
	}

	public static void complexApproach() {

		// Row wise pattern matching
		for (int i = 0; i < mat.length; i++) {
			int maxRow = mat[0].length;
			int patternLength = pattern.trim().length();
			int l = 0, k = 0;
			while (l < maxRow && k < patternLength) {
				if (mat[i][l] == pattern.charAt(k)) {
					k++;
				} else {
					k = 0;
				}
				l++;
			}
			if (k == patternLength) {
				System.out.println("Horizontal");
				break;
			}
		}

		// Column wise pattern matching

		for (int i = 0; i < mat.length; i++) {
			int maxRow = mat[0].length;
			int patternLength = pattern.trim().length();
			int l = 0, k = 0;
			while (l < maxRow && k < patternLength) {
				if (mat[l][i] == pattern.charAt(k)) {
					k++;
				} else {
					k = 0;
				}
				l++;
			}

			if (k == patternLength) {
				System.out.println("Vertical");
				break;
			}
		}
	}
}
