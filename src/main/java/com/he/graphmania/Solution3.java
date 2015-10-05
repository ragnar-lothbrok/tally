package com.he.graphmania;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// https://www.hackerearth.com/code-monk-graph-theory-ii/algorithm/monk-and-the-islands/
public class Solution3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int testCases = Integer.parseInt(line);
        for (int i = 0; i < testCases; i++) {
            line = br.readLine();
            String str[] = line.split(" ");
            int vertexCount = Integer.parseInt(str[0]);
            int queryCount = Integer.parseInt(str[1]);
            long adMat[][] = new long[vertexCount][vertexCount];
            for (int j = 0; j < queryCount; j++) {
                str = br.readLine().split(" ");
                int xCo = Integer.parseInt(str[0]) - 1;
                // System.out.println("@@"+str[1]+"@@");
                int yCo = Integer.parseInt(str[1]) - 1;
                adMat[xCo][yCo] = 1;
                adMat[yCo][xCo] = 1;
            }
            getShortestPath(adMat, vertexCount);
        }
    }

    private static void getShortestPath(long[][] adMat, int vertexCount) {
        long minWeight = Long.MAX_VALUE;
        long minHopes = Long.MIN_VALUE;
        Queue<Vertex> queue = new LinkedList<Vertex>();
        queue.add(new Vertex(0, 0, 0));
        boolean visited[] = new boolean[vertexCount];
        visited[0] = true;
        while (!queue.isEmpty()) {
            Vertex vertex = queue.remove();
            if (vertex.getV() == vertexCount - 1) {
                if (minWeight >= vertex.getWeight()) {
                    minWeight = vertex.getWeight();
                    if (minHopes < vertex.getHopes()) {
                        minHopes = vertex.getHopes();
                    }
                }
            }
            if (vertex != null) {
                for (int i = 0; i < vertexCount; i++) {
                    if (vertex.getV() != i) {
                        if (!visited[i] && adMat[vertex.getV()][i] != 0) {
                            queue.add(new Vertex(i, vertex.getWeight() + adMat[vertex.getV()][i], vertex.getHopes() + 1));
                            visited[i] = true;
                        }
                    }
                }
            }
        }

        System.out.println(minHopes);
    }

    static class Vertex {
        private int v;
        private long weight;
        private int hopes;

        public int getHopes() {
            return hopes;
        }

        public void setHopes(int hopes) {
            this.hopes = hopes;
        }

        public int getV() {
            return v;
        }

        public void setV(int v) {
            this.v = v;
        }

        public long getWeight() {
            return weight;
        }

        public void setWeight(long weight) {
            this.weight = weight;
        }

        public Vertex(int v, long weight, int hopes) {
            super();
            this.v = v;
            this.weight = weight;
            this.hopes = hopes;
        }

    }

}
