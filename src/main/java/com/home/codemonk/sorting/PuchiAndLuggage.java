package com.home.codemonk.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PuchiAndLuggage {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            Integer length = Integer.parseInt(br.readLine());
            int[] intArr = new int[length];
            for (int j = 0; j < length; j++) {
                intArr[j] = Integer.parseInt(br.readLine());
            }
            getOutput(intArr);
        }
    }

    public static void getOutput(int[] intArr) {
        int count = 0;
        for (int i = 0; i < intArr.length; i++) {
            count = 0;
            for (int j = i + 1; j < intArr.length; j++) {
                if (intArr[j] < intArr[i]) {
                    count++;
                }
            }
            System.out.print(count+" ");
            if(i < intArr.length-1 && intArr[i] == intArr[i+1]){
                System.out.print(count+" ");
                i++;
            }
        }
        System.out.println();
    }
}
