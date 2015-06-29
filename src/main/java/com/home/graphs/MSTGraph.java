package com.home.graphs;

import java.util.Iterator;
import java.util.PriorityQueue;


/**
 * Find all the edges from the newest vertex to other vertices that aren’t in the
tree. Put these edges in the priority queue.
2. Pick the edge with the lowest weight, and add this edge and its destination
vertex to the tree.
 * @author pubmatic
 *
 * @param <T>
 */
public class MSTGraph<T> {

    private static int ntree = 0;
    private static PriorityQueue<Edge> priorityQueue;

    @SuppressWarnings("unchecked")
    public static <T> void traverse(Graph<T> graph) {
        if (graph != null) {
            if (graph.getVertexList() != null && graph.getVertexList().size() > 0) {
                priorityQueue = new PriorityQueue<Edge>();
                Vertex<T> currentVertex = graph.getVertexList().get(0);
                while (ntree < graph.getNumOfVertex() - 1) {
                    currentVertex.setVisited(true);
                    ntree++;
                    for (int j = 0; j < graph.getNumOfVertex(); j++) {
                        if (j == graph.getVertexList().indexOf(currentVertex))
                            continue;
                        if (graph.getVertexList().get(j).isVisited()) 
                            continue;
                        int distance = graph.getAdjacencyMatrix()[graph.getVertexList().indexOf(currentVertex)][j];
                        if (distance == 0) // skip if no edge
                            continue;
                        putInPQ(currentVertex, graph.getVertexList().get(j), distance);
                    }
                    if (priorityQueue.size() == 0) 
                    {
                        System.out.println("Graph Not Connected");
                        return;
                    }

                    Edge theEdge = priorityQueue.poll();
                    currentVertex = theEdge.getDestVert();
                    System.out.println(theEdge.getSrcVert().getT() + " " + theEdge.getDestVert().getT());
                    System.out.println(" ");
                }
            }
        }
    }

    public static <T> void putInPQ(Vertex<T> currentVert, Vertex<T> newVert, Integer newDist) {
        Edge edge = findVertex(newVert);
        if (edge != null) {
            int oldDist = edge.getDistance();
            if (oldDist > newDist) {
                priorityQueue.remove(edge);
                Edge theEdge = new Edge(currentVert, newVert, newDist);
                priorityQueue.add(theEdge);
            }
        } else {
            Edge theEdge = new Edge(currentVert, newVert, newDist);
            priorityQueue.add(theEdge);
        }
    }

    public static <T> Edge findVertex(Vertex<T> newVert) {
        Iterator<Edge> iterator = priorityQueue.iterator();
        while (iterator.hasNext()) {
            Edge edge = iterator.next();
            if (edge.getDestVert().equals(newVert)) {
                return edge;
            }
        }
        return null;
    }

}
