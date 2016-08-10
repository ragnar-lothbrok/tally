package com.home.geeks;

//https://www.quora.com/If-GCD-a-b-x*a+y*b-then-how-can-I-find-x-and-y
public class GCDFactor {

	/** Function to solve **/

	public static int[] coins_value(int[] input1) {
		int result[] = new int[2];
		int a = input1[0];
		int b = input1[1];
		if(a <= 0 || b <= 0){
			result[0] = 0;
			result[1] = 0;
			return result;
		}
		int x = 0, y = 1, lastx = 1, lasty = 0, temp;
		while (b != 0) {
			int q = a / b;
			int r = a % b;
			a = b;
			b = r;
			temp = x;
			x = lastx - q * x;
			lastx = temp;
			temp = y;
			y = lasty - q * y;
			
			lasty = temp;
		}
		result[0] = lastx;
		result[1] = lasty;
		return result;
	}

	/** Main function **/

	public static void main(String[] args)

	{
		coins_value(new int[] {-25, 45 });

	}

}
