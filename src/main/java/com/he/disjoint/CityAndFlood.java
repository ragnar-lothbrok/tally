package com.he.disjoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CityAndFlood {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = 1;
        }
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            String str[] = br.readLine().trim().replace("  "," ").split(" ");
            arr[Integer.parseInt(str[1])] = 0;
        }
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != 0) {
                count++;
            }
        }

        System.out.println(count);
    }

}
