package com.he.graphmania;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.hackerearth.com/code-monk-graph-theory-ii/algorithm/monks-business-day/
public class Solution2 {

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
            initializeMat(adMat, vertexCount);
            for (int j = 0; j < queryCount; j++) {
                str = br.readLine().split(" ");
                int xCo = Integer.parseInt(str[0]) - 1;
                int yCo = Integer.parseInt(str[1]) - 1;
                long cost = adMat[xCo][yCo];
                if (cost == Long.MIN_VALUE) {
                    adMat[xCo][yCo] = Integer.parseInt(str[2]);
                } else {
                    adMat[xCo][yCo] = Math.max(cost, Integer.parseInt(str[2]));
                }
            }
            // display(adMat, vertexCount);
            floydWarshall(adMat, vertexCount);
            // display(adMat, vertexCount);
        }
    }

    private static void initializeMat(long[][] adMat, int vertexCount) {
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                if (i == j)
                    adMat[i][j] = 0;
                else
                    adMat[i][j] = Long.MIN_VALUE;
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

    private static void floydWarshall(long[][] dist, int n) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != Long.MIN_VALUE && dist[k][j] != Long.MIN_VALUE
                            && dist[i][k] + dist[k][j] > dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            if (dist[i][i]> 0) {
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
    }
}
