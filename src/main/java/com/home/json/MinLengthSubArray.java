package com.home.json;

public class MinLengthSubArray {

	public static void main(String[] args) {
//		System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,13}));
		
		int intNum= 100;
		double dbleNum= 100;
		System.out.format("%2d-%1f", intNum,dbleNum);
	}

	public static int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int i = 0;
		int j = 0;
		int sum = 0;

		int minLen = Integer.MAX_VALUE;

		while (j < nums.length) {
			if (sum < s) {
				sum += nums[j];
				j++;
			} else {
				minLen = Math.min(minLen, j - i);
				if (i == j - 1)
					return 1;

				sum -= nums[i];
				i++;
			}
		}

		while (sum >= s) {
			minLen = Math.min(minLen, j - i);

			sum -= nums[i++];
		}

		return minLen == Integer.MAX_VALUE ? 0 : minLen;
	}
}
