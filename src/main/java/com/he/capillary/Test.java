package com.he.capillary;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		int l=0;
		for (int i = 1; i <=10; i++) {
            for (int j = i+1; j <= 10; j++) {
            	for (int k = j+1; k <= 10; k++) {
                	l = l+1;
                }
            }
		}
		StringIterator si = new StringIterator("abcd");
		while(si.hasNext()){
			System.out.println(si.next());
		}

		 Scanner scanner = new Scanner(System.in);
		 System.out.print("Enter String1 : ");
	       String str1 = scanner.next();
	       System.out.print("Enter String2 : ");
	       String str2 = scanner.next();

	       Double d1 = Double.parseDouble(str1);
	       Double d2 = Double.parseDouble(str2);

	       Double result = ((d1 % 2) + (d2 * (Math.pow(d1, 4) / Math.PI)))
	               - (Math.cos(0) * Math.sqrt(Math.pow(d1, 2) + 9) / 4);
	       System.out.printf("\\%.13f\\\n", result);
	       System.out.printf("\"%s\"", result);

	}
}
