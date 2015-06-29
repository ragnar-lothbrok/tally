package com.home.graphs;

import java.util.ArrayList;
import java.util.List;

public class ShortestPathDirectedGraph {

    private static List<DistPar> sPathList;

    private static int nTree;

    private static int currentVert;

    private static int startToCurrent;

    public static <T> void path(Graph<T> graph) {
        if (graph != null) {
            if (graph.getVertexList() != null && graph.getVertexList().size() > 0) {
                sPathList = new ArrayList<DistPar>(graph.getNumOfVertex());
                int startTree = 0;
                nTree = 1;
                graph.getVertexList().get(0).setVisited(true);
                for (int j = 0; j < graph.getNumOfVertex(); j++) {
                    sPathList.add(new DistPar(graph.getVertexList().get(0), graph.getAdjacencyMatrix()[startTree][j]));
                }
                while (nTree < graph.getNumOfVertex()) {

                }
            }
        }
    }

    private static <T> int getMin(Graph<T> graph) {
        int minDistance = Integer.MAX_VALUE;
        int indexMin = 0;
        for (int j = 1; j < graph.getNumOfVertex(); j++) {
            if (!graph.getVertexList().get(j).isVisited() && sPathList.get(j).getDistance() < minDistance) {
                minDistance = sPathList.get(j).getDistance();
                indexMin = j;
            }
        }
        return indexMin;
    }
}
