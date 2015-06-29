package com.home.graphs;

import java.util.LinkedList;

/**
 * 
 * @author raghunandanG
 * 
 *         A topological sort must be carried out on a directed graph with no
 *         cycles. Such a graph is called a directed acyclic graph, often
 *         abbreviated DAG.
 *
 */
public class TopologicalSortGraph {

    public static <T> void traverse(Graph<T> graph) {
        if (graph != null) {
            LinkedList<Vertex<T>> sortedVertexList = new LinkedList<Vertex<T>>();
            while (graph.getNumOfVertex() > 0) {
                Vertex<T> vertex = graph.getNoSuccessorVertex();
                if (vertex == null) {
                    System.out.println("Graph has cycles.");
                    break;
                } else {
                    sortedVertexList.addFirst(vertex);
                    graph.deleteVertex(vertex);
                }
            }

            System.out.println(sortedVertexList);
        }
    }

}
