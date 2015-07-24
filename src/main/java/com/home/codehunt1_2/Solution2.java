// https://www.hackerearth.com/code_hunt_12/algorithm/check-array/
package com.home.codehunt1_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            br.readLine();
            line = br.readLine();
            String str[] = line.split(" ");
            int[] intArr = new int[str.length];
            int total = 0;
            for (int j = str.length - 1; j >= 0; j--) {
                intArr[j] = Integer.parseInt(str[j]);
                total += intArr[j];
            }
            long tempSum = 0;
            boolean isPresent = false;
            for (int j = intArr.length - 2; j >= 0; j--) {
                tempSum += intArr[j + 1];
                if (total - tempSum - intArr[j] == tempSum) {
                    isPresent = true;
                    break;
                }
            }
            if (isPresent) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
