package com.he.disjoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Camper {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String str[] = line.split(" ");
        int numOfSoldiers = Integer.parseInt(str[0]);
        int arr[] = new int[numOfSoldiers + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        int opeations = Integer.parseInt(str[1]);
        for (int i = 0; i < opeations; i++) {
            line = br.readLine();
            str = line.split(" ");
            if (str[0].charAt(0) == '1') {
                arr[Integer.parseInt(str[1])] = Integer.parseInt(str[2]);
            } else if (str[0].charAt(0) == '2') {
                int px = find_set(arr, Integer.parseInt(str[1]));
                arr[px] = arr[Integer.parseInt(str[1])] = Integer.parseInt(str[1]);

            } else if (str[0].charAt(0) == '3') {
                int temp = Integer.parseInt(str[1]);
                while (arr[temp] != temp) {
                    temp = arr[temp];
                }
                System.out.println(temp);
            }
        }

    }

    private static int find_set(int parent[], int a) {
        if (parent[a] != a) {
            parent[a] = find_set(parent, parent[a]);
        }

        return parent[a];
    }
}
