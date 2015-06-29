package com.home.graphs;

import java.util.ArrayList;
import java.util.List;

public class Graph<T> {

    private List<Vertex<T>> vertexList;
    private int[][] adjacencyMatrix;
    private Integer numOfVertex;
    private boolean directedGraph;

    public List<Vertex<T>> getVertexList() {
        return vertexList;
    }

    public void setVertexList(List<Vertex<T>> vertexList) {
        this.vertexList = vertexList;
    }

    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public void setAdjacencyMatrix(int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
    }

    public Integer getNumOfVertex() {
        return numOfVertex;
    }

    public void setNumOfVertex(Integer numOfVertex) {
        this.numOfVertex = numOfVertex;
        this.adjacencyMatrix = new int[numOfVertex][numOfVertex];
        this.vertexList = new ArrayList<Vertex<T>>(numOfVertex);
    }

    public void addVertex(T t) {
        Vertex<T> vertex = new Vertex<T>(t);
        if (this.vertexList != null && this.vertexList.size() <= numOfVertex - 1) {
            this.vertexList.add(vertex);
        }
    }

    public void addEdge(T startV, T endV, int weight) {
        if (this.vertexList != null) {
            int start = this.vertexList.indexOf(new Vertex<T>(startV));
            int end = this.vertexList.indexOf(new Vertex<T>(endV));
            if (start != -1 && end != -1) {
                adjacencyMatrix[start][end] = weight;
                if (!this.isDirectedGraph())
                    adjacencyMatrix[end][start] = weight;
            }
        }
    }

    public Vertex<T> getUnvisitedAdjacentVertex(Vertex<T> vertex) {
        if (this.vertexList != null) {
            int index = this.vertexList.indexOf(vertex);
            for (int i = 0; i < numOfVertex; i++) {
                if (this.adjacencyMatrix[index][i] > 0) {
                    Vertex<T> tempVertex = this.vertexList.get(i);
                    if (tempVertex.isVisited()) {
                        continue;
                    } else {
                        return tempVertex;
                    }
                }
            }
        }
        return null;
    }

    public Vertex<T> getNoSuccessorVertex() {
        for (int i = 0; i < numOfVertex; i++) {
            boolean edgePresent = false;
            for (int j = 0; j < numOfVertex; j++) {
                if (adjacencyMatrix[i][j] > 0) {
                    edgePresent = true;
                    break;
                }
            }
            if (!edgePresent) {
                return this.vertexList.get(i);
            }
        }
        return null;
    }

    public boolean deleteVertex(Vertex<T> vertex) {
        boolean isRemoved = false;
        if (this.vertexList != null) {
            int index = this.vertexList.indexOf(vertex);
            isRemoved = this.vertexList.remove(vertex);
            if (isRemoved) {
                // Moving Row up
                for (int i = index; i < numOfVertex - 1; i++) {
                    for (int j = 0; j < numOfVertex; j++) {
                        adjacencyMatrix[i][j] = adjacencyMatrix[i + 1][j];
                    }
                }

                // Moving Column Left
                for (int i = index; i < numOfVertex - 1; i++) {
                    for (int j = 0; j < numOfVertex; j++) {
                        adjacencyMatrix[j][i] = adjacencyMatrix[j][i + 1];
                    }
                }

                --this.numOfVertex;
            } else {
                isRemoved = false;
            }
        }
        return isRemoved;
    }

    public boolean isDirectedGraph() {
        return directedGraph;
    }

    public void setDirectedGraph(boolean directedGraph) {
        this.directedGraph = directedGraph;
    }

}
