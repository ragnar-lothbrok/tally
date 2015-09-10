package com.he.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EggProblem {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            String str[] = br.readLine().trim().split(" ");
            System.out.println(eggDrop(Integer.parseInt(str[1]), Integer.parseInt(str[0])));
        }
    }

    // Egg Dropping Dynamic Programming
    private static int eggDrop(int eggs, int floors) {
        int T[][] = new int[eggs + 1][floors + 1];
        int c = 0;
        for (int i = 0; i <= floors; i++) {
            T[1][i] = i;
        }

        for (int e = 2; e <= eggs; e++) {
            for (int f = 1; f <= floors; f++) {
                T[e][f] = Integer.MAX_VALUE;
                for (int k = 1; k <= f; k++) {
                    c = 1 + Math.max(T[e - 1][k - 1], T[e][f - k]);
                    if (c < T[e][f]) {
                        T[e][f] = c;
                    }
                }
            }
        }
        return T[eggs][floors];
    }

    // Egg Dropping Recursive Programming
    public int calculateRecursive(int eggs, int floors) {
        if (eggs == 1) {
            return floors;
        }
        if (floors == 0) {
            return 0;
        }
        int min = 1000;
        for (int i = 1; i <= floors; i++) {
            int val = 1 + Math.max(calculateRecursive(eggs - 1, i - 1), calculateRecursive(eggs, floors - i));
            if (val < min) {
                min = val;
            }
        }
        return min;
    }
}
