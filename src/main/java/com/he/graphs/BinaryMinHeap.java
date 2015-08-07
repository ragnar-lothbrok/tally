package com.he.graphs;

import java.util.ArrayList;
import java.util.List;

public class BinaryMinHeap {

    private List<HeapNode> heap = new ArrayList<HeapNode>();

    public List<HeapNode> getHeap() {
        return heap;
    }

    public void setHeap(List<HeapNode> heap) {
        this.heap = heap;
    }

    public void add(Object node, Long weight) {
        add(new HeapNode(node, weight));
    }

    public void add(HeapNode heapNode) {
        heap.add(heapNode);
        Integer currentPos = heap.size() - 1;
        Integer parentPos = (currentPos - 1) / 2;
        while (parentPos >= 0 && heap.get(parentPos).getWeight() > heap.get(currentPos).getWeight()) {
            swap(parentPos, currentPos);
            currentPos = parentPos;
            parentPos = (currentPos - 1) / 2;
        }
    }

    public void removeFromMinHeap(Object data) {
        int position = -1;
        for (int i = 0; i < heap.size(); i++) {
            if (heap.get(i).getNode().equals(data)) {
                position = i;
                break;
            }
        }
        if (position != -1) {
            swap(heap.size() - 1, position);
            heap.remove(heap.size() - 1);
            rebuildHeap(position);
        }
    }

    public HeapNode removeMin() {
        int position = -1;
        HeapNode heapNode = null;
        if (heap.size() > 0) {
            position = 0;
        }
        if (position != -1) {
            swap(heap.size() - 1, position);
            heapNode = heap.remove(heap.size() - 1);
            rebuildHeap(position);
        }
        return heapNode;
    }

    private void rebuildHeap(int currentIndex) {
        int size = heap.size() - 1;
        while (true) {
            int left = 2 * currentIndex + 1;
            int right = 2 * currentIndex + 2;
            if (left > size) {
                break;
            }
            if (right > size) {
                right = left;
            }
            int smallerIndex = heap.get(left).getWeight() <= heap.get(right).getWeight() ? left : right;
            if (heap.get(currentIndex).getWeight() > heap.get(smallerIndex).getWeight()) {
                swap(currentIndex, smallerIndex);
                currentIndex = smallerIndex;
            } else {
                break;
            }
        }
    }

    private void swap(Integer parentPos, Integer currentPos) {
        HeapNode parent = heap.get(parentPos);
        heap.set(parentPos, heap.get(currentPos));
        heap.set(currentPos, parent);
    }

    public static void main(String[] args) {

        BinaryMinHeap binaryHeap = new BinaryMinHeap();
        binaryHeap.add(new HeapNode("ABC", 1l));
        binaryHeap.add(new HeapNode("Tushar", 3l));
        binaryHeap.add(new HeapNode("Ani", 4l));
        binaryHeap.add(new HeapNode("Vijay", 8l));
        binaryHeap.add(new HeapNode("Pramila", 10l));
        binaryHeap.add(new HeapNode("Roy", 5l));
        binaryHeap.add(new HeapNode("NTF", 6l));
        binaryHeap.add(new HeapNode("AFR", 2l));
        System.out.println(binaryHeap.heap);

        binaryHeap.removeFromMinHeap(binaryHeap.heap.get(1).getNode());

        System.out.println(binaryHeap.heap);

    }
}

class HeapNode {

    private Object node;
    private Long weight;

    public HeapNode(Object node, Long weight) {
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
}
