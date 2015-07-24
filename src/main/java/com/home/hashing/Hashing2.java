package com.home.hashing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Hashing2 {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            br.readLine();
            int arr[] = new int[10];
            line = br.readLine().trim();
            String str[] = line.split(" ");
            int collisons = 0;
            for (int j = 0; j < str.length; j++) {
                int temp = Integer.parseInt(str[j]);
                if (arr[temp % 10] != 0) {
                    collisons++;
                } else {
                    arr[temp % 10] = 1;
                }
            }
            System.out.println(collisons);
        }
    }

}
