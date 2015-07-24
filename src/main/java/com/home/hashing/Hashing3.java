package com.home.hashing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Hashing3 {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            int collisons = 0;
            int size = Integer.parseInt(br.readLine());
            short[] byteArr = new short[1000001];
            for (int j = 0; j < size; j++) {
                line = br.readLine().trim();
                String str[] = line.split(" ");
                Integer itemType = Integer.parseInt(str[0]);
                Integer pokeType = Integer.parseInt(str[1]);
                if (itemType != pokeType) {
                    byteArr[itemType]++;
                    if (byteArr[pokeType] == 0) {
                        collisons++;
                    } else {
                        byteArr[pokeType]--;
                    }
                }
            }
            System.out.println(collisons);
            Arrays.fill(byteArr, (short) 0);
        }
    }

}
