package com.home.graphs;

public class Vertex<T> implements Comparable<T>{
    private T t;

    private boolean visited;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Vertex(T t) {
        super();
        this.t = t;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((t == null) ? 0 : t.hashCode());
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
        Vertex<?> other = (Vertex<?>) obj;
        if (t == null) {
            if (other.t != null)
                return false;
        } else if (!t.equals(other.t))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Vertex [t=" + t + ", visited=" + visited + "]";
    }

    //Added just to support PriorityQueue
    public int compareTo(T o) {
        return 0;
    }

}
