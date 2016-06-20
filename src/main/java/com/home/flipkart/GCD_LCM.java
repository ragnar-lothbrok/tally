package com.home.flipkart;

public class GCD_LCM {

    public static void main(String[] args) {

        System.out.println(GCD(3, 4));
        System.out.println(LCM(10, 15));

    }

    public static int GCD(int a, int b) {
        if (a == b || a % b == 0 || b % a == 0) {
            return a;
        } else if (a > b) {
            return GCD(a % b, b);
        } else {
            return GCD(b % a, a);
        }
    }

    public static int LCM(int a, int b) {
        if (a != 0 && b != 0) {
            return a * b / GCD(a, b);
        }
        return -1;
    }
}
