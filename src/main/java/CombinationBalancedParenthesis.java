//http://www.geeksforgeeks.org/print-all-combinations-of-balanced-parentheses/

public class CombinationBalancedParenthesis {

	private final static String LEFT = "{";
	private final static String RIGHT = "}";

	public static void main(String[] args) {

		int n = 4;

		String arr[] = new String[n * 2];

		combination(arr, 0, n, n);
	}

	private static void combination(String arr[], int k, int left, int right) {
		if (k == arr.length) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]);
			}
			System.out.println();
		} else if (left == right && left > 0) {
			arr[k++] = LEFT;
			left--;
			combination(arr, k, left, right);
		} else if (left < right && left > 0) {
			arr[k++] = LEFT;
			left--;
			combination(arr, k, left, right);

			k--;
			left++;
			arr[k++] = RIGHT;
			right--;
			combination(arr, k, left, right);
		} else if (right > 0) {
			arr[k++] = RIGHT;
			right--;
			combination(arr, k, left, right);
		}
	}
}
