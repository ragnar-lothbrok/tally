import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {

		int input = 7;

		// int result = processInput(input);
		// System.out.println(result);

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			String n = in.next();
			System.out.println("Case #" + i + ": " + processInput(n));
		}

	}

	private static String processInput(String input) {
		int[] newGuess = new int[input.length()];
		for (int i = 0; i < input.length(); i++) {
			newGuess[i] = input.charAt(i) - '0';
		}
		// printArr(newGuess);
		int result = 0;
		String resultStr = "";
		boolean makeAllNine = false;
		for (int i = 0; i < newGuess.length; i++) {
			boolean isSmallestDigit = true;
			for (int j = i + 1; j < newGuess.length; j++) {
				if (newGuess[i] > newGuess[j]) {
					isSmallestDigit = false;
					break;
				}
			}
			if (makeAllNine) {
				result = result * 10 + 9;
				resultStr = resultStr + "9";
				continue;
			}

			if (isSmallestDigit) {
				result = result * 10 + newGuess[i];
				resultStr = resultStr + newGuess[i];
			} else {
				if (resultStr.equals("") && newGuess[i] == 1) {
					makeAllNine = true;
				} else {
					result = result * 10 + (newGuess[i] - 1);
					resultStr = resultStr + (newGuess[i] - 1);
					makeAllNine = true;
				}
			}
		}
		return resultStr;
	}

	private static void printArr(int[] newGuess) {
		System.out.println();
		for (int i = 0; i < newGuess.length; i++) {
			System.out.print(newGuess[i] + "  ");
		}
	}
}
