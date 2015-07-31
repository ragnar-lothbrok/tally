package com.he.mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution2 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Edge> pqEdge = new PriorityQueue<Edge>();
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            int numOfVertices = Integer.parseInt(str[0]);
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
            System.out.println(maximumST(pqEdge, disjoint,numOfVertices));
        }
    }

    public static int maximumST(Queue<Edge> pqEdge, int[] disjoint,int numOfVertices) {
        int maximum = 0;
        Long cost = 0l;
        for (int i = 0; i < pqEdge.size() ; i++) {
            Edge edge = pqEdge.remove();
            int source = (Integer) edge.getStartNode();
            int destination = (Integer) edge.getEndNode();
            cost = edge.getWeight();
            if (root(source, disjoint) != root(destination, disjoint)) {
                maximum += cost;
                union(source, destination, disjoint);
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

    static class Edge implements Comparable {

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

        public Edge(Object startNode, Object endNode, Long weight) {
            super();
            this.startNode = startNode;
            this.endNode = endNode;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge [startNode=" + startNode + ", endNode=" + endNode + ", weight=" + weight + "]";
        }

        public int compareTo(Object o) {
            return -(this.getWeight().compareTo(((Edge) o).getWeight()));
        }
    }
}
