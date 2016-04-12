package p1caccia.test;

import java.util.Scanner;

public class NetID_Sieve {

	public static void main(String args[])

	{

		final int HOWMANY = 50000;
		boolean[] sieve = new boolean[HOWMANY + 1];
		int lower = 1, upper = HOWMANY;

		Scanner scanner = new Scanner(System.in);

		lower = getLower(scanner);
		upper = getUpper(scanner);
		processSieve(sieve);
		showPrimes(sieve, lower, upper);
	}

	public static void processSieve(boolean[] sieve) {

		sieve[0] = false;
		sieve[1] = false;
		for (int i = 2; i < sieve.length; i++) {
			sieve[i] = isPrime(i);
		}
	}

	public static boolean isPrime(int number) {
		for (int i = 2; i <= number / 2; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static Integer getLower(Scanner scanner) {
		System.out.println("Please enter lower limit (1,50000)");
		int limit = scanner.nextInt();
		while (limit <= 0 || limit > 50000) {
			limit = getLower(scanner);
		}
		return limit;
	}

	public static Integer getUpper(Scanner scanner) {
		System.out.println("Please enter upper limit (1,50000)");
		int limit = scanner.nextInt();
		while (limit <= 1 || limit > 50000) {
			limit = getUpper(scanner);
		}
		return limit;
	}

	public static void showPrimes(boolean[] primes, int lower, int upperbnd) {
		int countPairs = 0;
		System.out.println("Here are all of the sexy prime pairs in the range " + lower + " to " + upperbnd
				+ ", one pair per line:");
		for (int i = lower; i < upperbnd - 6; i++) {
			if (primes[i] == true && primes[i + 6] == true) {
				countPairs++;
				System.out.println(i + " and " + (i + 6));
			}
		}
		System.out.println("There were " + countPairs + " sexy prime pairs displayed");
	}

}
