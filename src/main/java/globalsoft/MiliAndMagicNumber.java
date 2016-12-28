package globalsoft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.hackerearth.com/globalsoft-backend-hiring-challenge/problems/d2849f5b79ab42558b32d859cd69025f/
public class MiliAndMagicNumber {

	public static void main(String[] args) throws IOException {

		int primeNumbers[] = new int[50 + 1];

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();

		Integer numOfTestCase = Integer.parseInt(line);

		for (int i = 0; i < primeNumbers.length; i++) {
			if (isPrime(i)) {
				primeNumbers[i] = 1;
			}
		}

		for (int i = 0; i < numOfTestCase; i++) {
			line = br.readLine();
			String split[] = line.split(" ");

			Integer primeNumberRange = Integer.parseInt(split[0]);
			Integer start = Integer.parseInt(split[1]);
			Integer end = Integer.parseInt(split[2]);
			
			

		}

	}

	static boolean isPrime(int n) {
		if (n != 2 && n % 2 == 0)
			return false;
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
