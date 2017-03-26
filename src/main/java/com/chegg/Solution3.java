package com.chegg;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

// https://www.hackerearth.com/august-easy-15/algorithm/shil-and-survival-game/
public class Solution3 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str[] = br.readLine().split(" ");
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(str[i]);

        }

        Set<Integer> result = new TreeSet<Integer>();
        int x = a[0];
        result.add(1);
        for (int i = 1; i < n - 1; i++) {
            if (a[i] > x) {
                x = a[i];
                result.add(i + 1);
            }
        }
        x = a[n - 1];
        for (int i = n - 2; i > 0; i--) {
            if (a[i] > x) {
                x = a[i];
                result.add(i + 1);
            }
        }
        result.add(n);
        Iterator<Integer> iter = result.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
    }
}