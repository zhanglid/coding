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
        int key;
        Node next;
        Node prev;

        public Node(int key) {
            this.key = key;
        }
    }

    private Node head;
    private Node tail;
    private Map<Integer, Integer> valueMap = new HashMap<>();
    private Map<Integer, Node> nodeMap = new HashMap<>();
    private int capacity;

    public LRUCache(int capacity) {
        head = new Node(-1);
        tail = head;
        this.capacity = capacity;
    }

    private void refresh(int key) {
        Node node = nodeMap.get(key);
        if (node != tail) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
    }

    public int get(int key) {
        if (!valueMap.containsKey(key)) {
            return -1;
        }
        refresh(key);
        return valueMap.get(key);
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (valueMap.containsKey(key)) {
            valueMap.put(key, value);
            refresh(key);
            return;
        }
        if (valueMap.size() >= capacity) {
            nodeMap.remove(head.next.key);
            valueMap.remove(head.next.key);
            head.next = head.next.next;
            if (head.next != null) {
                head.next.prev = head;
            } else {
                tail = head;
            }
        }
        tail.next = new Node(key);
        tail.next.prev = tail;
        valueMap.put(key, value);
        nodeMap.put(key, tail.next);
        tail = tail.next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */