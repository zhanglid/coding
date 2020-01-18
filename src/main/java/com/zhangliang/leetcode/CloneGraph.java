package com.zhangliang.leetcode;
/*
Clone an undirected graph. Each node in the graph contains a label and a list of its 
neighbors.

OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each 
neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/

*/

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {
    private void shallowClone(Node node, Map<Node, Node> cloned) {
        if (cloned.containsKey(node)) {
            return;
        }
        Node clonedNode = new Node(node.val);
        cloned.put(node, clonedNode);
        for (Node other : node.neighbors) {
            shallowClone(other, cloned);
        }
    }

    private void buildClonedNeighbors(Node node, Map<Node, Node> cloned) {
        // Check already cloned nodes.
        if (node.neighbors.size() > 0 && cloned.get(node).neighbors.size() > 0) {
            return;
        }

        cloned.get(node).neighbors = new ArrayList<>();
        for (Node other : node.neighbors) {
            cloned.get(node).neighbors.add(cloned.get(other));
            buildClonedNeighbors(other, cloned);
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> cloned = new HashMap<>();
        shallowClone(node, cloned);
        buildClonedNeighbors(node, cloned);
        return cloned.get(node);
    }
}
