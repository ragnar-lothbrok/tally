package com.home.target;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution3 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Integer N = Integer.parseInt(line);
        int arr[] = new int[N];
        line = br.readLine();
        String stringArr[] = line.split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stringArr[i]);
        }
        Arrays.sort(arr);
        int queries = Integer.parseInt(br.readLine());
        for (int i = 0; i < queries; i++) {
            String str[] = br.readLine().split(" ");
            int X = Integer.parseInt(str[0]);
            int Y = Integer.parseInt(str[1]);
            if (X <= arr.length && Y <= arr.length) {
                if (arr[X-1] == arr[Y-1]) {
                    System.out.println(0);
                } else {
                    System.out.println(Y - X);
                }
            }
        }
    }
}
