package com.home.flipkart;

//http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
public class LongestCommonSubSequenceString {

	public static void main(String[] args) {
		String str1 = "AGGTAB";
		String str2 = "GXTXAYB";
		
		findLongestCommonSubsequence(str1, str2);
	}

	private static void findLongestCommonSubsequence(String str1, String str2) {
		int arr[][] = new int[str1.length()][str2.length()];

		for (int i = 0; i < str1.length(); i++) {
			for (int j = 0; j < str2.length(); j++) {
				if(str1.charAt(i) == str2.charAt(j)){
					if(i-1 >= 0 && j-1 >= 0){
						arr[i][j] = 1 + arr[i-1][j-1];
					}else{
						arr[i][j] = 1;
					}
				}else{
					if(j-1 >= 0 && i-1 >= 0){
						arr[i][j] = Math.max(arr[i][j-1], arr[i-1][j]);
					}else if(j-1 >= 0){
						arr[i][j] = arr[i][j-1];
					}else if(i-1 >= 0){
						arr[i][j] = arr[i-1][j];
					}
				}
			}
		}
		
		for (int i = 0; i < str1.length(); i++) {
			for(int k = 0; k < str1.length(); k++){
				System.out.print(arr[i][k]+" ");
			}
			System.out.println();
		}
		
		System.out.println(arr[str1.length()-1][str2.length()-1]);
	}
}
