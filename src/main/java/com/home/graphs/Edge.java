package com.home.graphs;

@SuppressWarnings("rawtypes")
public class Edge implements Comparable {
    public Vertex srcVert;
    public Vertex destVert;
    public int distance;

    public Edge(Vertex sv, Vertex dv, int d) {
        srcVert = sv;
        destVert = dv;
        distance = d;
    }

    public Vertex getSrcVert() {
        return srcVert;
    }

    public void setSrcVert(Vertex srcVert) {
        this.srcVert = srcVert;
    }

    public Vertex getDestVert() {
        return destVert;
    }

    public void setDestVert(Vertex destVert) {
        this.destVert = destVert;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int compareTo(Object o) {
        return this.getDistance().compareTo(((Edge) o).getDistance());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((destVert == null) ? 0 : destVert.hashCode());
        result = prime * result + distance;
        result = prime * result + ((srcVert == null) ? 0 : srcVert.hashCode());
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
        Edge other = (Edge) obj;
        if (destVert == null) {
            if (other.destVert != null)
                return false;
        } else if (!destVert.equals(other.destVert))
            return false;
        if (distance != other.distance)
            return false;
        if (srcVert == null) {
            if (other.srcVert != null)
                return false;
        } else if (!srcVert.equals(other.srcVert))
            return false;
        return true;
    }

}
