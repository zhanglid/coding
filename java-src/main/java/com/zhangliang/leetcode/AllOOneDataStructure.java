package com.zhangliang.leetcode;
/*
Implement a data structure supporting the following operations:

Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. Key is guaranteed to be a non-empty string.
Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise decrements an existing key by 1. 
If the key does not exist, this function does nothing. Key is guaranteed to be a non-empty string.
GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty string "".
GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty string "".
Challenge: Perform all these in O(1) time complexity.
*/

import java.util.*;

public class AllOOneDataStructure {
    static class AllOne {
        class Node {
            int value;
            Node prev;
            Node next;
            Set<String> keySet;

            public Node(int value) {
                this.value = value;
                this.keySet = new HashSet<>();
            }
        }

        Node head = new Node(-1); // Dummy head node.
        Node tail = head;
        Map<String, Node> nodeMap = new HashMap<>();

        /** Initialize your data structure here. */
        public AllOne() {

        }

        private void ensureValueNodeAfter(Node node, int value) {
            if (node.next == null || node.next.value != value) {
                Node next = node.next;
                node.next = new Node(value);
                node.next.prev = node;
                node.next.next = next;
                if (next != null) {
                    next.prev = node.next;
                } else {
                    tail = node.next;
                }
            }
        }

        /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
        public void inc(String key) {
            if (!nodeMap.containsKey(key)) {
                ensureValueNodeAfter(head, 1);
                head.next.keySet.add(key);
                nodeMap.put(key, head.next);
            } else {
                Node node = nodeMap.get(key);
                ensureValueNodeAfter(node, node.value + 1);
                node.next.keySet.add(key);
                node.keySet.remove(key);
                nodeMap.put(key, node.next);
                if (node.keySet.size() == 0) {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }
            }
        }

        /**
         * Decrements an existing key by 1. If Key's value is 1, remove it from the data
         * structure.
         */
        public void dec(String key) {
            // Check whether we have the key.
            if (nodeMap.containsKey(key)) {
                // Get the node contains the key.
                Node node = nodeMap.get(key);

                // We have to move the key.
                node.keySet.remove(key);
                nodeMap.remove(key);

                // Only move the key to previous node when value is greater than 1.
                if (node.value > 1) {
                    if (node.prev.value != node.value - 1) {
                        ensureValueNodeAfter(node.prev, node.value - 1);
                    }
                    node.prev.keySet.add(key);
                    nodeMap.put(key, node.prev);
                }

                // Remove the node if the node becomes empty.
                if (node.keySet.isEmpty()) {
                    node.prev.next = node.next;
                    if (node.next != null) {
                        node.next.prev = node.prev;
                    } else {
                        tail = node.prev;
                    }
                }
            }
        }

        /** Returns one of the keys with maximal value. */
        public String getMaxKey() {
            return tail.keySet.iterator().next();
        }

        /** Returns one of the keys with Minimal value. */
        public String getMinKey() {
            return head.next.keySet.iterator().next();
        }
    }

    /**
     * Your AllOne object will be instantiated and called as such: AllOne obj = new
     * AllOne(); obj.inc(key); obj.dec(key); String param_3 = obj.getMaxKey();
     * String param_4 = obj.getMinKey();
     */
}
