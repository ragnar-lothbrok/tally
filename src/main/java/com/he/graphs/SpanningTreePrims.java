package com.he.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
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
        }
        for(int i=0;i<vertexList.size();i++){
            weightedShortestPath(adajacency, path, distance, vertexList.get(i));
        }
        System.out.println();

    }

    public static void weightedShortestPath(int adajacency[][], int path[], long distance[], int source) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.add(new Node(source, 0l));
        for (int i = 0; i < adajacency.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[source] = 0;

        while (!pq.isEmpty()) {
            Node heapNode = pq.remove();
            Integer vertex = (Integer) heapNode.getNode();
            if (heapNode.getNode() != null) {
                for (int i = 0; i < adajacency.length; i++) {
                    if (i != vertex && adajacency[vertex][i] != 0) {
                        long dist = distance[vertex] + adajacency[vertex][i];
                        if (distance[i] == Integer.MAX_VALUE) {
                            distance[i] = adajacency[vertex][i];
                            path[i] = vertex;
                            pq.add(new Node(i, dist));
                        }
                        if (distance[i] > dist) {
                            distance[i] = adajacency[vertex][i];
                            Iterator<Node> iterator = pq.iterator();
                            while (iterator.hasNext()) {
                                Node node = iterator.next();
                                if (node.getNode().equals(i)) {
                                    iterator.remove();
                                    break;
                                }
                            }
                            pq.add(new Node(i, dist));
                            path[i] = vertex;
                        }
                    }
                }
            }
        }
    }
}