package com.zhangliang.leetcode;
/*
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.zhangliang.utils.UndirectedGraphNode;

public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }

        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode toBeCloned = queue.poll();
            UndirectedGraphNode cloned = new UndirectedGraphNode(toBeCloned.label);
            cloned.neighbors = toBeCloned.neighbors;
            map.put(toBeCloned, cloned);
            for (UndirectedGraphNode curNode : cloned.neighbors) {
                if (!map.containsKey(curNode)) {
                    queue.add(curNode);
                    map.put(curNode, null);
                }
            }
        }

        for (UndirectedGraphNode cur : map.values()) {
            List<UndirectedGraphNode> clonedNeighbors = new ArrayList<>();
            for (int i = 0; i < cur.neighbors.size(); i++) {
                clonedNeighbors.add(map.get(cur.neighbors.get(i)));
            }
            cur.neighbors = clonedNeighbors;
        }

        return map.get(node);
    }
}
