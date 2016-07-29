package com.home.geeks;

public class Test {

	public static void main(String[] args) {
		byte a[] = { 65, 66, 67, 68, 69, 70 };

		byte b[] = { 71, 72, 73, 74, 75, 76 };

		System.arraycopy(a, 2, b, 1, a.length-2);

		System.out.print(new String(a) + " " + new String(b));
		
		char chars[] = {'a', 'b', 'c'};

		String s = new String(chars);

		System.out.println(s);
		
		Long i = new Long(256);

		System.out.print(i.hashCode());
	}
}
