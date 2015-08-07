package com.home.heap;

import java.util.ArrayList;
import java.util.List;

public class MaxHeapConstructionService<T> {

    private List<HeapNode<T>> heapNodesList = new ArrayList<HeapNode<T>>();

    public void addoToHeap(HeapNode<T> heapNode) {
        if (heapNodesList.size() == 0) {
            heapNodesList.add(heapNode);
        } else {
            Integer currentPos = heapNodesList.indexOf(heapNode);
            if (currentPos != -1) {
                heapNode.setWeight(heapNodesList.get(currentPos).getWeight() + 1);
                heapNodesList.set(currentPos, heapNode);
            } else {
                heapNodesList.add(heapNode);
                currentPos = heapNodesList.size() - 1;
            }
            Integer parentPos = (currentPos - 1) / 2;
            while (heapNodesList.get(parentPos).getWeight() < heapNodesList.get(currentPos).getWeight()) {
                swap(parentPos, currentPos);
                currentPos = parentPos;
                parentPos = (currentPos - 1) / 2;
            }
        }
    }

    private void swap(Integer parentPos, Integer currentPos) {
        HeapNode<T> parent = heapNodesList.get(parentPos);
        heapNodesList.set(parentPos, heapNodesList.get(currentPos));
        heapNodesList.set(currentPos, parent);
    }

    public List<HeapNode<T>> getHeapNodesList() {
        return heapNodesList;
    }

    public void setHeapNodesList(List<HeapNode<T>> heapNodesList) {
        this.heapNodesList = heapNodesList;
    }

    @Override
    public String toString() {
        return "HeapConstructionService [heapNodesList=" + heapNodesList + "]";
    }

    public List<HeapNode<T>> getTopHeapNodes(int limit) {
        List<HeapNode<T>> topElementList = null;
        if (limit < heapNodesList.size()) {
            topElementList = new ArrayList<HeapNode<T>>();
            while (limit > topElementList.size()) {
                topElementList.add(heapNodesList.get(0));
                removeFromHeap(0);
                System.out.println(topElementList.size()+" "+heapNodesList);
            }
        }
        return topElementList;
    }

    public void removeElementFromHeap(HeapNode<T> heapNode) {
        if (heapNodesList.size() > 0) {
            int index = heapNodesList.indexOf(heapNode);
            if (index != -1) {
                removeFromHeap(index);
            }
        }
    }

    public void removeFromHeap(int position) {
        if (heapNodesList.size() > 0 && position < heapNodesList.size() && position >= 0) {
            heapNodesList.set(position, heapNodesList.get(heapNodesList.size() - 1));
            heapNodesList.remove(heapNodesList.size() - 1);
            hepify(position);
        }
    }

    public void hepify(Integer position) {
        if (position >= 0 && position < heapNodesList.size()) {
            while (true) {
                Integer left = 2 * position + 1;
                Integer right = 2 * position + 2;
                if (left >= heapNodesList.size()) {
                    break;
                }
                if (right >= heapNodesList.size()) {
                    right = left;
                }
                int maxValueIndex = (heapNodesList.get(left).getWeight() > heapNodesList.get(right).getWeight() ? left
                        : right);
                if (heapNodesList.get(maxValueIndex).getWeight() > heapNodesList.get(position).getWeight()) {
                    swap(position, maxValueIndex);
                    position = maxValueIndex;
                } else {
                    break;
                }
            }
        }
    }

}
