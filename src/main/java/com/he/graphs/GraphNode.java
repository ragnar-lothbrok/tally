package com.he.graphs;

public class GraphNode implements Comparable {

    private Object node;
    private Long weight;

    public GraphNode(Object node, Long weight) {
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((node == null) ? 0 : node.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GraphNode other = (GraphNode) obj;
        if (node == null) {
            if (other.node != null)
                return false;
        } else if (!node.equals(other.node))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "HeapNode [node=" + node + ", weight=" + weight + "]";
    }

    public int compareTo(Object o) {
        return this.weight.compareTo(((GraphNode) o).weight);
    }

}