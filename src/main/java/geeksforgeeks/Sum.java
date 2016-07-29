package geeksforgeeks;

public class Sum {

	public static void main(String[] args) {

		int arr[] = { 4, 8, 9, 2, 20 };

		findMaxValue(arr);
	}

	static int findMaxValue(int arr[]) {
		int n = arr.length;
		int MIN = Integer.MIN_VALUE;
		// If the array has less than 4 elements
		if (n < 4) {
			System.out.println("The array should have atlest 4 elements\n");
			return MIN;
		}

		// We create 4 DP tables
		int table1[] = new int[n + 1];
		int table2[] = new int[n + 1];
		int table3[] = new int[n + 1];
		int table4[] = new int[n + 1];

		// Initialsing all the tables to MIN
		for (int i = 0; i <= n; i++)
			table1[i] = table2[i] = table3[i] = table4[i] = MIN;

		// Filling table1[]
		for (int i = n - 1; i >= 0; i--)
			table1[i] = Math.max(table1[i + 1], arr[i]);

		// Filling table2[]
		for (int i = n - 1; i >= 0; i--)
			table2[i] = Math.max(table2[i + 1], table1[i + 1] - arr[i]);

		// Filling table3[]
		for (int i = n - 1; i >= 0; i--)
			table3[i] = Math.max(table3[i + 1], table2[i + 1] + arr[i]);

		// Filling table4[]
		for (int i = n - 1; i >= 0; i--)
			table4[i] = Math.max(table4[i + 1], table3[i + 1] - arr[i]);

		// Find Math.maximum value in table4[]
		int res = MIN;
		for (int i = 0; i <= n - 1; i++)
			res = Math.max(res, table4[i]);

		System.out.println(res);

		return (res);
	}
}
