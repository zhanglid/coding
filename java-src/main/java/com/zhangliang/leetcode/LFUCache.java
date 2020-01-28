package com.zhangliang.leetcode;
/*
Design and implement a data structure for Least Frequently Used (LFU) cache. 
It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key 
if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value 
if the key is not already present. When the cache reaches its capacity, 
it should invalidate the least frequently used item 
before inserting a new item. For the purpose of this problem, 
when there is a tie (i.e., two or more keys that have the same frequency), 
the least recently used key would be evicted.

Note that the number of times an item is used is the number of calls 
to the get and put functions for that item since it was inserted. 
This number is set to zero when the item is removed.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LFUCache cache = new LFUCache(2); // capacity

cache.put(1,1);cache.put(2,2);cache.get(1); // returns 1
cache.put(3,3); // evicts key 2
cache.get(2); // returns -1 (not found)
cache.get(3); // returns 3.
cache.put(4,4); // evicts key 1.
cache.get(1); // returns -1 (not found)
cache.get(3); // returns 3
cache.get(4); // returns 4
*/

import java.util.*;

public class LFUCache {
    class FrequencyKeyGroup {
        int frequency;
        LinkedList<Integer> keyList;
        FrequencyKeyGroup next;
        FrequencyKeyGroup prev;

        public FrequencyKeyGroup(int frequency) {
            this.frequency = frequency;
            this.keyList = new LinkedList<>();
        }
    }

    private Map<Integer, Integer> valueMap = new HashMap<>();
    private Map<Integer, FrequencyKeyGroup> fkgMap = new HashMap<>();
    private int capacity;
    private FrequencyKeyGroup head;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        head = new FrequencyKeyGroup(0);
    }

    private Integer getLastFrequentlyUsedKey() {
        return head.next == null ? null : head.next.keyList.size() > 0 ? head.next.keyList.get(0) : null;
    }

    private void removeLast() {
        Integer lastKey = getLastFrequentlyUsedKey();
        if (lastKey != null) {
            head.next.keyList.removeFirst();
        }
        valueMap.remove(lastKey);
        fkgMap.remove(lastKey);
        if (head.next.keyList.size() == 0) {
            head.next = head.next.next;
        }
    }

    private void addFrequency(int key) {
        FrequencyKeyGroup group = fkgMap.get(key);
        if (group.next == null || group.next.frequency != group.frequency + 1) {
            FrequencyKeyGroup next = group.next;
            group.next = new FrequencyKeyGroup(group.frequency + 1);
            group.next.prev = group;
            group.next.next = next;
            if (next != null) {
                next.prev = group.next;
            }
        }

        group.keyList.removeFirstOccurrence(key);
        group.next.keyList.add(key);
        fkgMap.put(key, group.next);
        if (group.prev != null && group.keyList.size() == 0) {
            group.prev.next = group.next;
            if (group.next != null) {
                group.next.prev = group.prev;
            }
        }
    }

    public int get(int key) {
        if (!valueMap.containsKey(key)) {
            return -1;
        }
        addFrequency(key);
        return valueMap.get(key);
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (!valueMap.containsKey(key)) {
            if (valueMap.size() >= capacity) {
                removeLast();
            }
            head.keyList.add(key);
            fkgMap.put(key, head);
        }
        valueMap.put(key, value);
        addFrequency(key);
    }
}
