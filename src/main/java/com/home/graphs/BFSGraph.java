package com.home.graphs;

import java.util.PriorityQueue;
import java.util.Queue;

public class BFSGraph {

    public static <T> void traverse(Graph<T> graph) {

        if (graph != null) {
            if (graph.getVertexList() != null && graph.getVertexList().size() > 0) {
                Vertex<T> vertex = graph.getVertexList().get(0);
                vertex.setVisited(true);
                Queue<Vertex<T>> queue = new PriorityQueue<Vertex<T>>();
                queue.add(vertex);
                while (!queue.isEmpty()) {
                    Vertex<T> tempVertex = graph.getUnvisitedAdjacentVertex(queue.peek());
                    if(tempVertex ==null){
                        queue.remove();
                    }else{
                        tempVertex.setVisited(true);
                        queue.add(tempVertex);
                    }
                }
                System.out.println("After Visited : " + graph.getVertexList());
            }
        }

    }

}
