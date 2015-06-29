package com.home.flavouredjune;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AvengersAndUltron {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
           int value = Integer.parseInt(br.readLine());
           System.out.println((value >=0 ?(value*(value-1))/2 : 0));
        }
    }

}
