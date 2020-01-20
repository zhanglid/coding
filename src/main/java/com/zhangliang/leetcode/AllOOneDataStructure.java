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
            int freq;
            Set<String> keys;
            Node next;
            Node prev;

            public Node(int freq) {
                this.freq = freq;
                keys = new HashSet<>();
            }
        }

        private Node head = new Node(-1);
        private Node tail = head;

        Map<String, Node> nodeMap = new HashMap<>();

        /** Initialize your data structure here. */
        public AllOne() {

        }

        private Node createNodeAfter(Node node, int value) {
            Node next = node.next;
            node.next = new Node(value);
            node.next.prev = node;
            node.next.next = next;
            if (next != null) {
                next.prev = node.next;
            } else {
                tail = node.next;
            }
            return node.next;
        }

        private void removeNode(Node node) {
            node.prev.next = node.next;
            if (node.next != null) {
                node.next.prev = node.prev;
            } else {
                tail = node.prev;
            }
        }

        /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
        public void inc(String key) {
            if (nodeMap.containsKey(key)) {
                Node node = nodeMap.get(key);
                // Move to next
                node.keys.remove(key);
                // Create freq node
                if (node.next == null || node.next.freq != node.freq + 1) {
                    createNodeAfter(node, node.freq + 1);
                }
                node.next.keys.add(key);
                nodeMap.put(key, node.next);
                if (node.keys.size() == 0) {
                    removeNode(node);
                }
            } else {
                if (head.next == null || head.next.freq != 1) {
                    createNodeAfter(head, 1);
                }
                head.next.keys.add(key);
                nodeMap.put(key, head.next);
            }
        }

        /**
         * Decrements an existing key by 1. If Key's value is 1, remove it from the data
         * structure.
         */
        public void dec(String key) {
            if (!nodeMap.containsKey(key)) {
                return;
            }
            Node node = nodeMap.get(key);
            node.keys.remove(key);
            int freq = node.freq - 1;
            // Attention: Node should be removed when freq == 0;
            if (freq != 0) {
                if (node.prev.freq != freq) {
                    createNodeAfter(node.prev, freq);
                }
                node.prev.keys.add(key);
                nodeMap.put(key, node.prev);
            } else {
                nodeMap.remove(key);
            }

            if (node.keys.size() == 0) {
                removeNode(node);
            }
        }

        /** Returns one of the keys with maximal value. */
        public String getMaxKey() {
            if (head == tail) {
                return "";
            }
            return tail.keys.iterator().next();
        }

        /** Returns one of the keys with Minimal value. */
        public String getMinKey() {
            if (head == tail) {
                return "";
            }
            return head.next.keys.iterator().next();
        }
    }

    /**
     * Your AllOne object will be instantiated and called as such: AllOne obj = new
     * AllOne(); obj.inc(key); obj.dec(key); String param_3 = obj.getMaxKey();
     * String param_4 = obj.getMinKey();
     */
}
