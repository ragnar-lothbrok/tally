package com.he.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lexicography {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            br.readLine();
            String str[] = br.readLine().trim().split(" ");
            int[] arr = new int[str.length];
            for (int j = 0; j < str.length; j++) {
                arr[j] = Integer.parseInt(str[j]);
            }
            getLexicoGraphy(arr, arr.length);
            System.out.println();
        }

    }

    private static void getLexicoGraphy(int a[], int n) {
        int k = -1, temp, j, i;
        if (n > 1) {
            for (i = 0; i < n - 1; i++) {
                if (a[i] > a[i + 1])
                    k = i;
            }
        }
        int l = 0;
        if (k != -1) {
            for (i = k + 1; i < n; i++) {
                if (a[i] < a[k])
                    l = i;
            }
            temp = a[k];
            a[k] = a[l];
            a[l] = temp;
            j = n - 1;
            i = k + 1;
            while (i < j) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        for (i = 0; i < n; i++)
            System.out.print(a[i] + " ");
    }

}
