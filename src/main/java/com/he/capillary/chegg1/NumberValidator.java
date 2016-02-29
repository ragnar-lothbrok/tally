package com.he.capillary.chegg1;

/**
 * Uncomment the Scanner part if you want to take input from Standard input
 *
 */
public class NumberValidator {

	public static void main(String[] args) {

		// Scanner sc = new Scanner(System.in);
		// String data = sc.nextLine();

		String data = "dddssdfA97B1101HABM1235";
		boolean allFalse = true;

		// Case 1
		int index1 = data.indexOf('A');
		int index2 = data.indexOf('B');
		String str = data.substring(index1 + 1, index2);
		try {
			int num = Integer.parseInt(str);
			System.out.println(((char) (num - 1)) + " " + ((char) num) + " " + ((char) (num + 1)));
			allFalse = false;
		} catch (Exception exception) {
			System.out.println("PASS");
		}

		// Case 2
		index1 = data.indexOf('B');
		index2 = data.indexOf('H');
		str = data.substring(index1 + 1, index2);
		try {
			int binary = Integer.parseInt(str);
			int decimal = 0;
			int power = 0;
			while (true) {
				if (binary == 0) {
					break;
				} else {
					int tmp = binary % 10;
					decimal += tmp * Math.pow(2, power);
					binary = binary / 10;
					power++;
				}
			}
			System.out.println(decimal);
			allFalse = false;
		} catch (Exception exception) {
			System.out.println("PASS");
		}

		// Case 3
		index1 = data.indexOf('H');
		index2 = data.indexOf('M');
		str = data.substring(index1 + 1, index2);
		try {
			int temp = Integer.parseInt(str, 16);
			System.out.println(temp);
			allFalse = false;
		} catch (Exception exception) {
			System.out.println("PASS");
		}

		// Case 4
		index1 = data.indexOf('M');
		str = data.substring(index1 + 1, data.length());
		try {
			int mul = 1;
			for (int i = 0; i < str.length(); i++) {
				mul *= Integer.parseInt(str.charAt(i) + "");
			}
			System.out.println(mul);
			allFalse = false;
		} catch (Exception exception) {
			System.out.println("PASS");
		}

		if (allFalse == false)
			System.out.println("Goodbye.");
	}
	
	
}
