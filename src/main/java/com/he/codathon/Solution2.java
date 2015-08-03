package com.he.codathon;

import java.util.Scanner;
///https://www.hackerearth.com/codathon-2/algorithm/the-game-of-nuts/
public class Solution2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            int a = scanner.nextInt();
            int k = scanner.nextInt();
            if (a % 2 == 0 || k % 2 == 0) {
                System.out.println("Shekhar");
            } else {
                System.out.println("Nilesh");

            }

        }
    }
}
