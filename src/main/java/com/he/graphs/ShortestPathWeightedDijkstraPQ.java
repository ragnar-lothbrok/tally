package com.he.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.PriorityQueue;

// /https://www.hackerearth.com/battle-of-algorithmists/algorithm/dinesh-and-his-travelling-cost/
public class ShortestPathWeightedDijkstraPQ {

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
            if (distance[destination] == Integer.MAX_VALUE) {
                System.out.println("NO PATH");
            } else {
                System.out.println(distance[destination]);
            }

        }
    }

    public static void weightedShortestPath(int adajacency[][], int path[], long distance[], int source) {
        PriorityQueue<GraphNode> pq = new PriorityQueue<GraphNode>();
        pq.add(new GraphNode(source, 0l));
        for (int i = 0; i < adajacency.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[source] = 0;

        while (!pq.isEmpty()) {
            GraphNode heapNode = pq.remove();
            Integer vertex = (Integer) heapNode.getNode();
            if (heapNode.getNode() != null) {
                for (int i = 0; i < adajacency.length; i++) {
                    if (i != vertex && adajacency[vertex][i] != 0) {
                        long dist = distance[vertex] + adajacency[vertex][i];
                        if (distance[i] == Integer.MAX_VALUE) {
                            distance[i] = dist;
                            path[i] = vertex;
                            pq.add(new GraphNode(i, dist));
                        }
                        if (distance[i] > dist) {
                            distance[i] = dist;
                            Iterator<GraphNode> iterator = pq.iterator();
                            while (iterator.hasNext()) {
                                GraphNode node = iterator.next();
                                if (node.getNode().equals(i)) {
                                    iterator.remove();
                                    break;
                                }
                            }
                            pq.add(new GraphNode(i, dist));
                            path[i] = vertex;
                        }
                    }
                }
            }
        }
    }
}