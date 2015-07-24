package com.home.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Proposals {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int totalQualities = Integer.parseInt(line);
        line = br.readLine().trim();
        String str[] = line.split(" ");
        int[] qualitiesArr = new int[10000];
        for (int i = 0; i < totalQualities; i++) {
            qualitiesArr[Integer.parseInt(str[i])] = 1;
        }

        int N = Integer.parseInt(br.readLine().trim());
        int numOfGirls = 0;
        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            int qualities = 0;
            for (int j = 0; j < str.length; j++) {
                int temp = Integer.parseInt(str[j]);
                if (qualitiesArr[temp] == 1) {
                    qualities++;
                }
            }
            if (qualities == totalQualities)
                numOfGirls++;
        }
        System.out.println(numOfGirls);
    }
}
