package com.test.Shopsense;

public class Test {

    public static void main(String[] args) {

        String str[] = new String[] { "01", "11", "00" };
        int value = Integer.parseInt(str[0], 2);
        for (int i = 1; i < str.length; i++) {
            value = value | Integer.parseInt(str[i], 2);
        }   
        System.out.println("01".hashCode());
        System.out.println("01".hashCode());
        System.out.println("10".hashCode());

    }

}
