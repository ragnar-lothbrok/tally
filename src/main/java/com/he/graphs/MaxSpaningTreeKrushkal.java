package com.he.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
///https://www.hackerearth.com/code-monk-minimum-spanning-tree/algorithm/maximum-spanning-tree/description/
public class MaxSpaningTreeKrushkal {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Edge> pqEdge = new PriorityQueue<Edge>();
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            int numOfEdges = Integer.parseInt(str[1]);
            for (int j = 0; j < numOfEdges; j++) {
                str = br.readLine().trim().split(" ");
                int source = Integer.parseInt(str[0]);
                int destination = Integer.parseInt(str[1]);
                long weight = Long.parseLong(str[2]);
                Edge edge = new Edge(source, destination, weight);
                pqEdge.add(edge);
            }
            int[] disjoint = new int[5000 + 1];
            for (int j = 0; j < disjoint.length; j++) {
                disjoint[j] = j;
            }
            System.out.println(maximumST(pqEdge, disjoint));
        }
    }

    public static int maximumST(Queue<Edge> pqEdge, int[] disjoint) {
        int maximum = 0;
        List<Edge> finalEdgeList = new ArrayList<Edge>();
        while (!pqEdge.isEmpty()) {
            Edge edge = pqEdge.remove();
            int source = (Integer) edge.getStartNode();
            int destination = (Integer) edge.getEndNode();
            if (root(source, disjoint) != root(destination, disjoint)) {
                maximum += edge.getWeight();
                union(source, destination, disjoint);
                finalEdgeList.add(edge);
            }
        }
        return maximum;
    }

    private static int root(int x, int disjoint[]) {
        while (disjoint[x] != x) {
            disjoint[x] = disjoint[disjoint[x]];
            x = disjoint[x];
        }
        return x;
    }

    private static void union(int source, int destination, int disjoint[]) {
        int p = root(source, disjoint);
        int q = root(destination, disjoint);
        disjoint[p] = disjoint[q];
    }
}

