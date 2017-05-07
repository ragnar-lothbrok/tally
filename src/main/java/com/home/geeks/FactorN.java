package com.home.geeks;

//http://www.geeksforgeeks.org/no-factors-n/
public class FactorN {

	public static void main(String[] args) {
		countFactor(16);
	}

	private static void countFactor(Integer n) {
		int primes[] = new int[n + 1];
		int mul = 1;
		for (int i = 2; i <= n; i++) {
			if (isPrime(i)) {
				int sum = 1;
				for (int j = 1; j <= n; j++) {
					sum += (n / Math.pow(i, j));
				}
				System.out.println(i + " " + sum);
				mul *= sum;
			}
		}

		System.out.println(mul);
	}

	private static boolean isPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
