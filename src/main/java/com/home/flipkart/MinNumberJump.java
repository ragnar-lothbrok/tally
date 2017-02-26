package com.home.flipkart;

//http://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
public class MinNumberJump {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		minJumps(arr);
	}

	private static void minJumps(int arr[]) {
		int jump[] = new int[arr.length];
		jump[0] = 0;

		for (int i = 1; i < arr.length; i++) {
			jump[i] = Integer.MAX_VALUE;
			for(int j=0;j<i;j++){
				if(i<= j + arr[j] && jump[j] != Integer.MAX_VALUE){
					jump[i] = Math.min(jump[i], jump[j]+1); 
					for (int k = 0; k < arr.length; k++) {
						System.out.print(jump[k]+" ");
					}
					System.out.println();
					break;
				}
			}
		}
		
		
		System.out.println(jump[arr.length-1]);
	}
}
