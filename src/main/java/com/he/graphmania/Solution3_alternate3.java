package com.he.graphmania;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.hackerearth.com/code-monk-graph-theory-ii/algorithm/monk-and-the-islands/
public class Solution3_alternate3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int testCases = Integer.parseInt(line);
        for (int i = 0; i < testCases; i++) {
            line = br.readLine();
            String str[] = line.split(" ");
            int vertexCount = Integer.parseInt(str[0]);
            int queryCount = Integer.parseInt(str[1]);
            int adMat[][] = new int[vertexCount][vertexCount];
            initializeMat(adMat, vertexCount);
            for (int j = 0; j < queryCount; j++) {
                str = br.readLine().split(" ");
                int xCo = Integer.parseInt(str[0]) - 1;
                int yCo = Integer.parseInt(str[1]) - 1;
                adMat[xCo][yCo] = 1;
                adMat[yCo][xCo] = 1;
            }
            weightedShortestPath(adMat, 0, vertexCount);
        }
    }

    private static void initializeMat(int[][] adMat, int vertexCount) {
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

    public static void weightedShortestPath(int adajacency[][], int source, int vertexCount) {
        int path[] = new int[vertexCount];
        long distance[] = new long[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            path[i] = -1;
            distance[i] = Long.MAX_VALUE;
        }
        distance[source] = 0;
        boolean visited[] = new boolean[vertexCount];

        for (int i = 0; i < vertexCount - 1; i++) {

            int minIndex = 0;
            long minValue = Long.MAX_VALUE;
            for (int j = 0; j < vertexCount; j++) {
                if (visited[j] == false && minValue >= distance[j]) {
                    minValue = distance[j];
                    minIndex = j;
                }
            }

            visited[i] = true;

            for (int j = 0; j < vertexCount; j++) {
                if (distance[minIndex] != Long.MAX_VALUE && visited[j] == false
                        && adajacency[minIndex][j] != Long.MAX_VALUE
                        && distance[minIndex] + adajacency[minIndex][j] < distance[j]) {
                    distance[j] = distance[minIndex] + adajacency[minIndex][j];
                }
            }

        }
        System.out.println(distance[vertexCount - 1]);
    }
}
