package com.he.graphs;

public class GraphEdge implements Comparable<Object> {

    private Object startNode;
    private Object endNode;
    private Long weight;

    public Object getStartNode() {
        return startNode;
    }

    public void setStartNode(Object startNode) {
        this.startNode = startNode;
    }

    public Object getEndNode() {
        return endNode;
    }

    public void setEndNode(Object endNode) {
        this.endNode = endNode;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public GraphEdge(Object startNode, Object endNode, Long weight) {
        super();
        this.startNode = startNode;
        this.endNode = endNode;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge [startNode=" + startNode + ", endNode=" + endNode + ", weight=" + weight + "]";
    }

    public int compareTo(Object o) {
        return -(this.getWeight().compareTo(((GraphEdge) o).getWeight()));
    }
}
