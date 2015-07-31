package com.he.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// /https://www.hackerearth.com/battle-of-algorithmists/algorithm/dinesh-and-his-travelling-cost/
public class ShortestPathWeightedGraph {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        int adajacency[][] = new int[500 + 1][500 + 1];
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            String str[] = line.split(" ");
            adajacency[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = Integer.parseInt(str[2]);
            adajacency[Integer.parseInt(str[1])][Integer.parseInt(str[0])] = Integer.parseInt(str[2]);
        }
        int path[] = new int[501];
        long distance[] = new long[501];
        Integer source = Integer.parseInt(br.readLine());
        for (int i = 0; i < adajacency.length; i++) {
            path[i] = -1;
        }
        weightedShortestPath(adajacency, path, distance, source);
        N = Integer.parseInt(br.readLine());
        System.out.println();
        for (int i = 0; i < N; i++) {
            int destination = Integer.parseInt(br.readLine());
            long weight = distance[destination];
            StringBuilder sb = new StringBuilder();
            sb.append(" " + destination);
            while (path[destination] != -1) {
                destination = path[destination];
                sb.append(" " + destination);
            }
            if (destination == source) {
                System.out.println(sb.reverse() +" Weight : "+weight);
            } else {
                System.out.println("No Path");
            }

        }
    }

    public static void weightedShortestPath(int adajacency[][], int path[], long distance[], int source) {
        BinaryMinHeap binaryMinHeap = new BinaryMinHeap();
        binaryMinHeap.add(source, 0l);
        for (int i = 0; i < adajacency.length; i++) {
            distance[i] = -1;
        }
        distance[source] = 0;

        while (!binaryMinHeap.getHeap().isEmpty()) {
            HeapNode heapNode = binaryMinHeap.removeMin();
            Integer vertex = (Integer) heapNode.getNode();
            if (heapNode.getNode() != null) {
                for (int i = 0; i < adajacency.length; i++) {
                    if (i != vertex && adajacency[vertex][i] != 0) {
                        long dist = distance[vertex] + adajacency[vertex][i];
                        if (distance[i] == -1) {
                            distance[i] = dist;
                            path[i] = vertex;
                            binaryMinHeap.add(i, dist);
                        }
                        if (distance[i] > dist) {
                            distance[i] = dist;
                            binaryMinHeap.removeFromMinHeap(i);
                            binaryMinHeap.add(i, dist);
                            path[i] = vertex;
                        }
                    }
                }
            }
        }
    }
}
