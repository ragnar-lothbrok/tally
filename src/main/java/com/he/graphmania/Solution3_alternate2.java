package com.he.graphmania;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.PriorityQueue;

// https://www.hackerearth.com/code-monk-graph-theory-ii/algorithm/monk-and-the-islands/
public class Solution3_alternate2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int testCases = Integer.parseInt(line);
        for (int i = 0; i < testCases; i++) {
            line = br.readLine();
            String str[] = line.split(" ");
            int vertexCount = Integer.parseInt(str[0]);
            int queryCount = Integer.parseInt(str[1]);
            int adMat[][] = new int[vertexCount][vertexCount];
            initializeMat(adMat, vertexCount);
            for (int j = 0; j < queryCount; j++) {
                str = br.readLine().split(" ");
                int xCo = Integer.parseInt(str[0]) - 1;
                int yCo = Integer.parseInt(str[1]) - 1;
                adMat[xCo][yCo] = 1;
                adMat[yCo][xCo] = 1;
            }
            weightedShortestPath(adMat, 0, vertexCount);
        }
    }

    private static void initializeMat(int[][] adMat, int vertexCount) {
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                if (i == j)
                    adMat[i][j] = 0;
                else
                    adMat[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    public static void display(long[][] adMat, int vertexCount) {
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                System.out.print(adMat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void weightedShortestPath(int adajacency[][], int source, int vertexCount) {
        int path[] = new int[vertexCount];
        long distance[] = new long[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            path[i] = -1;
            distance[i] = Long.MAX_VALUE;
        }
        distance[source] = 0;
        PriorityQueue<GraphNode> pq = new PriorityQueue<GraphNode>();
        pq.add(new GraphNode(0, 0l));
        while (!pq.isEmpty()) {
            GraphNode gn = pq.remove();
            if (gn != null) {
                for (int i = 0; i < vertexCount; i++) {
                    if (gn.getNode() != i && adajacency[gn.getNode()][i] != Integer.MAX_VALUE) {
                        long dist = distance[gn.getNode()] + adajacency[gn.getNode()][i];
                        if (distance[i] == Integer.MAX_VALUE) {
                            distance[i] = dist;
                            path[i] = gn.getNode();
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
                            path[i] = gn.getNode();
                        }
                    }
                }
            }
        }
        System.out.println(distance[vertexCount - 1]);
    }

    static class GraphNode implements Comparable<GraphNode> {

        private Integer node;
        private Long weight;

        public GraphNode(Integer node, Long weight) {
            super();
            this.node = node;
            this.weight = weight;
        }

        public Integer getNode() {
            return node;
        }

        public void setNode(Integer node) {
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

        public int compareTo(GraphNode o) {
            return this.weight.compareTo(((GraphNode) o).weight);
        }

    }
}
