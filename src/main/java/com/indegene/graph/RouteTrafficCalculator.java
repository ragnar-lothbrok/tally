package com.indegene.graph;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class RouteTrafficCalculator {

    public static void main(String[] args) {

        applyTolls(6, 8, new String[] { "1#2#8", "1#4#7", "1#5#12", "2#3#4", "2#4#2", "3#6#6", "4#6#8", "5#6#10" });
    }

    private static Stack<Edge> stack = new Stack<Edge>();

    public static String[] applyTolls(int input1, int input2, String[] input3) {
        String result[] = new String[1];
        Map<Integer, List<Edge>> map = new HashMap<Integer, List<Edge>>();
        if (input1 == 0 || input2 == 0 || input3.length == 0) {
            result[0] = "{No Solution}";
        }
        for (int i = 1; i <= input1; i++) {
            map.put(i, new ArrayList<Edge>());
        }
        for (String edgeValue : input3) {
            String str[] = edgeValue.split("#");
            Edge edge = new Edge(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]), 0);
            map.get(edge.getStartVertex()).add(edge);
        }
        boolean visited[] = new boolean[input1 + 1];
        visited[1] = true;
        for (int i = 0; i < map.get(1).size(); i++) {
            findAllPath(visited, map.get(1).get(i), input1, map);
        }

        return input3;
    }

    private static void findAllPath(boolean visited[], Edge edge, int destinationIndex, Map<Integer, List<Edge>> map) {
        stack.add(edge);
        if (edge.getEndVertex() == destinationIndex) {
            System.out.println(stack);
        }

        if (!visited[edge.getEndVertex()]) {
            visited[edge.getEndVertex()] = true;
        }

        List<Edge> nList = map.get(edge.getEndVertex());
        for (int i = 0; i < nList.size(); i++) {
            if (!visited[nList.get(i).getEndVertex()]) {
                findAllPath(visited, nList.get(i), destinationIndex, map);
            }
        }

        visited[edge.getEndVertex()] = false;
        stack.remove(stack.size() - 1);
    }

    static class Edge {
        int startVertex;
        int endVertex;
        int edgeCost;
        int usedInPath;

        public int getStartVertex() {
            return startVertex;
        }

        public void setStartVertex(int startVertex) {
            this.startVertex = startVertex;
        }

        public int getEndVertex() {
            return endVertex;
        }

        public void setEndVertex(int endVertex) {
            this.endVertex = endVertex;
        }

        public int getEdgeCost() {
            return edgeCost;
        }

        public void setEdgeCost(int edgeCost) {
            this.edgeCost = edgeCost;
        }

        public int getUsedInPath() {
            return usedInPath;
        }

        public void setUsedInPath(int usedInPath) {
            this.usedInPath = usedInPath;
        }

        public Edge(int startVertex, int endVertex, int edgeCost, int usedInPath) {
            super();
            this.startVertex = startVertex;
            this.endVertex = endVertex;
            this.edgeCost = edgeCost;
            this.usedInPath = usedInPath;
        }

        public Edge() {
            super();
        }

        @Override
        public String toString() {
            return "Edge [startVertex=" + startVertex + ", endVertex=" + endVertex + ", edgeCost=" + edgeCost
                    + ", usedInPath=" + usedInPath + "]";
        }

    }
}
