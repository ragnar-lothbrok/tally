package com.home.strings;

public class DecimalToRoman {
    static String roman[] = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
    static int decimal[] = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

    public static void main(String[] args) {
        convertIntoRoman(114);
    }

    private static void convertIntoRoman(int num) {
        String str = "";
        if (num > 0 && num < 4000) {
            for (int i = 0; i < 13; i++) {
                while (num >= decimal[i]) {
                    num = num - decimal[i];
                    str = str + roman[i];
                }
            }
            System.out.println("Roman Equivalent = " + str);
        }

        else
            System.out.println("nYou entered a number out of Range.nPlease enter a number in the range [1-3999]");
    }

}
