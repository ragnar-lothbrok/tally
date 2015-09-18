package com.he.july;

public class WaterStorageProblem {

    public static void main(String[] args) {

        int tow[] = { 5, 3, 7, 2, 6, 4, 5, 9, 1, 2 };
        int N = tow.length;
        int highLeft[] = new int[N], highRight[] = new int[N]; // highest-left
                                                               // and
        // highest-right
        for (int i = 0; i < N; i++)
            highLeft[i] = Math.max(tow[i], (i != 0) ? highLeft[i - 1] : 0);
        for (int i = N - 1; i >= 0; i--)
            highRight[i] = Math.max(tow[i], i < (N - 1) ? highRight[i + 1] : 0);
        int ans = 0;
        for (int i = 0; i < N; i++)
            ans += Math.min(highLeft[i], highRight[i]) - tow[i];
        System.out.println(ans);

    }
}
