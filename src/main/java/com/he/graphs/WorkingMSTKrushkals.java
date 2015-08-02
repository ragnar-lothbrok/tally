package com.he.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

// https://www.hackerearth.com/code-monk-minimum-spanning-tree/algorithm/quantitative-coefficient/
public class WorkingMSTKrushkals {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        PriorityQueue<GraphEdge> pqEdge = new PriorityQueue<GraphEdge>();
        for (int i = 0; i < N; i++) {
            pqEdge.clear();
            String[] str = br.readLine().split(" ");
            int numOfNodes = Integer.parseInt(str[0]);
            int numOfEdges = Integer.parseInt(str[1]);
            for (int j = 0; j < numOfEdges; j++) {
                str = br.readLine().trim().split(" ");
                int source = Integer.parseInt(str[0]);
                int destination = Integer.parseInt(str[1]);
                long weight = Long.parseLong(str[2]);
                GraphEdge edge = new GraphEdge(source, destination, weight);
                pqEdge.add(edge);
            }
            int[] disjoint = new int[numOfNodes + 5];
            for (int j = 0; j < disjoint.length; j++) {
                disjoint[j] = j;
            }
            mstKrushkals(pqEdge, disjoint);
        }
    }

    public static void mstKrushkals(Queue<GraphEdge> pqEdge, int[] disjoint) {
        long wt=1;;
        while (!pqEdge.isEmpty()) {
            GraphEdge edge = pqEdge.remove();
            int source = (Integer) edge.getStartNode();
            int destination = (Integer) edge.getEndNode();
            if (root(source, disjoint) != root(destination, disjoint)) {
                union(source, destination, disjoint);
                wt=wt*edge.getWeight();
                wt=wt%1000000007;
            }
        }
        System.out.println(wt);
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

    static class GraphEdge implements Comparable<GraphEdge> {

        private Object startNode;
        private Object endNode;
        private Long weight;

        public Object getStartNode() {
            return startNode;
        }

        public void setStartNode(Object startNode) {
            this.startNode = startNode;
        }

        public Object getEndNode() {
            return endNode;
        }

        public void setEndNode(Object endNode) {
            this.endNode = endNode;
        }

        public Long getWeight() {
            return weight;
        }

        public void setWeight(Long weight) {
            this.weight = weight;
        }

        public GraphEdge(Object startNode, Object endNode, Long weight) {
            super();
            this.startNode = startNode;
            this.endNode = endNode;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge [startNode=" + startNode + ", endNode=" + endNode + ", weight=" + weight + "]";
        }

        public int compareTo(GraphEdge o) {
            return (this.getWeight().compareTo(((GraphEdge) o).getWeight()));
        }
    }

}
