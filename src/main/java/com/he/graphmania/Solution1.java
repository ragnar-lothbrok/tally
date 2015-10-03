package com.he.graphmania;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.hackerearth.com/code-monk-graph-theory-ii/algorithm/monk-in-the-secret-services/
public class Solution1 {

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
                if(adMat[Integer.parseInt(str[0]) - 1][Integer.parseInt(str[1]) - 1] > Integer.parseInt(str[2])){
                    adMat[Integer.parseInt(str[0]) - 1][Integer.parseInt(str[1]) - 1] = Integer.parseInt(str[2]);
                    adMat[Integer.parseInt(str[1]) - 1][Integer.parseInt(str[0]) - 1] = Integer.parseInt(str[2]);
                }
            }
            str = br.readLine().split(" ");
            calculateMinTime(adMat, Integer.parseInt(str[0]) - 1, Integer.parseInt(str[1]) - 1,
                    Integer.parseInt(str[2]) - 1);
        }
    }

    private static void calculateMinTime(long[][] adMat, int s, int a, int h) {
        floydWarshall(adMat, adMat.length);
        Long maxTime = Long.MIN_VALUE;
        for (int i = 0; i < adMat.length; i++) {
            if (!(i == s || i == a || i == h)) {
                maxTime = Math.max(maxTime, adMat[s][i] + adMat[i][a] + adMat[a][i] + adMat[i][h]);
            }
        }
        System.out.println(maxTime);
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

    private static void floydWarshall(long[][] dist, int n) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE)
                        continue;
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
    }

}
