package com.home.geeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.hackerearth.com/thoughtworks-application-developer-hiring-challenge/problems/d8b38ec195ba45b1a00d0e89301982bb/
public class CountPrimeProblems {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int count = Integer.parseInt(line);

		if(count < 1){
			System.out.println(0);
			return ;
		}
		line = br.readLine();
		int arr[] = new int[count];
		String str[] = line.split(" ");
		for (int i = 0; i < str.length; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}

		int result = 0;
		for (int i = count; i >= 0; i--) {
			if (isPrime(i)) {
				result = i;
				break;
			}
		}

		long maxSum = 0, sum = 0;
		if (result == count) {
			for (int i = 0; i < str.length; i++) {
				maxSum += arr[i];
			}
		} else {
			for (int i = 0; i < count - result + 1; i++) {
				for (int j = i; j < i + result; j++) {
					sum += arr[j];
				}
				if (maxSum < sum) {
					maxSum = sum;
				}
				sum = 0;
			}

		}

		System.out.println(maxSum);

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
