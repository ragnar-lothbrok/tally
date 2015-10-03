package com.he.graphmania;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.hackerearth.com/code-monk-graph-theory-ii/algorithm/monk-and-the-islands/
public class Solution3_alternate {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int testCases = Integer.parseInt(line);
        for (int i = 0; i < testCases; i++) {
            line = br.readLine();
            String str[] = line.split(" ");
            int vertexCount = Integer.parseInt(str[0]);
            int queryCount = Integer.parseInt(str[1]);
            long adMat[][] = new long[vertexCount][vertexCount];
            initializeMat(adMat,vertexCount);
            for (int j = 0; j < queryCount; j++) {
                str = br.readLine().split(" ");
                int xCo = Integer.parseInt(str[0]) - 1;
                int yCo = Integer.parseInt(str[1]) - 1;
                adMat[xCo][yCo] = 1;
                adMat[yCo][xCo] = 1;
            }
            floydWarshall(adMat, vertexCount);
            System.out.println(adMat[0][vertexCount-1]);
            
        }
    }

    private static void initializeMat(long[][] adMat, int vertexCount) {
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                if (i == j)
                    adMat[i][j] = 0;
                else
                    adMat[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    public static void display(long[][] adMat, int vertexCount) {
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                System.out.print(adMat[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void floydWarshall(long[][] adMat, int n) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (adMat[i][k] == Integer.MAX_VALUE || adMat[k][j] == Integer.MAX_VALUE)
                        continue;
                    if (adMat[i][k] + adMat[k][j] < adMat[i][j])
                        adMat[i][j] = adMat[i][k] + adMat[k][j];
                }
            }
        }
    }


}
