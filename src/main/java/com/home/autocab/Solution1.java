package com.home.autocab;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(coins_value(new int[] { 45, 25 }));
        System.out.println(coins_value(new int[] { 10, 15 }));
        System.out.println(coins_value(new int[] { 35, 10 }));
        System.out.println(coins_value(new int[] { 31, 2 }));
        System.out.println(coins_value(new int[] { 48, 56 }));
        System.out.println(coins_value(new int[] { 16, 56 }));

        System.out.println(coins_value(new int[] { 25, 45 }));
        System.out.println(coins_value(new int[] { 15, 10 }));
        System.out.println(coins_value(new int[] { 10, 35 }));
        System.out.println(coins_value(new int[] { 48, 180 }));
        System.out.println(coins_value(new int[] { 10, 20 }));

        System.out.println(coins_value(new int[] { 54, 24 }));
        System.out.println(coins_value(new int[] { 0, 0 }));
        System.out.println(coins_value(new int[] { 1, 0 }));
        System.out.println(coins_value(new int[] { 0, 1 }));
        System.out.println(coins_value(new int[] { 81, 18 }));
        System.out.println(coins_value(new int[] { 81, 15 }));
        System.out.println(coins_value(new int[] { 15, 81 }));
    }

    public static int[] coins_value(int[] input1) {
        int[] result = new int[2];
        if (input1[0] <= 0 || input1[1] <= 0) {
            result[0] = 0;
            result[1] = 0;
        } else {
            int value = gcd(input1[0], input1[1]);
            if (input1[0] > input1[1]) {

                int diff = 0;
                int temp1 = input1[0];
                int temp2 = input1[1];
                while (diff != value) {
                    diff = Math.abs(input1[0] - input1[1]);
                    while (diff > value) {
                        if (input1[0] < input1[1])
                            break;
                        input1[1] = input1[1] + temp2;
                        result[1]++;
                        diff = Math.abs(input1[0] - input1[1]);
                    }
                    if (diff != value) {
                        input1[0] = input1[0] + temp1;
                        result[0]++;
                        diff = Math.abs(input1[0] - input1[1]);
                    }
                }
                result[0]++;
                result[1]++;
                if (input1[0] > input1[1]) {
                    result[1] = result[1] * -1;
                } else if (input1[0] < input1[1]) {
                    result[0] = result[0] * -1;
                }

            } else if (input1[0] < input1[1]) {

                int diff = 0;
                int temp1 = input1[0];
                int temp2 = input1[1];
                while (diff != value) {
                    diff = Math.abs(input1[0] - input1[1]);
                    while (diff > value) {
                        if (input1[1] < input1[0])
                            break;
                        input1[0] = input1[0] + temp1;
                        result[0]++;
                        diff = Math.abs(input1[0] - input1[1]);
                    }
                    if (diff != value) {
                        input1[1] = input1[1] + temp2;
                        result[1]++;
                        diff = Math.abs(input1[0] - input1[1]);
                    }
                }
                result[0]++;
                result[1]++;
                if (input1[0] > input1[1]) {
                    result[1] = result[1] * -1;
                } else if (input1[0] < input1[1]) {
                    result[0] = result[0] * -1;
                }
            } else {
                result[0] = 2;
                result[1] = -1;
            }
        }
        // System.out.println(result[0] + " " + result[1]);
        return result;
    }

    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a - b * (a / b));
    }
}
