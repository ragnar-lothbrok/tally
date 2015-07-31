package com.he.code_mania_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//https://www.hackerearth.com/code_mania_30/algorithm/arrow-and-the-echelon-1/
public class Solution2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Integer N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());
            System.out.println(getNumber(temp));
        }
    }

    private static String getNumber(int num) {
        int num5 = num / 3 * 3;
        int num3 = num - num5;
        StringBuffer sb = new StringBuffer();
        while (!(num3 % 5 == 0 && num5 % 3 == 0)) {
            num5 -= 3;
            num3 += 3;
            if (num5 < 0 || num3 > num)
                return "-1";
        }

        for (int i = 0; i < num5; i++)
            sb.append(5);
        for (int i = 0; i < num3; i++)
            sb.append(3);
        return sb.toString();
    }

}
