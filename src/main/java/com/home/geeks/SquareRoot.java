package com.home.geeks;

//https://www.quora.com/How-do-I-write-a-program-for-finding-the-square-root-of-a-number-without-using-the-sqrt-function
public class SquareRoot {

	public static void main(String[] args) {
		System.out.println(sqrt(25));
	}

	private static float sqrt(int x) {
		int k = 0;
		int kmax = 1000;
		float s = 1, prev;
		for (k = 0; k < kmax; k++) {
			prev = s;
			s = (s + x / s) / 2;
			System.out.println(s);
			if (prev == s) {
				break;
			}
		}
		return s;
	}
}
