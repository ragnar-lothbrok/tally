package com.home.flipkart;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {

    private int data;
    private List<GraphNode> neighbourList;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public List<GraphNode> getNeighbourList() {
        if (neighbourList == null)
            neighbourList = new ArrayList<GraphNode>();
        return neighbourList;
    }

    public void setNeighbourList(List<GraphNode> neighbourList) {
        this.neighbourList = neighbourList;
    }

    public GraphNode(int data) {
        super();
        this.data = data;
    }

    public GraphNode() {
    }

    @Override
    public String toString() {
        return "GraphNode [data=" + data + ", neighbourList=" + neighbourList + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + data;
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
        if (data != other.data)
            return false;
        return true;
    }

}
