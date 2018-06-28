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

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class Node {
        Node next;
        Node prev;
        int val;

        public Node(int x) {
            val = x;
        }

        public void remove() {
            if (prev != null) {
                prev.next = next;
            }

            if (next != null) {
                next.prev = prev;
            }
            next = null;
            prev = null;
        }
    }

    private Map<Integer, Integer> map;
    private Map<Integer, Node> nodeMap;
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        nodeMap = new HashMap<>(capacity);
        head = new Node(-1);
        tail = head;
    }

    public int get(int key) {
        Node node = nodeMap.getOrDefault(key, null);
        if (node == null) {
            return -1;
        }
        if (node == tail) {
            tail = node.prev;
        }
        node.remove();
        tail.next = node;
        node.prev = tail;
        tail = node;
        nodeMap.put(key, tail);
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        while (map.size() + 1 > capacity) {
            int valueToRemove = head.next.val;
            if (head.next == tail) {
                tail = head;
            }
            head.next.remove();
            map.remove(valueToRemove);
            nodeMap.remove(valueToRemove);
        }

        map.put(key, value);
        if (nodeMap.containsKey(key)) {
            Node nextNode = nodeMap.get(key);
            if (nextNode == tail) {
                tail = nextNode.prev;
            }
            nextNode.remove();
            nodeMap.remove(key);
        }
        tail.next = new Node(key);
        tail.next.prev = tail;
        nodeMap.put(key, tail.next);
        tail = tail.next;
    }
}
