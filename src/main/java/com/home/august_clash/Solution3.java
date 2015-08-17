package com.home.august_clash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

// https://www.hackerearth.com/august-clash-15/algorithm/rasta-in-tavaspolis/
public class Solution3 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String str[] = line.split(" ");
        Integer vertex = Integer.parseInt(str[0]);
        Integer queries = Integer.parseInt(str[1]);
        // long adjacentMat[][] = new long[vertex + 1][vertex + 1];
        Map<Integer, List<VertexWeight>> map = new HashMap<Integer, List<VertexWeight>>();
        for (int i = 1; i < vertex; i++) {
            str = br.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            int w = Integer.parseInt(str[2]);
            if (map.get(x) == null) {
                List<VertexWeight> vertexWeights = new ArrayList<VertexWeight>();
                vertexWeights.add(new VertexWeight(y, w));
                map.put(x, vertexWeights);
            } else {
                map.get(x).add(new VertexWeight(y, w));
            }
            if (map.get(y) == null) {
                List<VertexWeight> vertexWeights = new ArrayList<VertexWeight>();
                vertexWeights.add(new VertexWeight(x, w));
                map.put(y, vertexWeights);
            } else {
                map.get(y).add(new VertexWeight(x, w));
            }
            // adjacentMat[x][y] = w;
            // adjacentMat[y][x] = w;
        }

        for (int i = 0; i < queries; i++) {
            str = br.readLine().split(" ");
            int first = Integer.parseInt(str[0]);
            if (first == 1) {
                // adjacentMat[Integer.parseInt(str[1])][Integer.parseInt(str[2])]
                // = Integer.parseInt(str[3]);
                // adjacentMat[Integer.parseInt(str[2])][Integer.parseInt(str[1])]
                // = Integer.parseInt(str[3]);
                int x = Integer.parseInt(str[2]);
                int y = Integer.parseInt(str[1]);
                int w = Integer.parseInt(str[3]);
                VertexWeight temp = new VertexWeight(x, 0);
                map.get(y).get(map.get(y).indexOf(temp)).setWeight(w);
                temp.setVertex(y);
                map.get(x).get(map.get(x).indexOf(temp)).setWeight(w);

            } else {
                // DFS(adjacentMat, Integer.parseInt(str[1]));
                DFS(map, Integer.parseInt(str[1]));
            }
        }
    }

    public static void DFS(Map<Integer, List<VertexWeight>> adjacentMat, int source) {
        List<Integer> visitedList = new ArrayList<Integer>();
        Stack<VertexWeight> stack = new Stack<VertexWeight>();
        stack.push(new VertexWeight(source, 0));
        long max = 0;
        int count = 0;
        while (!stack.isEmpty()) {
            VertexWeight vertex = stack.pop();
            if (visitedList.indexOf(vertex.getVertex()) == -1) {
                visitedList.add(vertex.getVertex());
                if (stack.size() == 0 && vertex.getVertex() != source && count == 0) {
                    count = 1;
                    vertex.setWeight(max + vertex.getWeight());
                    if (adjacentMat.get(vertex.getVertex()) != null) {
                        List<VertexWeight> vertexWeights = adjacentMat.get(vertex.getVertex());
                        for (VertexWeight vw : vertexWeights) {
                            if (!visitedList.contains(vw.getVertex())) {
                                stack.push(new VertexWeight(vw.getVertex(), vertex.getWeight() + vw.getWeight()));
                            }
                        }
                    }
                } else {
                    if (max < vertex.getWeight()) {
                        max = vertex.getWeight();
                    }
                    if (adjacentMat.get(vertex.getVertex()) != null) {
                        List<VertexWeight> vertexWeights = adjacentMat.get(vertex.getVertex());
                        for (VertexWeight vw : vertexWeights) {
                            if (!visitedList.contains(vw.getVertex())) {
                                stack.push(new VertexWeight(vw.getVertex(), vertex.getWeight() + vw.getWeight()));
                            }
                        }
                    }
                }
            }
        }
        System.out.println(max);
    }

    // Using Adjacency Matrix
    public static void DFS(long[][] adjacentMat, int source) {
        boolean visited[] = new boolean[adjacentMat.length];
        Stack<VertexWeight> stack = new Stack<VertexWeight>();
        stack.push(new VertexWeight(source, 0));
        long max = 0;
        int count = 0;
        while (!stack.isEmpty()) {
            VertexWeight vertex = stack.pop();
            if (!visited[vertex.getVertex()]) {
                visited[vertex.getVertex()] = true;
                if (stack.size() == 0 && vertex.getVertex() != source && count == 0) {
                    count = 1;
                    vertex.setWeight(max + vertex.getWeight());
                    for (int i = 1; i < adjacentMat.length; i++) {
                        if (i != vertex.getVertex() && i != source && !visited[i]
                                && adjacentMat[vertex.getVertex()][i] != 0) {
                            stack.push(new VertexWeight(i, vertex.getWeight()
                                    + (long) adjacentMat[vertex.getVertex()][i]));
                        }
                    }
                } else {
                    if (max < vertex.getWeight()) {
                        max = vertex.getWeight();
                    }
                    for (int i = 1; i < adjacentMat.length; i++) {
                        if (i != vertex.getVertex() && !visited[i] && adjacentMat[vertex.getVertex()][i] != 0) {
                            stack.push(new VertexWeight(i, vertex.getWeight() + adjacentMat[vertex.getVertex()][i]));
                        }
                    }
                }
            }
        }
        System.out.println(max);
    }

    static class VertexWeight {
        private int vertex;
        private long weight;

        public VertexWeight(int vertex, long weight) {
            super();
            this.vertex = vertex;
            this.weight = weight;
        }

        public int getVertex() {
            return vertex;
        }

        public long getWeight() {
            return weight;
        }

        public void setWeight(long weight) {
            this.weight = weight;
        }

        public void setVertex(int vertex) {
            this.vertex = vertex;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + vertex;
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
            VertexWeight other = (VertexWeight) obj;
            if (vertex != other.vertex)
                return false;
            return true;
        }

        @Override
        public String toString() {
            return "VertexWeight [vertex=" + vertex + ", weight=" + weight + "]";
        }

    }
}
