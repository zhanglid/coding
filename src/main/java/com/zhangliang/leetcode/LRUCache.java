package com.zhangliang.leetcode;
/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2  <capacity>  );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
*/

import java.util.*;

class LRUCache {
    class Node {
        int key;
        int value;
        Node next;
        Node previous;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> nodes;
    private int capacity;
    private Node head;
    private Node tail;

    private void updateFreshness(Node node) {
        removeNodeInList(node);
        appendNodeLast(node);
    }

    private void removeNodeInList(Node node) {
        node.previous.next = node.next;
        if (node.next != null) {
            node.next.previous = node.previous;
        }
        if (node == tail) {
            tail = node.previous;
        }
    }

    /**
     * Check the current capacity, remove the if full.
     */
    private void ensureCapacity() {
        if (nodes.size() >= capacity) {
            Node nodeToBeRemoved = head.next;
            removeNodeInList(nodeToBeRemoved);
            nodes.remove(nodeToBeRemoved.key);
        }
    }

    private void appendNodeLast(Node node) {
        tail.next = node;
        node.previous = tail;
        node.next = null;
        tail = node;
    }

    public LRUCache(int capacity) {
        nodes = new HashMap<>();
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = head;
    }

    public int get(int key) {
        if (!nodes.containsKey(key)) {
            return -1;
        }
        Node node = nodes.get(key);
        updateFreshness(node);
        return node.value;
    }

    public void put(int key, int value) {
        // if the key is in the cache, just update;
        if (nodes.containsKey(key)) {
            Node node = nodes.get(key);
            node.value = value;
            updateFreshness(node);
        } else {
            ensureCapacity();
            Node node = new Node(key, value);
            nodes.put(key, node);
            appendNodeLast(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */