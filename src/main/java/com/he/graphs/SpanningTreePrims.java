package com.he.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// /https://www.hackerearth.com/battle-of-algorithmists/algorithm/dinesh-and-his-travelling-cost/
public class SpanningTreePrims {

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
        for (int i = 0; i < adajacency.length; i++) {
            path[i] = -1;
            distance[i] = Integer.MAX_VALUE;
        }
        weightedShortestPath(adajacency, path, distance, 0);
        System.out.println();

    }

    public static void weightedShortestPath(int adajacency[][], int path[], long distance[], int source) {
        PriorityQueue<GraphNode> pq = new PriorityQueue<GraphNode>();
        pq.add(new GraphNode(source, 0l));
        while (!pq.isEmpty()) {
            GraphNode node = pq.remove();
            System.out.println(node);
            Integer vertex = (Integer) node.getNode();
            for (int i = 0; i < adajacency.length; i++) {
                if (path[i] == -1 && adajacency[vertex][i] != 0) {
                    if (distance[i] > adajacency[vertex][i]) {
                        distance[i] = adajacency[vertex][i];
                        GraphNode graphNode = new GraphNode(i, distance[i]);
                        pq.remove(graphNode);
                        pq.add(graphNode);
                    }
                }
                path[vertex] = 1;
            }
        }
    }
}