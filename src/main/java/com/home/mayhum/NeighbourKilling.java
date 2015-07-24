package com.home.mayhum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NeighbourKilling {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        line = br.readLine().trim();
        String str[] = line.split(" ");
        int arr[] = new int[str.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        int count = 0;
        for (int i = arr.length-1; i > 0; i--) {
            if (arr[i] > arr[i - 1]) {
                int temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
                count++;
            }
        }
        System.out.println(count);
    }

}
