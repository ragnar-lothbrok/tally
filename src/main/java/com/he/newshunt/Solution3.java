package com.he.newshunt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// /https://www.hackerearth.com/newshunt-test-1/problems/c9a191d3bba9607baba2ddda9697d9e9/
public class Solution3 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        line = br.readLine();
        String str[] = line.split(" ");
        int[] arr1 = new int[str.length];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = Integer.parseInt(str[i]);
        }

        int M = Integer.parseInt(br.readLine());
        line = br.readLine();
        str = line.split(" ");
        int[] arr2 = new int[str.length];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = Integer.parseInt(str[i]);
        }

        int arr3[] = new int[N + M];

        merge(arr1, N, arr2, M, arr3);

        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }
        System.out.println();
    }

    public static void merge(int A[], int m, int B[], int n, int C[]) {
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (A[i] < B[j]) {
                C[k++] = A[i++];
            } else {
                C[k++] = B[j++];
            }
        }

        while (i < m) {
            C[k++] = A[i++];
        }

        while (j < n) {
            C[k++] = B[j++];
        }
    }

}
