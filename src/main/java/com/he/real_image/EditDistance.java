package com.he.real_image;

//http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
public class EditDistance {

	public static void main(String[] args) {
		String str1 = "geek", str2 = "geeks";
//		String str1 = "cat", str2 = "cut";
//		String str1 = "sunday", str2 = "saturday";
		editDistance(str1, str2);
	}

	private static void editDistance(String str1, String str2) {
			int arr[][] = new int[str1.length()+1][str2.length()+1];
	
			for (int i = 0; i <= str1.length(); i++) {
				arr[i][0] = i;
			}
	
			for (int i = 0; i <= str2.length(); i++) {
				arr[0][i] = i;
			}
	
			for (int i = 1; i <= str1.length(); i++) {
				for (int j = 1; j <= str2.length(); j++) {
					if(str1.charAt(i-1) == str2.charAt(j-1)){
						arr[i][j] = arr[i-1][j-1];
					}else {
						arr[i][j] = 1 + Math.min(arr[i-1][j], Math.min(arr[i][j-1], arr[i-1][j-1]));
					}
				}
				
				for(int k=0;k<=str1.length();k++){
					for(int l=0;l<=str2.length();l++){
						System.out.print(arr[k][l]+" ");
					}
					System.out.println();
				}
				
				System.out.println();
			}
			
			System.out.println(arr[str1.length()-1][str2.length()-1]);
		}
	
	}
