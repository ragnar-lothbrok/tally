package com.indegene.graph;

import java.util.Stack;

public class RouteTrafficCalculator2 {

    public static void main(String[] args) {

        applyTolls(6, 8, new String[] { "1#2#8", "1#4#7", "1#5#12", "2#3#4", "2#4#2", "3#6#6", "4#6#8", "5#6#10" });

        System.out.println("\n\n");
        applyTolls(4, 6, new String[] { "1#2#7", "1#2#8", "1#3#10", "2#4#4", "2#4#3", "3#4#15" });
        
    }

    private static Stack<Vertex> stack = new Stack<Vertex>();

    public static String[] applyTolls(int input1, int input2, String[] input3) {
        String result[] = new String[1];
        int[][] adjMat = new int[input1 + 1][input1 + 1];
        if (input1 == 0 || input2 == 0 || input3.length == 0) {
            result[0] = "{No Solution}";
        }

        for (String edgeValue : input3) {
            String str[] = edgeValue.split("#");
            adjMat[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = Integer.parseInt(str[2]);
        }
        boolean visited[] = new boolean[input1 + 1];
        visited[1] = true;
        findAllPath(adjMat, visited, new Vertex(1, 0), input1);

        return input3;
    }

    private static void findAllPath(int[][] adjMat, boolean visited[], Vertex source, int destinationIndex) {
        stack.add(source);
        if (source.getVertex() == destinationIndex) {
            System.out.println(stack);
        }

        if (!visited[source.getVertex()]) {
            visited[source.getVertex()] = true;
        }

        for (int i = 1; i < adjMat.length; i++) {
            if (!visited[i] && adjMat[source.getVertex()][i] != 0) {
                findAllPath(adjMat, visited, new Vertex(i, source.getUsedInPath() + adjMat[source.getVertex()][i]),
                        destinationIndex);
            }
        }

        visited[source.getVertex()] = false;
        stack.remove(stack.size() - 1);
    }

    static class Vertex {
        int vertex;
        int usedInPath;

        public int getVertex() {
            return vertex;
        }

        public void setVertex(int vertex) {
            this.vertex = vertex;
        }

        public int getUsedInPath() {
            return usedInPath;
        }

        public void setUsedInPath(int usedInPath) {
            this.usedInPath = usedInPath;
        }

        @Override
        public String toString() {
            return "Vertex [vertex=" + vertex + ", usedInPath=" + usedInPath + "]";
        }

        public Vertex(int vertex, int usedInPath) {
            super();
            this.vertex = vertex;
            this.usedInPath = usedInPath;
        }

    }
}
