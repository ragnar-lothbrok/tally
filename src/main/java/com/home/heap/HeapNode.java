package com.home.heap;

public class HeapNode<T> {

    private T t;
    private int weight;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public HeapNode(T t, int weight) {
        super();
        this.t = t;
        this.weight = weight;
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
        @SuppressWarnings("rawtypes")
        HeapNode other = (HeapNode) obj;
        if (t == null) {
            if (other.t != null)
                return false;
        } else if (!t.equals(other.t))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "HeapNode [t=" + t + ", weight=" + weight + "]\n";
    }

}
