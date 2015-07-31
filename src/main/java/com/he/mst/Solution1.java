package com.he.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

// https://www.hackerearth.com/code-monk-minimum-spanning-tree/algorithm/check-it/
public class Solution1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int k = 0; k < N; k++) {
            line = br.readLine();
            String str[] = line.trim().split(" ");
            int numOfNodes = Integer.parseInt(str[0]);
            int numOfEdges = Integer.parseInt(str[1]);
            boolean[][] mat = new boolean[numOfNodes + 1][numOfNodes + 1];
            int[][] adjacencyMat = new int[numOfEdges][2];
            for (int j = 0; j < numOfEdges; j++) {
                str = br.readLine().trim().split(" ");
                adjacencyMat[j][0] = Integer.parseInt(str[0]);
                adjacencyMat[j][1] = Integer.parseInt(str[1]);
            }
            str = br.readLine().trim().split(" ");
            int sourceVertex = -1;
            for (int j = 0; j < str.length; j++) {
                int source = adjacencyMat[Integer.parseInt(str[j]) - 1][0];
                if (sourceVertex == -1)
                    sourceVertex = source;
                int destination = adjacencyMat[Integer.parseInt(str[j]) - 1][1];
                mat[source][destination] = true;
                mat[destination][source] = true;
            }
            boolean visited[] = new boolean[numOfNodes + 1];
            dfsTraversal(mat, visited, sourceVertex);
            int j = 1;
            for (j = 1; j < visited.length; j++) {
                if (visited[j]) {
                    continue;
                } else {
                    System.out.println("NO");
                    break;
                }
            }
            if (j == visited.length) {
                System.out.println("YES");
            }
        }
    }

    public static void dfsTraversal(boolean[][] adjacent, boolean[] visited, int source) {
        List<Integer> list = new LinkedList<Integer>();
        list.add(source);
        visited[source] = true;
        while (!list.isEmpty()) {
            int vertex = list.remove(0);
            for (int i = 1; i < adjacent.length; i++) {
                if (i != vertex && adjacent[vertex][i] && !visited[i]) {
                    visited[i] = true;
                    list.add(i);
                }
            }
        }
    }
}
