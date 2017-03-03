package com.he.cube26;

//http://www.geeksforgeeks.org/dynamic-programming-set-14-maximum-sum-increasing-subsequence/

class ABC {
	int i;

	public void display() {
		System.out.println("aBC");
	}
}

public class MaxSubSequence extends ABC {

	public void display() {
		super.i = 2;
		System.out.println("CDE");
	}

	public static void main(String[] args) {

		ABC abc = new MaxSubSequence();
		abc.display();

		MaxSubSequence maxSubSequence = new MaxSubSequence();
		maxSubSequence.display();

		int arr[] = { 1, 101, 2, 3, 100, 4, 5 };
		maxSumIS(arr);
	}

	private static void maxSumIS(int arr[]) {
		int msis[] = new int[arr.length];

		for (int j = 0; j < arr.length; j++) {
			msis[j] = arr[j];
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && msis[i] < msis[j] + arr[i]) {
					msis[i] = msis[j] + arr[i];
				}
			}
		}

		int max = Integer.MIN_VALUE;

		for (int j = 0; j < msis.length; j++) {
			if (max < msis[j]) {
				max = msis[j];
			}
		}

		System.out.println(max);

		System.out.println((int) 'Z');
		
		System.out.println(twinCase("BANANA", "Apple"));
		System.out.println(twinCase("BanAna", "apple"));
		System.out.println(twinCase("BanAna", "APple"));
		System.out.println(twinCase("Ba", "apple"));
	}

	public static String twinCase(String bluePrint, String root) {
		Boolean isAllCaps = null;
		Boolean isFirstCaps = null;
		if (!(bluePrint == null || bluePrint.trim().length() == 0)) {
			for (int i = 0; i < bluePrint.trim().length(); i++) {
				int ascii = bluePrint.trim().charAt(i);
				if (ascii >= 65 && ascii <= 90) {
					if (i == 0) {
						isFirstCaps = true;
					} else {
						isFirstCaps = false;
					}
					if (isAllCaps == null)
						isAllCaps = true;
				} else {
					isAllCaps = false;
				}
			}
		}
		if (isAllCaps != null && isAllCaps) {
			return root.toUpperCase();
		} else {
			if(isFirstCaps != null && isFirstCaps){
				String startStr = root.substring(0, 1);
				if(root.length() > 1){
					String restStr = root.substring(1, root.length());
					return startStr.toUpperCase()+""+restStr;
				}else{
					return root.toUpperCase();
				}
			}
		}
		return root;
	}
}
