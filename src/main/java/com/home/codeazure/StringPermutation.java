package com.home.codeazure;

import java.util.LinkedHashSet;
import java.util.Set;

public class StringPermutation {

    public static void main(String[] args) {
        printPermutation(new int[] { 1, 2, 3, 4, 5 ,6}, 3);

    }

    public static void printPermutation(int arr[], int size) {
        Set<String> uniqueSet = new LinkedHashSet<String>();
        for (int i = 0; i <= arr.length - size; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (j <= i)
                    continue;
                for (int k = 0; k < arr.length; k++) {
                    if (k <= j || k <= i)
                        continue;
                    uniqueSet.add(arr[i] + "" + arr[j] + arr[k]);
                }
            }
        }
        System.out.println(uniqueSet);
    }
}
