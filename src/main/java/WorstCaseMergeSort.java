//http://www.geeksforgeeks.org/find-a-permutation-that-causes-worst-case-of-merge-sort/
public class WorstCaseMergeSort {

	public static void main(String[] args) {
//		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
//		rearrangeArray(arr, 0, arr.length);
//		display(arr);

		int sum = 40;
		getCombinations(new int[235], sum, 0, sum);

	}

	private static void getCombinations(int arr[], int reducedSum, int index, int originalSum) {
		if(reducedSum < 0){
			return;
		}
			
		if (reducedSum == 0) {
			for (int i = 0; i < index; i++) {
				if (arr[i] != 0) {
					System.out.print(arr[i] + " ");
				}else{
					break;
				}
			}
			System.out.println();
		}
		int prev = (index == 0)? 1 : arr[index-1];
		for (int i = prev; i <= originalSum; i++) {
			arr[index] = i;
			getCombinations(arr, reducedSum-arr[index],index+1, originalSum);
		}
	}

	private static void rearrangeArray(int arr[], int low, int upperLimit) {
		System.out.println("Low : " + low + " Upper : " + upperLimit);
		if (upperLimit <= low) {
			return;
		}
		if (low == 1 && upperLimit == 2) {
			System.out.println();
		}
		if (upperLimit % 2 == 0) {
			int arrLeft[] = new int[upperLimit / 2];
			int arrRight[] = new int[upperLimit / 2];
			for (int i = low, j = 0; i < upperLimit && j < arrLeft.length; i = i + 2, j++) {
				arrLeft[j] = arr[i];
			}
			for (int i = low + 1, j = 0; i < upperLimit && j < arrLeft.length; i = i + 2, j++) {
				arrRight[j] = arr[i];
			}
			for (int i = low; i < arrLeft.length; i++) {
				arr[i] = arrLeft[i];
			}
			for (int i = low + arrLeft.length, j = 0; i < arr.length && j < arrRight.length; i++, j++) {
				arr[i] = arrRight[j];
			}
			if (upperLimit - low > 1) {
				rearrangeArray(arr, low, upperLimit / 2);
				rearrangeArray(arr, upperLimit / 2, upperLimit);
			}
		} else {
			int arrLeft[] = new int[upperLimit / 2 + 1];
			int arrRight[] = new int[upperLimit / 2];
			for (int i = low, j = 0; i < upperLimit && j < arrLeft.length; i = i + 2, j++) {
				arrLeft[j] = arr[i];
			}
			for (int i = low + 1, j = 0; i < upperLimit && j < arrLeft.length; i = i + 2, j++) {
				arrRight[j] = arr[i];
			}
			for (int i = low; i < arrLeft.length; i++) {
				arr[i] = arrLeft[i];
			}
			for (int i = low + arrLeft.length, j = 0; i < arr.length && j < arrRight.length; i++, j++) {
				arr[i] = arrRight[j];
			}
			if (upperLimit - low > 1) {
				rearrangeArray(arr, low, upperLimit / 2);
				rearrangeArray(arr, upperLimit / 2 + 1, upperLimit);
			}
		}
	}

	private void joinLeftRightArray(int arr[], int arrLeft[], int arrRight[], int l, int m, int r) {
		int i = 0;
		for (i = l; i <= m - l; i++)
			arrLeft[i] = arr[i * 2];

		for (i = 0; i < r - m; i++)
			arrRight[i] = arr[i * 2 + 1];
	}

	private void fillLeftRightArray(int arr[], int arrLeft[], int arrRight[], int l, int m, int r) {
		for (int i = 0; i <= m - l; i++)
			arrLeft[i] = arr[i * 2];

		for (int i = 0; i < r - m; i++)
			arrRight[i] = arr[i * 2 + 1];
	}

	public static void display(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
