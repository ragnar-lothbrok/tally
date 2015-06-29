package com.home.graphs;

public class DistPar<T> {

    private int distance;
    private Vertex<T> parentVert;

    public DistPar(Vertex<T> pv, int d) {
        distance = d;
        parentVert = pv;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Vertex<T> getParentVert() {
        return parentVert;
    }

    public void setParentVert(Vertex<T> parentVert) {
        this.parentVert = parentVert;
    }

    @Override
    public String toString() {
        return "DistPar [distance=" + distance + ", parentVert=" + parentVert + "]";
    }

}
