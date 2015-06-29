package com.home.codemonk.searching;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GraphTest {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String str[] = line.trim().split(" ");
        int count = 0;
        try {
            int vertexCount = Integer.parseInt(str[0].trim());
            int edgeCount = Integer.parseInt(str[1].trim());
            int[][] inputArr = new int[vertexCount][vertexCount];
            for (int i = 0; i < edgeCount; i++) {
                line = br.readLine().trim();
                str = line.trim().split(" ");
                int row = Integer.parseInt(str[0].trim());
                int col = Integer.parseInt(str[1].trim());
                if (row <= vertexCount && col <= vertexCount && row > 0 && col > 0)
                    inputArr[row - 1][col - 1] = 1;
            }
            for (int row = 0; row < inputArr.length; row++) {
                for (int col = 0; col < inputArr.length; col++) {
                    if (inputArr[row][col] == 0 && inputArr[col][row] == 0 && row != col) {
                        inputArr[row][col] = 1;
                        inputArr[col][row] = 1;
                        count++;
                    }
                }
            }
        } catch (Exception exception) {

        }
        System.out.println(count);
    }
}
