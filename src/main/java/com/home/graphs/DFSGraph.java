package com.home.graphs;

import java.util.Stack;

public class DFSGraph {

    public static <T> void traverse(Graph<T> graph) {
        if (graph != null) {
            if (graph.getVertexList() != null && graph.getVertexList().size() > 0) {
                Vertex<T> vertex = graph.getVertexList().get(0);
                vertex.setVisited(true);
                Stack<Vertex<T>> stack = new Stack<Vertex<T>>();
                stack.push(vertex);
                while (!stack.isEmpty()) {
                    Vertex<T> tempVertex = graph.getUnvisitedAdjacentVertex(stack.peek());
                    if (tempVertex == null) {
                        stack.pop();
                    } else {
                        tempVertex.setVisited(true);
                        System.out.println(vertex.getT());
                        stack.push(tempVertex);
                    }
                }

                System.out.println("After Visited : "+graph.getVertexList());
            }
        }
    }

}
