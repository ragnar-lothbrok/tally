package com.he.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.PriorityQueue;

// https://www.hackerearth.com/code-monk-minimum-spanning-tree/algorithm/quantitative-coefficient/
public class MSTPrims {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        int adajacency[][] = new int[500 + 1][500 + 1];
        int path[] = new int[501];
        long distance[] = new long[501];
        for (int i = 0; i < N; i++) {
            int startVertex = -1;
            for (int k = 0; k < adajacency.length; k++) {
                path[k] = -1;
                distance[k] = Integer.MAX_VALUE;
                Arrays.fill(adajacency[k], 0);
            }
            String[] str = br.readLine().split(" ");
            int numOfEdges = Integer.parseInt(str[1]);
            for (int j = 0; j < numOfEdges; j++) {
                line = br.readLine();
                str = line.split(" ");
                if (startVertex == -1)
                    startVertex = Integer.parseInt(str[0]);
                adajacency[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = Integer.parseInt(str[2]);
            }
            weightedShortestPath(adajacency, path, distance, startVertex);
        }
    }

    private static void weightedShortestPath(int[][] adajacency, int[] path, long[] distance, int source) {
        PriorityQueue<GraphNode> pq = new PriorityQueue<GraphNode>();
        pq.add(new GraphNode(source, 0l));
        BigDecimal bigDecimal = new BigDecimal(1);
        while (!pq.isEmpty()) {
            GraphNode graphNode = pq.remove();
            if (graphNode.getWeight() != 0) {
                bigDecimal = bigDecimal.multiply(new BigDecimal(graphNode.getWeight()));
            }
            int vertex = (Integer) graphNode.getNode();
            if (path[(Integer) graphNode.getNode()] == -1) {
                for (int i = 0; i < adajacency.length; i++) {
                    if (adajacency[vertex][i] != 0) {
                        if (distance[i] > adajacency[vertex][i]) {
                            distance[i] = adajacency[vertex][i];
                            graphNode = new GraphNode(i, distance[i]);
                            pq.remove(graphNode);
                            pq.add(graphNode);
                        }
                    }
                }
                path[vertex] = 1;
            }
        }

        System.out.println(((long) (bigDecimal.doubleValue() % 1000000007)));
    }

    static class GraphNode implements Comparable<Object> {

        private Object node;
        private Long weight;

        public GraphNode(Object node, Long weight) {
            super();
            this.node = node;
            this.weight = weight;
        }

        public Object getNode() {
            return node;
        }

        public void setNode(Object node) {
            this.node = node;
        }

        public Long getWeight() {
            return weight;
        }

        public void setWeight(Long weight) {
            this.weight = weight;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((node == null) ? 0 : node.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            GraphNode other = (GraphNode) obj;
            if (node == null) {
                if (other.node != null)
                    return false;
            } else if (!node.equals(other.node))
                return false;
            return true;
        }

        @Override
        public String toString() {
            return "HeapNode [node=" + node + ", weight=" + weight + "]";
        }

        public int compareTo(Object o) {
            return this.weight.compareTo(((GraphNode) o).weight);
        }

    }
}
