package com.he.graphs;

public class Node implements Comparable {

    private Object node;
    private Long weight;

    public Node(Object node, Long weight) {
        super();
        this.node = node;
        this.weight = weight;
    }

    public Object getNode() {
        return node;
    }

    public void setNode(Object node) {
        this.node = node;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "HeapNode [node=" + node + ", weight=" + weight + "]";
    }

    public int compareTo(Object o) {
        return this.weight.compareTo(((Node) o).weight);
    }

}