package com.home.flipkart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// /https://algorithmstuff.wordpress.com/2013/10/27/clone-a-graph/
public class CloneGraph {

    public static void main(String[] args) {

        GraphNode gn1 = new GraphNode(1);
        GraphNode gn2 = new GraphNode(2);
        GraphNode gn3 = new GraphNode(3);
        GraphNode gn4 = new GraphNode(4);
        GraphNode gn5 = new GraphNode(5);
        gn1.getNeighbourList().add(gn5);
        gn1.getNeighbourList().add(gn4);
        gn4.getNeighbourList().add(gn3);
        gn5.getNeighbourList().add(gn2);

        System.out.println(gn1);
        System.out.println(cloneGraphUsingBFS(gn1));
        System.out.println(cloneGraphUsingDFS(gn1, null));

    }

    public static GraphNode cloneGraphUsingBFS(GraphNode graphNode) {
        GraphNode gn = new GraphNode(graphNode.getData());
        Queue<GraphNode> queue = new LinkedList<GraphNode>();
        queue.add(graphNode);
        Map<GraphNode, GraphNode> hashMap = new HashMap<GraphNode, GraphNode>();
        hashMap.put(graphNode, gn);
        while (!queue.isEmpty()) {
            GraphNode temp = queue.remove();
            List<GraphNode> nList = temp.getNeighbourList();
            for (GraphNode nNode : nList) {
                if (hashMap.get(nNode) == null) {
                    GraphNode dummy = new GraphNode(nNode.getData());
                    queue.add(nNode);
                    hashMap.put(nNode, dummy);
                    hashMap.get(temp).getNeighbourList().add(dummy);
                } else {
                    hashMap.get(temp).getNeighbourList().add(hashMap.get(nNode));
                }
            }
        }
        return gn;
    }

    //O(|V| + |E|) 
    public static GraphNode cloneGraphUsingDFS(GraphNode graphNode, Map<GraphNode, GraphNode> map) {
        if (map == null)
            map = new HashMap<GraphNode, GraphNode>();
        if (map.get(graphNode) != null) {
            map.get(graphNode);
        }
        GraphNode nNode = new GraphNode(graphNode.getData());
        List<GraphNode> list = new ArrayList<GraphNode>();
        for (GraphNode node : graphNode.getNeighbourList()) {
            list.add(cloneGraphUsingDFS(node, map));
        }
        nNode.setNeighbourList(list);
        return nNode;
    }
}
