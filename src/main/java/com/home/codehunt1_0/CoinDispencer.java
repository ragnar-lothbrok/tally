package com.home.codehunt1_0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//https://www.hackerrank.com/challenges/coin-change/submissions/code/14086931
public class CoinDispencer {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String str[] = line.split(" ");
        int num = Integer.parseInt(str[0]);
        line = br.readLine();
        str = line.split(" ");
        int coinArr[] = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            coinArr[i] = Integer.parseInt(str[i]);
        }
        System.out.println(dispenceCoint(num, coinArr, coinArr.length));
    }

    // Dynamic Programming
    public static long dispenceCoint(int num, int[] S, int coinsLength) {
        long table[] = new long[num + 1];
        table[0] = 1;

        // Pick all coins one by one and update the table[] values
        // after the index greater than or equal to the value of the
        // picked coin
        for (int i = 0; i < coinsLength; i++) {
            for (int j = S[i]; j <= num; j++)
                table[j] += table[j - S[i]];
        }
        return table[num];
    }

    public static long dispenceCointR(int num, int[] coinArr, int coinCount) {
        if (num == 0)
            return 1;
        else if (num < 0) {
            return 0;
        } else if (coinCount <= 0 && num > 0) {
            return 0;
        }
        return dispenceCointR(num, coinArr, coinCount - 1)
                + dispenceCointR(num - coinArr[coinCount - 1], coinArr, coinCount);
    }

}
