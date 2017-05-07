package com.he.capillary.chegg1;

public class NumConvertor {

	public static void main(String[] args) {
		
		
		System.out.println("8888 In Binary : "+Integer.toBinaryString(8888));
		
		System.out.println("2555 : "+Integer.toUnsignedString(8888,6));
		
		System.out.println("8990  : "+Integer.toUnsignedString(8990,19));
		
		System.out.println("4667 In Binary : "+Integer.toString(4667,2));
		
		System.out.println("-4667 In Binary : "+Integer.toString(-4667,2));
		
		System.out.println("4645 -- 9"+Integer.toString(Integer.parseInt(4645+"", 9), 10));
		
		int num1 = Integer.parseInt(Integer.toString(Integer.parseInt(5665+"", 7), 10));
		int num2 = Integer.parseInt(Integer.toString(Integer.parseInt(4664+"", 7), 10));
		System.out.println(num1+num2);
	}
}
