import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SumShell {
	public static final int DIGITS = 25;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("sum.txt"));
		processFile(input);
	}

	public static void processFile(Scanner input) {
		int lines = 0;
		while (input.hasNextLine()) {
			processLine(input.nextLine());
			lines++;
		}
		System.out.println();
		System.out.println("Total lines = " + lines);
	}

	public static void processLine(String data) {
		int[] result = new int[DIGITS];
		data = data.replaceAll("  ", " ");
		String[] nums = data.split(" ");
		transfer(nums[0], result);
		System.out.print(nums[0]);
		for (int i = 1; i < nums.length; i++) {
			int[] number = new int[DIGITS];
			transfer(nums[i], number);
			addTo(result, number);
			System.out.print(" + " + nums[i]);
		}
		System.out.print(" = ");
		print(result);
		System.out.println();
	}

	public static void transfer(String data, int[] digits) {
		int limit = 24;
		for (int i = data.length() - 1; i >= 0; i--) {
			digits[limit--] = Integer.parseInt(data.charAt(i) + "");
		}
	}

	public static void addTo(int[] sum, int[] number) {
		int carry = 0, sumDigit = 0;
		for (int i = DIGITS - 1; i >= 0; i--) {
			sumDigit = sum[i] + number[i] + carry;
			carry = 0;
			if (sumDigit >= 10) {
				sum[i] = sumDigit % 10;
				carry = sumDigit / 10;
			} else {
				sum[i] = sumDigit;
			}
		}
		if (carry > 0)
			throw new RuntimeException("overflow");
	}

	public static void print(int[] digits) {
		boolean startZero = true;
		for (int i = 0; i < 25; i++) {
			if (digits[i] != 0) {
				startZero = false;
			}
			if (!startZero)
				System.out.print(digits[i] + "");
		}
		if(startZero){
			System.out.println("0");
		}
	}
}
