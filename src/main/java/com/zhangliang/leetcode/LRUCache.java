package com.zhangliang.leetcode;
/*
Design and implement a data structure for Least Recently Used (LRU) cache. 
It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key 
exists in the cache, otherwise return -1.

put(key, value) - Set or insert the value if the key is not already present. 
When the cache reached its capacity, it should invalidate the least recently used 
item before inserting a new item.

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
        Node next;
        Node prev;
        int key;
    }

    private Node head = new Node();
    private Node tail;
    private Map<Integer, Integer> values;
    private Map<Integer, Node> nodes;
    private int capacity;

    private void refresh(int key) {
        Node node = nodes.get(key);
        removeNode(node);
        attach(node);
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        if (node != tail) {
            node.next.prev = node.prev;
            node.next = null;
        } else {
            tail = node.prev;
        }
    }

    private void attach(Node node) {
        tail.next = node;
        node.prev = tail;
        tail = node;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.values = new HashMap<>();
        this.nodes = new HashMap<>();
        tail = this.head;
    }

    public int get(int key) {
        if (values.containsKey(key)) {
            int value = values.get(key);
            refresh(key);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        values.put(key, value);
        if (nodes.containsKey(key)) {
            // already exists
            refresh(key);
            return;
        }
        // create new node
        Node node = new Node();
        node.key = key;
        if (nodes.size() >= capacity) {
            Node toBeRemoved = head.next;
            removeNode(toBeRemoved);
            values.remove(toBeRemoved.key);
            nodes.remove(toBeRemoved.key);
        }
        attach(node);
        nodes.put(key, node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */