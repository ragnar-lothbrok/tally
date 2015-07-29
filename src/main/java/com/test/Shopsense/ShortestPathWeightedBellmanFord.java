package com.test.Shopsense;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// /https://www.hackerearth.com/battle-of-algorithmists/algorithm/dinesh-and-his-travelling-cost/
public class ShortestPathWeightedBellmanFord {

    public static final Boolean IS_BELLMAN_FORD = true; // If it is false means
                                                        // it's Dijkstra

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        int adajacency[][] = new int[500 + 1][500 + 1];
        List<Integer> vertexList = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            String str[] = line.split(" ");
            adajacency[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = Integer.parseInt(str[2]);
            if (!IS_BELLMAN_FORD)
                adajacency[Integer.parseInt(str[1])][Integer.parseInt(str[0])] = Integer.parseInt(str[2]);
            if (!vertexList.contains(Integer.parseInt(str[1]))) {
                vertexList.add(Integer.parseInt(str[1]));
            }
            if (!vertexList.contains(Integer.parseInt(str[0]))) {
                vertexList.add(Integer.parseInt(str[0]));
            }
        }
        int path[] = new int[501];
        long distance[] = new long[501];
        Integer source = Integer.parseInt(br.readLine());
        for (int i = 0; i < adajacency.length; i++) {
            path[i] = -1;
        }
        int result = weightedShortestPath(adajacency, path, distance, source, vertexList);
        if (result == -1) {
            System.out.println("Negative Cycles");
            System.exit(0);
        }
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int destination = Integer.parseInt(br.readLine());
            if (distance[destination] == Integer.MAX_VALUE) {
                System.out.println("NO PATH");
            } else {
                System.out.println(distance[destination]);
            }
        }
    }

    public static int weightedShortestPath(int adajacency[][], int path[], long distance[], int source,
            List<Integer> vertexList) {
        int k = 0, current;
        boolean visited[] = new boolean[adajacency.length];
        for (int i = 0; i < adajacency.length; i++) {
            distance[i] = Integer.MAX_VALUE;
            path[i] = -1;
            visited[i] = false;
        }
        distance[source] = 0;
        path[source] = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(source);
        while (!queue.isEmpty()) {
            current = queue.remove();
            visited[current] = false;
            if (source == current)
                k++;
            if (k > vertexList.size()) {
                return -1;
            }

            for (int u = 0; u < adajacency.length; u++) {
                if (adajacency[current][u] != 0) {
                    if (distance[u] < 0 && distance[current] + adajacency[current][u] < 0
                            && distance[u] > distance[current] + adajacency[current][u]) {
                        return -1;
                    } else if (distance[u] > distance[current] + adajacency[current][u]) {
                        distance[u] = distance[current] + adajacency[current][u];
                        path[u] = current;
                        if (!visited[u]) {
                            queue.add(u);
                            visited[u] = true;
                        }
                    }
                }
            }
        }
        return 1;
    }
}

/*
 * 
 * Bellman Ford algorithm code will be same as Dijkstra if we have all positive
 * weight edges but if we have negative edges than Dijkstra algorithm won't work
 * as we have to detect negative edge cycles otherwise code will go in infinite
 * loop.
 * 
 * Bellman algorithm works for : 1. Undirected Graph + Positive Weights 2.
 * Directed Graph + Negative/Positive Weights
 */